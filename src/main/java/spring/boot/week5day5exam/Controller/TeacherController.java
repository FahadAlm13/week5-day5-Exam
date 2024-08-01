package spring.boot.week5day5exam.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.boot.week5day5exam.ApiResponse.ApiTeacher;
import spring.boot.week5day5exam.Model.Teacher;
import spring.boot.week5day5exam.Service.TeacherService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    //get
    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        ArrayList<Teacher> teachers = teacherService.getTeachers();
        return ResponseEntity.status(200).body(teachers);
    }
    //post
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors error){
        if(error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Success to add teacher");
    }
    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher,@PathVariable int id , Errors error){
        if(error.hasErrors()){
            String message = error.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (teacherService.updateTeacher(teacher, id)) {
            return ResponseEntity.status(200).body("Success to update teacher");
        }else return ResponseEntity.status(400).body("Error to update teacher");
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        if (teacherService.deleteTeacher(id)) {
            return ResponseEntity.status(200).body("Success to delete teacher");
        }else return ResponseEntity.status(400).body("Error to delete teacher");
    }
    @GetMapping("/getTeacher/{id}")
    public ResponseEntity getTeacherById(@PathVariable int id){
        if (teacherService.getTeacherById(id) != null) {
            return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
        }else return ResponseEntity.status(400).body("Error to find teacher");
    }

}
