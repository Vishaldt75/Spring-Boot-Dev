package com.example.curddemoJPA.DAO;

import com.example.curddemoJPA.entity.Course;
import com.example.curddemoJPA.entity.Instructor;
import com.example.curddemoJPA.entity.InstructorDetail;
import com.example.curddemoJPA.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorByID(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theID) {
        Instructor instructor=entityManager.find(Instructor.class,theID);
        //get Courses
        List<Course> courses= instructor.getCourses();

        //break the association of all courses for the instructor
        for (Course tempCourse:courses)
        {
            tempCourse.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theID) {
        return entityManager.find(InstructorDetail.class,theID);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theID) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,theID);

        //Break Bi Directional Link
        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorID(int theID) {

        TypedQuery<Course> query= entityManager.createQuery(
         "from Course where instructor.id=:data", Course.class
        );
        query.setParameter("data",theID);
        List<Course> courses= query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIDJoinFetch(int theId) {

        TypedQuery<Instructor> query=entityManager.createQuery(
                "select i from Instructor i"
                +" JOIN FETCH i.courses"
                        +" JOIN FETCH i.instructorDetail"
                +" where i.id=:data",Instructor.class);

        query.setParameter("data",theId);

        Instructor instructor=query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theID) {
        return entityManager.find(Course.class,theID);
    }

    @Override
    @Transactional
    public void deleteCourseByID(int theID) {
        Course tempCourse=entityManager.find(Course.class,theID);

        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByID(int theID) {
        TypedQuery<Course> query=entityManager.createQuery(
                "select c from Course c "
                +"JOIN FETCH c.reviews "
               + "where c.id = :data", Course.class);
        query.setParameter("data",theID);
        Course course=query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentById(int theID) {
        TypedQuery<Course> query=entityManager.createQuery(
                "select c from Course c "
                        +"JOIN FETCH c.students "
                        + "where c.id = :data", Course.class);
        query.setParameter("data",theID);
        Course course=query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCoursesByID(int theID) {

        TypedQuery<Student> query=entityManager.createQuery(
                "select s from Student s "
                        +"JOIN FETCH s.courseList "
                        + "where s.id = :data", Student.class);
        query.setParameter("data",theID);
        Student student=query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentByID(int theID) {
        Student student=entityManager.find(Student.class,theID);
        entityManager.remove(student);
    }
}
