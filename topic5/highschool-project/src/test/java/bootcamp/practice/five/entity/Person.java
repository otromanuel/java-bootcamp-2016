package bootcamp.practice.five.entity;

import bootcamp.practice.five.BaseEntity;

/**
 * Simple Person class used to abstract some attributes of Students and
 * Teachers. Its used as a Teacher.
 * 
 *
 */
public class Person extends BaseEntity {

	private String firstame;

	private String lastname;

	public Person() {
	}

	public Person(String firstame, String lastname) {
		super();
		this.firstame = firstame;
		this.lastname = lastname;
	}

	public String getFirstame() {
		return firstame;
	}

	public void setFirstame(String firstame) {
		this.firstame = firstame;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
