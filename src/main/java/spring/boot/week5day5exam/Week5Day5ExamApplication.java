package spring.boot.week5day5exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week5Day5ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week5Day5ExamApplication.class, args);
    }

}
//  if (error.hasErrors()) {
//            String message = error.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//        }