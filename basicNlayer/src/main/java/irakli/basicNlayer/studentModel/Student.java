package irakli.basicNlayer.studentModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Data// set/get tostring/equals/hashcode/reqargconstr.
@Entity//marks class as jpa entity. this class will be mapped into database table.
@AllArgsConstructor
public class Student {
    @Id//marks id instance variable as priamry key
    @SequenceGenerator(//makes sequence(name for -logic of generating priamry key)
            name = "student_id_sequence",
            sequenceName = "student_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue( //acually determines the logic of generating primary key
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dob;

    public Student(String name, String email, Integer age, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }
}
