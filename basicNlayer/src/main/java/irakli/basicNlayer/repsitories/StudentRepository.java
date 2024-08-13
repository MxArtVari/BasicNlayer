package irakli.basicNlayer.repsitories;

import irakli.basicNlayer.studentModel.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends
        JpaRepository</*Entity, PKey data type*/Student, Integer> {
        //JpaRepository has all crud operations also find sort etc

    /*ესე იგი ამ ინტერფეისს აქვს ყველაფერი დამაგაზე მეტიც რათა მოძებდო დაამუშავო და დაააფდეითო ბაზა.
    სერვის ფენაში მყოფი მეთოდები ზუსტად ამ ინტერფეისის მეთოდებს გამოიყენებენ.*/

    //@Query("SELECT s FROM Student s WHERE s.email = ?1") //jbql style davwerdit tu rame custom
    //query dahvchirdeboda tumca aq Optionalshi JPA tavisit chawers implementacias.
    Optional<Student> findStudentByEmail(String email);
}
