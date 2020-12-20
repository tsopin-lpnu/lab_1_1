package ua.lpnu.tsopin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab_3_2 {
	
	static String change(String str) {
		String firstPart, secondPart, tmpStr = "";
		int indexOfSpace = -1;
		
		indexOfSpace = str.indexOf(' ');
		if (indexOfSpace == -1) {
			return str;
		}
		
		firstPart = str.substring(0, indexOfSpace);
		if (firstPart.isEmpty()) {
			return str;
		}
		
		secondPart = str.substring(indexOfSpace);
		
		for(char c : firstPart.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				tmpStr += c;
			}
		}
		
		return tmpStr.concat(secondPart);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str;

		do {
			System.out.print("¬вед≥ть р€док(повинен м≥стити хоча б один \"проб≥л\"): ");
			str = input.readLine();
		} while (str.isEmpty() || (str.indexOf(' ') == -1));

		str = change(str);
		
		System.out.println("–езультат: " + str);
		

	}

}
