package irakli.basicNlayer.studentConfigurations;

import irakli.basicNlayer.repsitories.StudentRepository;
import irakli.basicNlayer.studentModel.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration//defines the component where Beans are located
//we configure this class to add 2 students in our database
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){//this makes the code
        return args ->{                                             //run at the start of applicaton
            Student irakli = new Student(
                    "Irakli",
                    "irakli@gmail.com",
                    21,
                    LocalDate.of(2002,9,27)
            );

            Student mari = new Student(
                    "Mari",
                    "mari@gmail.com",
                    22,
                    LocalDate.of(2002,1,31)
            );

            repository.saveAll( //this method comes from our interface which was injected in ln16
                    List.of(irakli,mari)
            );
        };
    }
}
