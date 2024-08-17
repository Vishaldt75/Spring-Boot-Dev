package com.firstproject.springboo.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandling {
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
