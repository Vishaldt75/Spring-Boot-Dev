package com.example.curddemoJPA.DAO;

import com.example.curddemoJPA.entity.Course;
import com.example.curddemoJPA.entity.Instructor;
import com.example.curddemoJPA.entity.InstructorDetail;
import com.example.curddemoJPA.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorByID(int theId);

    void deleteInstructorById(int theID);

    InstructorDetail findInstructorDetailById(int theID);

    void deleteInstructorDetailById(int theID);

    List<Course> findCoursesByInstructorID(int theID);
    Instructor findInstructorByIDJoinFetch(int theId);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int theID);

    void deleteCourseByID(int theID);

    void save(Course course);

    Course findCourseAndReviewsByID(int theID);

    Course findCourseAndStudentById(int theID);

    Student findStudentAndCoursesByID(int theID);

    void update(Student student);

    void deleteStudentByID(int theID);
}
