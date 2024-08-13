package irakli.basicNlayer.controllers;

import irakli.basicNlayer.repsitories.StudentRepository;
import irakli.basicNlayer.services.StudentService;
import irakli.basicNlayer.studentModel.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students" )
public class StudentController {
/*    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse(
                "Hello",
                List.of("Java", "c++"),
                new Person("Alex", 21, 30_000)
        );
    }

    record Person(String name, int age, double cash){
    }
    record GreetResponse(String greet, List<String> Languages, Person person){}*/

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentId}") //rac daiwereba  amis mere api/v1/students/5/mari/email chaismeba
    //path variable {studentId}
    public void deleteStudentById(@PathVariable("studentId") Integer studentId){
                                 //aq kide eg path variable chaideba Integer studentId-shi
        studentService.deleteStudentById(studentId);
    }

    @PatchMapping(path = "{studentId}")
    public void updateStudentById(
            @PathVariable("studentId") Integer studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        System.out.println(studentId + name + email);
        studentService.updateStudentById(studentId, name, email);

    }

}
