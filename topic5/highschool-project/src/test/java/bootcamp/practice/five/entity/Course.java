package bootcamp.practice.five.entity;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import bootcamp.practice.five.BaseEntity;

/**
 * A course of the higschool
 */
@Entity
public class Course extends BaseEntity {

	private String name;

	private Person teacher;

	private int hoursByWeek;

	@Embedded
	private List<Schedule> schedules;

	public Course() {
	}

	public Course(String name, Person teacher, int hoursByWeek, List<Schedule> schedules) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.hoursByWeek = hoursByWeek;
		this.schedules = schedules;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getTeacher() {
		return teacher;
	}

	public void setTeacher(Person teacher) {
		this.teacher = teacher;
	}

	public int getHoursByWeek() {
		return hoursByWeek;
	}

	public void setHoursByWeek(int hoursByWeek) {
		this.hoursByWeek = hoursByWeek;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
}
