package com.imdb.business;

public class Actor implements Identifiable {
	private int id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private String gender;
	
	public Actor(int id, String firstName, String lastName, int birthYear, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.gender = gender;
	}

	public Actor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getBirthDate() {
		return birthYear;
	}

	public void setBirthDate(int birthDate) {
		this.birthYear = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthYear
				+ ", gender=" + gender + "]";
	}
	
	
}
