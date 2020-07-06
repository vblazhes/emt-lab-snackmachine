package mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.port.controller;

import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.application.StudentCardService;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.application.dto.StudentCardDto;
import mk.ukim.finki.emt.labs.dormitorysnackmachine.studentcard.domain.model.identifier.StudentCardId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/studentcards")
public class StudentCardController {
    private final StudentCardService studentCardService;

    public StudentCardController(StudentCardService studentCardService) {
        this.studentCardService = studentCardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCardDto> getStudentCardById(@PathVariable("id") String studentCardId){
        return studentCardService.findStudentCardById(new StudentCardId(studentCardId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
