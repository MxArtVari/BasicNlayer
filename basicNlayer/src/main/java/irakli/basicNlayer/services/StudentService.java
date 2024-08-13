package irakli.basicNlayer.services;

import irakli.basicNlayer.repsitories.StudentRepository;
import irakli.basicNlayer.studentModel.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        //gavaketot martivi validacia
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()/*tu null aris False tu sxva True*/){
            throw new IllegalStateException("email taken");
        }
        else  studentRepository.save(student);
    }

    public void deleteStudentById(Integer studentId){
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student does not exist");
        }
        else studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudentById(Integer studentId, String name, String email){
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + "does not exit"
                ));
        if(name != null &&
                !name.isEmpty() &&
                !Objects.equals(student.getName(), name)){
            student.setName(name);
        } if(email != null &&
                !email.isEmpty() &&
                !Objects.equals(student.getEmail(), email)){
            student.setEmail(email);
        }

    }
}
