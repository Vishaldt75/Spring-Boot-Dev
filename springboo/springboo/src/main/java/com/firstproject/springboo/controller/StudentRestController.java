package com.firstproject.springboo.controller;

import com.firstproject.springboo.entity.Student;
import com.firstproject.springboo.resource.StudentErrorResponce;
import com.firstproject.springboo.resource.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    //Define @PostContruct to load Student data once.. only once !
    @PostConstruct
    public void loadData()
    {
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Shraddha","Kapoor"));
        theStudents.add(new Student("Priyanka","Chopra"));
        theStudents.add(new Student("Salman","Khan"));
        theStudents.add(new Student("Kiara","Advani"));
    }
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return theStudents;
    }

    //to get Specific Student by using Index
    @GetMapping("/students/{studentID}")
    public Student getStudents(@PathVariable int studentID)
    {
        if((studentID>=theStudents.size()) || (studentID<0))
        {
            throw new StudentNotFoundException("Student Not Found --" +studentID);
        }
        return theStudents.get(studentID);
    }

    //Add Exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponce> handleException(StudentNotFoundException exception)
    {
        //Create a Student Error Response.
        StudentErrorResponce error=new StudentErrorResponce();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponce> handleException(Exception exception)
    {
        //Create a Student Error Response.
        StudentErrorResponce error=new StudentErrorResponce();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
