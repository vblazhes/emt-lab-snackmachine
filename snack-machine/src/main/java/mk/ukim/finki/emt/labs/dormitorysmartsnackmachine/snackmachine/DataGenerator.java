package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.sharedkernel.financial.Money;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Slot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.SnackMachine;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SlotId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.SnackMachineId;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.repository.SnackMachineRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataGenerator {
    private final SnackMachineRepository snackMachineRepository;

    public DataGenerator(SnackMachineRepository snackMachineRepository) {
        this.snackMachineRepository = snackMachineRepository;
    }

    @PostConstruct
    @Transactional
    public void generateSnackData(){
        if(snackMachineRepository.findAll().size() == 0){
            var snackMachine = new SnackMachine(new SnackMachineId("snackmachineid1"));

            Set<Slot> slots = new HashSet<>();

            slots.add(createSlot(new SlotId("slotId1"), new SnackId("1"), 1, new Money(15)));
            slots.add(createSlot(new SlotId("slotId2"), new SnackId("2"), 2, new Money(20)));
            slots.add(createSlot(new SlotId("slotId3"), new SnackId("3"), 3, new Money(30)));
            slots.add(createSlot(new SlotId("slotId4"), new SnackId("4"), 4, new Money(30)));
            slots.add(createSlot(new SlotId("slotId5"), new SnackId("5"), 5, new Money(30)));

            snackMachine.setSlots(slots);

            snackMachineRepository.save(snackMachine);
        }
    }

    private Slot createSlot(SlotId slotId, SnackId snackId, int position, Money price){
        var slot = new Slot(slotId, snackId, position, price);
        return slot;
    }
}
