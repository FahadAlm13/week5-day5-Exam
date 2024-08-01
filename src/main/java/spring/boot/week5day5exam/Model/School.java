package spring.boot.week5day5exam.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class School {

    @NotNull(message = "Id shouldn't be null")
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    private String name;
    @NotNull(message = "Your age shouldn't be null")
    private int age;
    @NotEmpty(message = "Major should be empty")
    private String major;
}
