package spring.boot.week5day5exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "Id shouldn't be null")
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    private String name;

    @NotNull(message = "Salary shouldn't be null")
    private int salary;
}
