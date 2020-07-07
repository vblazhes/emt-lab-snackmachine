package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Slot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.SnackMachine;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SlotId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackMachineId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.PurchaseRepository;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.SlotRepository;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.SnackMachineRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataGenerator {
    private final SnackMachineRepository snackMachineRepository;
    private final SlotRepository slotRepository;
    private final PurchaseRepository purchaseRepository;

    public DataGenerator(SnackMachineRepository snackMachineRepository, SlotRepository slotRepository, PurchaseRepository purchaseRepository) {
        this.snackMachineRepository = snackMachineRepository;
        this.slotRepository = slotRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @PostConstruct
    @Transactional
    public void generateSnackData(){
        if(snackMachineRepository.findAll().size() == 0){
            var snackMachine = new SnackMachine(new SnackMachineId("snackmachineid1"));
            snackMachineRepository.save(snackMachine);

            Set<Slot> slots = new HashSet<>();

            slots.add(createSlot(new SlotId("slotId1"), new SnackId("1"), 1, new Money(15), snackMachine.id()));
            slots.add(createSlot(new SlotId("slotId2"), new SnackId("2"), 2, new Money(20), snackMachine.id()));
            slots.add(createSlot(new SlotId("slotId3"), new SnackId("3"), 3, new Money(30), snackMachine.id()));
            slots.add(createSlot(new SlotId("slotId4"), new SnackId("4"), 4, new Money(30), snackMachine.id()));
            slots.add(createSlot(new SlotId("slotId5"), new SnackId("5"), 5, new Money(30), snackMachine.id()));

            slotRepository.saveAll(slots);
        }
    }

    private Slot createSlot(SlotId slotId, SnackId snackId, int position, Money price, SnackMachineId snackMachineId){
        var slot = new Slot(slotId, snackId, position, price, snackMachineId);
        return slot;
    }
}
