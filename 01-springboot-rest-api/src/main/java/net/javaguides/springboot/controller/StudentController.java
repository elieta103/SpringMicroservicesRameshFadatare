package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // HTTP GET Request
    // http://localhost:8080/student

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent (){
        Student student = new Student(1, "Eliel", "Herrera");
        return ResponseEntity
                .ok()
                .header("custom-header", "Brandin  Herrera")
                .body(student);
    }

    // HTTP GET Request
    // http://localhost:8080/students

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(
                List.of(new Student(1, "Eliel", "Herrera"),
                        new Student(2, "Dany", "Herrera"),
                        new Student(3, "Ian", "Herrera"))
        );
    }

    // PathVariable
    // http://localhost:8080/students/1/Luis/Lopez

    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentPathVariable (@PathVariable("id") int id,
                                           @PathVariable("first-name") String firstName,
                                           @PathVariable("last-name") String lastName){
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    // RequestParam
    // http://localhost:8080/students/query?id=1&first-name=Eliel&last-name=Herrera

    @GetMapping("/query")
    public ResponseEntity<Student> getStudentRequestParam (@RequestParam("id") int id,
                                           @RequestParam("first-name") String firstName,
                                           @RequestParam("last-name") String lastName){
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    // HTTP POST Request
    // http://localhost:8080/students/create

    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent (@RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getId());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // HTTP PUT Request
    // http://localhost:8080/students/1/update

    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent (@RequestBody Student student,
                                  @PathVariable("id") int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // HTTP DELETE Request
    // http://localhost:8080/students/1/delete

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent (@PathVariable("id") int id){
        return ResponseEntity.ok("Student "+id + " deleted successfully !");
    }
}
