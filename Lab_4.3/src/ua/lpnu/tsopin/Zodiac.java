package ua.lpnu.tsopin;

import java.io.Serializable;

public class Zodiac  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private int[] bDay = new int[3];
	private ZodiacSign mZodiac;
	
	public Zodiac(String name, String surname, int bDay, int bMonth, int bYear) {
		this.name = name;
		this.surname = surname;
		this.setBirthDay(bDay, bMonth, bYear);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int[] getBirthDay() {
		return bDay;
	}
	public void setBirthDay(int day, int month, int year) {
		if (ZodiacStuff.isValidDate(day, month, year)) {
			this.bDay[0] = day;
			this.bDay[1] = month;
			this.bDay[2] = year;
		} else {
			this.bDay[0] = 1;
			this.bDay[1] = 1;
			this.bDay[2] = 1900;
		}
		this.mZodiac = ZodiacStuff.getZodiacSignFromDate(bDay[0], bDay[1]);
	}
	
	public ZodiacSign getZodiacSign() {
		return mZodiac;
	}
}
