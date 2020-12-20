package ua.lpnu.tsopin;

public class StringStuff {
	
	static String replaceAsterisks(String inp) {
		return inp.replaceAll("\\*\\*\\*", "!!");
	}
	
	static boolean isContainsAsterisk(String inp) {
		return (inp.indexOf("***") != -1);
	}

}
