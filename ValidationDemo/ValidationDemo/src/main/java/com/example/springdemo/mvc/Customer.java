package com.example.springdemo.mvc;

import com.example.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1,message = "is required")
    private String lastName="";
    @NotNull(message = "is required")
    @Min(value = 0,message = "Minimum value should be 0")
    @Max(value = 10,message = "Maximum value should be 10")
    private Integer freePasses;
    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "It should be 5 digit")
    private String postalCode;
    @CourseCode(value = "TEST",message = "Must Start with TEST")
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
