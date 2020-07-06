package mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.port.controller;

import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.SnackMachineService;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysmartsnackmachine.snackmachine.domain.model.identifier.StudentCardId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/snackmachine")
public class SnackMachineController {
    private SnackMachineService snackMachineService;

    public SnackMachineController(SnackMachineService snackMachineService) {
        this.snackMachineService = snackMachineService;
    }

    @GetMapping("/{id}")
    public StudentCardDto insertStudentCard(@PathVariable("id") String studentCardId){
        return snackMachineService.findStudentCardById(new StudentCardId(studentCardId));
    }
}
