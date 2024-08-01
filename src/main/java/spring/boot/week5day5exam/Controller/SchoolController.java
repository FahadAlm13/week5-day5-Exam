package spring.boot.week5day5exam.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.boot.week5day5exam.ApiResponse.ApiSchool;
import spring.boot.week5day5exam.Model.School;
import spring.boot.week5day5exam.Service.SchoolService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/get")
    public ResponseEntity getSchool() {
        ArrayList<School> schools = schoolService.getSchools();
        return ResponseEntity.status(200).body(schools);
    }

    //post
    @PostMapping("/add")
    public ResponseEntity addSchool(@Valid @RequestBody School school, Errors error) {
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        schoolService.addSchool(school);
        return ResponseEntity.status(200).body(new ApiSchool("Student added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSchool(@Valid @RequestBody School school, @PathVariable int id, Errors error) {
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (schoolService.updateSchool(school, id)) {
            return ResponseEntity.status(200).body(new ApiSchool("Student  updated successfully"));
        } else return ResponseEntity.status(400).body(new ApiSchool("Student  update failed"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSchool(@PathVariable int id) {
        if (schoolService.deleteSchool(id) ) {
            return ResponseEntity.status(200).body(new ApiSchool("Student deleted successfully"));
        } else return ResponseEntity.status(400).body(new ApiSchool("Student delete failed"));
    }
    @GetMapping("/getSchoolByName/{name}")
    public ResponseEntity getSchoolByName(@PathVariable String name) {
        if (schoolService.getSchoolByName(name) != null) {
            return ResponseEntity.status(200).body(schoolService.getSchoolByName(name));
        }
        else return ResponseEntity.status(400).body(new ApiSchool("Student not found"));
    }
    @GetMapping("/getAllByMajor/{major}")
    public ResponseEntity getByMajor(@PathVariable String major) {
        if (schoolService.getSchoolByMajor(major).isEmpty()){
            return ResponseEntity.status(400).body(new ApiSchool("Student not found"));
        }
        else return ResponseEntity.status(200).body(schoolService.getSchoolByMajor(major));
    }
//        if (schoolService.getSchoolByMajor(major) != null){
//            return ResponseEntity.status(200).body(schoolService.getSchoolByMajor(major));
//        }
//        else return ResponseEntity.status(400).body(new ApiSchool("Student not found"));
//    }
}
