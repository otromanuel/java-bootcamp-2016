package bootcamp.practice.five.entity;

import org.mongodb.morphia.annotations.Embedded;

/**
 * A day and time when a Course weekly occurs.
 */
@Embedded
public class Schedule {

	private String dayOfWeek;

	private String startTime;

	private String endTime;

	public Schedule() {

	}

	public Schedule(String dayOfWeek, String startTime, String endTime) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
