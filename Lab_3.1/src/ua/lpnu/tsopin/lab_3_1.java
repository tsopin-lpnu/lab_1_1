package ua.lpnu.tsopin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab_3_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str;

		do {
			System.out.print("Введіть рядок: ");
			str = input.readLine();
		} while (str.isEmpty());

		System.out.println();
		System.out.println("Результат:");
		System.out.println("Чи зустрічається в рядку група із 3 символів \"*\": " + (StringStuff.isContainsAsterisk(str) ? "Так" : "Ні"));
		
		if (StringStuff.isContainsAsterisk(str)) {
			str = StringStuff.replaceAsterisks(str);
			System.out.println("Рядок після заміни \"***\" на \"!!\": " + str);
		}
	}

}
