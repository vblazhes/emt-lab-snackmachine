package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.port.controller;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.SnackMachineService;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.PurchaseDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Purchase;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.Slot;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.SnackMachine;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snackmachine")
public class SnackMachineController {
    private SnackMachineService snackMachineService;

    public SnackMachineController(SnackMachineService snackMachineService) {
        this.snackMachineService = snackMachineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCardDto> insertStudentCard(@PathVariable("id") String studentCardId){
        return snackMachineService.findStudentCardById(new StudentCardId(studentCardId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseDto> insertStudentCard(@RequestBody PurchaseDto purchaseDto){
        snackMachineService.createPurchase(purchaseDto);
        return ResponseEntity.ok(purchaseDto);
    }

    @GetMapping("/slots")
    public ResponseEntity<List<Slot>> getAllSlots(){
        return ResponseEntity.ok(snackMachineService.getAllSlots());
    }

    @GetMapping
    public ResponseEntity<SnackMachine> getSnackMachine(){
        return ResponseEntity.ok(snackMachineService.getSnackMachine());
    }
}
