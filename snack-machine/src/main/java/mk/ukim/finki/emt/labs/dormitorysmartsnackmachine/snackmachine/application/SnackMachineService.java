package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.PurchaseDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.event.PurchaseForSnackCreated;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Purchase;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Slot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.SnackMachine;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.PurchaseRepository;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.SlotRepository;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.SnackMachineRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SnackMachineService {
    private final SnackMachineRepository snackMachineRepository;
    private final SlotRepository slotRepository;
    private final PurchaseRepository purchaseRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final Validator validator;
    private final Snack snack;
    private final StudentCard studentCard;

    public SnackMachineService(SnackMachineRepository snackMachineRepository,
                               SlotRepository slotRepository,
                               PurchaseRepository purchaseRepository,
                               ApplicationEventPublisher applicationEventPublisher,
                               Snack snack,
                               StudentCard studentCard,
                               Validator validator) {
        this.snackMachineRepository = snackMachineRepository;
        this.slotRepository = slotRepository;
        this.purchaseRepository = purchaseRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.snack = snack;
        this.studentCard = studentCard;
        this.validator = validator;
    }

    public Optional<StudentCardDto> findStudentCardById(@NonNull StudentCardId studentCardId){
        return studentCard.findById(studentCardId);
    }

    public void createPurchase(@NonNull PurchaseDto purchaseDto){
        Objects.requireNonNull(purchaseDto, "purchase must be non null");

        var constraintsViolations = validator.validate(purchaseDto);

        if(constraintsViolations.size() > 0){
            throw new ConstraintViolationException("THe PurchaseDto is not valid ", constraintsViolations);
        }

        Slot slot = slotRepository.findByPosition(purchaseDto.slotPosition);
        if(slot == null){
            throw new IllegalArgumentException();
        }

        var newPurchase = purchaseRepository.saveAndFlush(toDomainModel(purchaseDto, slot));

//        applicationEventPublisher.publishEvent(new PurchaseForSnackCreated(newPurchase.id()));
    }

    @NonNull
    private Purchase toDomainModel(@NonNull PurchaseDto purchaseDto, Slot slot) {
        SnackMachine snackmachine = snackMachineRepository.findAll().stream().findFirst().get();
        var purchase = new Purchase(Instant.now(), slot.getPrice(), new StudentCardId(purchaseDto.studentCardId), slot.getSnackId(), snackmachine.id());
        return purchase;
    }
}
