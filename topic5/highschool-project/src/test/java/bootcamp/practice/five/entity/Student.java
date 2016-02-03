package bootcamp.practice.five.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
 * A student of the higschool
 */
@Entity
public class Student extends Person {

	private int regnum;

	@Embedded
	List<CourseInscription> courseInscriptions;

	public Student(String firstname, String lastname, int regnum, List<CourseInscription> courseInscriptions) {
		super(firstname, lastname);
		this.regnum = regnum;
		this.courseInscriptions = courseInscriptions;
	}

	public Student() {

	}

	public int getRegnum() {
		return regnum;
	}

	public void setRegnum(int regnum) {
		this.regnum = regnum;
	}

	public List<CourseInscription> getCourseInscriptions() {
		return courseInscriptions;
	}

	public void setCourseInscriptions(List<CourseInscription> courseInscriptions) {
		this.courseInscriptions = courseInscriptions;
	}

}
