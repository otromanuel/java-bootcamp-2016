package bootcamp.practice.five.entity;

import org.mongodb.morphia.annotations.Embedded;

/**
 * An instance of a student on a course.
 *
 */
@Embedded
public class CourseInscription {

	private Course course;

	private int partialNote1;

	private int partialNote2;

	private int partialNote3;

	private int finalNote;

	public CourseInscription() {
	}

	public CourseInscription(Course course, int partialNote1, int partialNote2, int partialNote3, int finalNote) {
		super();
		this.course = course;
		this.partialNote1 = partialNote1;
		this.partialNote2 = partialNote2;
		this.partialNote3 = partialNote3;
		this.finalNote = finalNote;
	}

	@Override
	public boolean equals(Object object) {
		return this.getCourse().getName().equals(((CourseInscription)object).getCourse().getName());
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getPartialNote1() {
		return partialNote1;
	}

	public void setPartialNote1(short partialNote1) {
		this.partialNote1 = partialNote1;
	}

	public int getPartialNote2() {
		return partialNote2;
	}

	public void setPartialNote2(short partialNote2) {
		this.partialNote2 = partialNote2;
	}

	public int getPartialNote3() {
		return partialNote3;
	}

	public void setPartialNote3(short partialNote3) {
		this.partialNote3 = partialNote3;
	}

	public int getFinalNote() {
		return finalNote;
	}

	public void setFinalNote(short finalNote) {
		this.finalNote = finalNote;
	}

}
