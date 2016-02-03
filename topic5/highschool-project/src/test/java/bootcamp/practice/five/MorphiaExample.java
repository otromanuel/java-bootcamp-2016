package bootcamp.practice.five;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import bootcamp.practice.five.dao.CourseDAO;
import bootcamp.practice.five.dao.StudentDAO;
import bootcamp.practice.five.entity.Course;
import bootcamp.practice.five.entity.CourseInscription;
import bootcamp.practice.five.entity.Person;
import bootcamp.practice.five.entity.Schedule;
import bootcamp.practice.five.entity.Student;

/**
 * Simple example class with main method to test the usage of Morphia framework.
 * Creates 3 courses and 20 students with random grade notes.
 */
public class MorphiaExample {

	public static void main(String[] args) throws MongoException {

		String dbName = new String("test");
		MongoClient mongo = new MongoClient();
		Morphia morphia = new Morphia();
		Datastore datastore = morphia.createDatastore(mongo, dbName);

		morphia.mapPackage("bootcamp.practice.five.entity");

		Person teacher1 = new Person("John", "Doe");
		Schedule mathSch1 = new Schedule("Wednesday", "10:30", "11:30");
		Schedule mathSch2 = new Schedule("Monday", "08:00", "09:00");
		List<Schedule> mathSchedules = new ArrayList<Schedule>();
		mathSchedules.add(mathSch1);
		mathSchedules.add(mathSch2);
		Course mathCourse = new Course("Math", teacher1, 10, mathSchedules);
		Key<Course> savedCourse = datastore.save(mathCourse);
		System.out.println("Saved Course: " + savedCourse.getId());

		Person teacher2 = new Person("Jack", "Black");
		Schedule musicSch1 = new Schedule("Thursday", "09:30", "10:30");
		Schedule musicSch2 = new Schedule("Friday", "08:30", "10:30");
		List<Schedule> musicSchedules = new ArrayList<Schedule>();
		musicSchedules.add(musicSch1);
		musicSchedules.add(musicSch2);
		Course musicCourse = new Course("Music", teacher2, 3, musicSchedules);
		savedCourse = datastore.save(musicCourse);
		System.out.println("Saved Course: " + savedCourse.getId());

		Schedule chemSch1 = new Schedule("Tuesday", "08:00", "09:00");
		List<Schedule> chemSchedules = new ArrayList<Schedule>();
		chemSchedules.add(chemSch1);
		Course chemCourse = new Course("Chemistry", teacher2, 1, chemSchedules);
		savedCourse = datastore.save(chemCourse);
		System.out.println("Saved Course: " + savedCourse.getId());

		CourseInscription insciption;
		ArrayList<CourseInscription> inscriptions = new ArrayList<CourseInscription>();
		Student student;
		Key<Student> savedStudent;

		for (int student_num = 0; student_num < 20; student_num++) {
			if (student_num < 10) {
				insciption = new CourseInscription(mathCourse, 0, 0, 0, ThreadLocalRandom.current().nextInt(2, 10 + 1));
				inscriptions.add(insciption);
			} else {
				insciption = new CourseInscription(musicCourse, 0, 0, 0, ThreadLocalRandom.current().nextInt(2, 10 + 1));
				inscriptions.add(insciption);
			}
			if (student_num % 2 == 0) {
				insciption = new CourseInscription(chemCourse, 0, 0, 0, ThreadLocalRandom.current().nextInt(2, 10 + 1));
				inscriptions.add(insciption);
			}
			student = new Student("FirstName " + student_num, "LastName " + student_num, 120 + student_num, inscriptions);
			savedStudent = datastore.save(student);
			System.out.println("Saved Student: " + savedStudent.getId());

			inscriptions.removeAll(inscriptions);

		}

		System.out.println("Fetch all students whose notes in a specific course (in this case, Math) were greater than 4.");

		StudentDAO studentDAO = new StudentDAO(mongo, morphia, dbName);
		Query<Student> studentQuery = datastore.createQuery(Student.class);
		studentQuery.and(studentQuery.criteria("courseInscriptions.course.name").equal("Math"),
				studentQuery.criteria("courseInscriptions.finalNote").greaterThan(4));
		QueryResults<Student> retrievedStudents = studentDAO.find(studentQuery);
		for (Student retrievedStudent : retrievedStudents)
			System.out.println(retrievedStudent.getFirstame() + " " + retrievedStudent.getLastname());

		System.out.println("Fetch all courses ordered by name for a given teacher (lastname='Black')");

		CourseDAO courseDAO = new CourseDAO(mongo, morphia, dbName);
		Query<Course> courseQuery = datastore.createQuery(Course.class).order("name");
		courseQuery.criteria("teacher.lastname").equal("Black");

		QueryResults<Course> retrievedCourses = courseDAO.find(courseQuery);
		for (Course retrievedCourse : retrievedCourses)
			System.out.println(retrievedCourse.getName());				

	}

}
