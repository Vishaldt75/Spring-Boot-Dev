package com.example.curddemoJPA;

import com.example.curddemoJPA.DAO.AppDAO;
import com.example.curddemoJPA.entity.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FilterOutputStream;
import java.util.List;

@SpringBootApplication
public class CurddemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner ->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetails(appDAO);
			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);

			//deleteInstructor(appDAO);

			//deleteCourse(appDAO);

			//createCourseAndReviews(appDAO);

			//retrieveCourseAndReviews(appDAO);

			//deleteCourseAndReviews(appDAO);

			//createCourseAndStudents(appDAO);

			//findCourseAndStudent(appDAO);

			//findStudentAndCourses(appDAO);

			//addMoreCoursesForStudent(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO);

		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=2;
		appDAO.deleteStudentByID(theId);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theID=2;
		Student student=appDAO.findStudentAndCoursesByID(theID);
		Course course1=new Course("AWS");
		Course course2=new Course("Advance Java");

		student.addCourse(course1);
		student.addCourse(course2);

		appDAO.update(student);
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theID=2;
		Student student=appDAO.findStudentAndCoursesByID(theID);
		System.out.println(student);
		System.out.println(student.getCourseList());
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int theID=10;
		Course course=appDAO.findCourseAndStudentById(theID);

		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course=new Course("Spring BOOT");
		Student student1=new Student("John","Doe","john@gmail.com");
		Student student2=new Student("Merry","Ray","merry@gmail.com");
		Student student3=new Student("Susan","Test","susan@gmail.com");

		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		appDAO.save(course);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theID=10;
		appDAO.deleteCourseByID(theID);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theID=10;

		Course course=appDAO.findCourseAndReviewsByID(theID);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course=new Course("Spring Boot Demo");
		course.addReview(new Review("Great Course .. Loved it !!"));
		course.addReview(new Review("Cool Course .. Liked it !!"));
		course.addReview(new Review("Very Bad Course !!"));

		appDAO.save(course);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theID=10;
		appDAO.deleteCourseByID(theID);
	}

	private void updateCourse(AppDAO appDAO) {
		int theID=11;
		Course tempCourse=appDAO.findCourseById(theID);

		tempCourse.setTitle("Enjoy the Simple Things");
		appDAO.update(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theID=1;

		System.out.println("Finding Instructor ID : "+theID);
		Instructor tempInstructor=appDAO.findInstructorByID(theID);

		System.out.println("Updating Instructor ID : "+theID);
		tempInstructor.setLastName("The Actor");
		appDAO.update(tempInstructor);

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId=1;

		System.out.println("Finding ID :"+theId);
		Instructor tempInstructor =appDAO.findInstructorByIDJoinFetch(theId);

		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("the Associated Courses "+tempInstructor.getCourses());

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("ID : "+theId);
		Instructor tempInstructor = appDAO.findInstructorByID(theId);

		System.out.println("tempInstructor : "+tempInstructor);

		System.out.println("Find Courses for Instructor ID "+theId);
		List<Course> courses=appDAO.findCoursesByInstructorID(theId);
		tempInstructor.setCourses(courses);
		System.out.println("List of Courses "+tempInstructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("ID : "+theId);
		Instructor tempInstructor = appDAO.findInstructorByID(theId);

		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("tempInstructor Courses : "+tempInstructor.getCourses());
		System.out.println("Done");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=
				new Instructor("Shraddha","Kapoor","shraddha@gmail.com");
		InstructorDetail instructorDetail=
				new InstructorDetail("http://shraddhakapoor/youtube","Acting");
		tempInstructor.setInstructorDetail(instructorDetail);


		Course tempCourse=new Course("Air Guitar");
		Course tempCourse1=new Course("Singing Course");
		tempInstructor.add(tempCourse);
		tempInstructor.add(tempCourse1);
		System.out.println("Saving Instructor : "+tempInstructor);
		System.out.println("The Course List : "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theID=3;
		System.out.println("Deleting Instructor Details id : "+theID);

		appDAO.deleteInstructorDetailById(theID);

		System.out.println("Done !");
	}

	private void findInstructorDetails(AppDAO appDAO) {
		int theID=2;
		  InstructorDetail instructorDetail=appDAO.findInstructorDetailById(theID);

		System.out.println("instructorDetail : "+instructorDetail);

		System.out.println("Instructor : "+instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theID=1;
		System.out.println("Deleting ID : "+theID);

		appDAO.deleteInstructorById(theID);

		System.out.println("Done !");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding instructor id : "+theId);
		Instructor instructor=appDAO.findInstructorByID(theId);

		System.out.println("Instructor : "+instructor);
		System.out.println("the associate InstructorDetails only : "+instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*Instructor tempInstructor=
				new Instructor("Chad","Darby","darby@gmail.com");
		InstructorDetail instructorDetail=
				new InstructorDetail("http://chad-darby/youtube","Travelling");
		tempInstructor.setInstructorDetail(instructorDetail);*/

		Instructor tempInstructor=
				new Instructor("Madhu","Patel","madhu@gmail.com");
		InstructorDetail instructorDetail=
				new InstructorDetail("http://patel-madhu/youtube","Singing");
		tempInstructor.setInstructorDetail(instructorDetail);
		System.out.println("Saving Instructor : "+tempInstructor);
		appDAO.save(tempInstructor);

	}
}
