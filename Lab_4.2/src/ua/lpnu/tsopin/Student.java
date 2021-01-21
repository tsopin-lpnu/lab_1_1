package ua.lpnu.tsopin;

import java.io.Serializable;

enum Specialty {
	COMPUTER_SCIENCE("122, Комп’ютерні науки"),
	COMPUTER_ENGINEERING("123, Комп’ютерна інженерія"),
	CYBERSECURITY("125, Кібербезпека"),
	UNKNOWN("Невідомий");

	private String title;

	Specialty(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return title;
	}
}

public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int pn;
	public String surname;
	public int mClass;
	public Specialty specialty;
	public int rPhysics;
	public int rMath;
	public int rComputerScience;
	
	public Student(int pn, String surname, int mClass, Specialty specialty, int rPhysics, int rMath, int rComputerScience) {
		this.pn = pn;
		this.surname = surname;
		this.mClass = mClass;
		this.specialty = specialty;
		this.rPhysics = rPhysics;
		this.rMath = rMath;
		this.rComputerScience = rComputerScience;
	}
	
	public double getAvgRating() {
		return ((rPhysics + rMath + rComputerScience) / 3.0);
	}
}
