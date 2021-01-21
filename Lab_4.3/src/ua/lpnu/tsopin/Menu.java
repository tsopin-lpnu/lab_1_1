package ua.lpnu.tsopin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

public class Menu {
	
	static public void printZodiac(ArrayList<Zodiac> zodiac) {
		int i = 1;
		
		if(zodiac == null || zodiac.size() < 1) {
			System.out.println("Не знайдено жодного запису.");
			return;
		}
		
		System.out.println("  #|              Ім'я              |            Прізвище            | Дата народження | Знак зодіаку |");
		for (Zodiac zdc : zodiac) {
			System.out.printf("%3d| %30s | %30s |      %02d.%02d.%04d | %12s |\n", i++, zdc.getName(), zdc.getSurname(), zdc.getBirthDay()[0], zdc.getBirthDay()[1], zdc.getBirthDay()[2], zdc.getZodiacSign());
		}
	}
	
	static public ArrayList<Zodiac> findBySurname(String surname, ArrayList<Zodiac> zodiac) {
		if (zodiac == null || zodiac.size() < 1) {
			return null;
		}
		
		ArrayList<Zodiac> items = new ArrayList<Zodiac>();
		
		for (Zodiac zdc : zodiac) {
			if (zdc.getSurname().equals(surname)) {
				items.add(zdc);
			}
		}
		return items;
	}
	
	static public int printMenu() {
		int m = 0;
		
		System.out.println("\t\t-== Меню ==-");
		System.out.println("\t1 - Генерація тестових даних.");
		System.out.println("\t2 - Вивести дані на екран.");
		System.out.println("\t3 - Новий запис.");
		System.out.println("\t4 - Пошук запису за прізвищем.");
		System.out.println("\t5 - Впорядкувати дані за датами народження.\n");
		System.out.println("\t0 - Вихід.\n");
		
		do {
			m = readInt("Виберіть дію: ");
		} while ((m < 0) || (m > 5));
		
		return m;
	}

	static void mainLoop() {
		int menuItem = 0;
		ArrayList<Zodiac> zodiac = new ArrayList<Zodiac>();
		
		try {
			zodiac = ZodiacStuff.readZodiac(ZodiacStuff.ZODIAC_FNAME);
			System.out.println("Файл з даними успішно завантаженно.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		while ((menuItem = printMenu()) != 0) {
			switch(menuItem) {
				case 1: zodiac = ZodiacStuff.generateZodiac(25);
						save(zodiac);
					break;
				case 2: printZodiac(zodiac);
					break;
				case 3: newRecord(zodiac);
						save(zodiac);
					break;
				case 4: search(zodiac);
					break;
				case 5: sort(zodiac);
						save(zodiac);
					break;

			}
		}
	}
	
	private static void sort(ArrayList<Zodiac> zodiac) {
		if (zodiac == null) 
			return;
		Collections.sort(zodiac, new SortByDate());
	}

	static void search(ArrayList<Zodiac> zodiac) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
		do {
			System.out.print("Введіть прізвище: ");
			try {
				str = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (str.isEmpty());
		
		ArrayList<Zodiac> items = findBySurname(str.trim(), zodiac);
		printZodiac(items);
	}
	
	static void newRecord(ArrayList<Zodiac> zodiac) {
		if (zodiac == null) 
			return;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String surname = "", name = "", birthDay = "";
		
		do {
			System.out.print("Введіть ім'я: ");
			try {
				name = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (name.isEmpty());
		
		do {
			System.out.print("Введіть прізвище: ");
			try {
				surname = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (surname.isEmpty());
		
		do {
			System.out.print("Введіть дату народження в форматі \"дд.мм.рррр\": ");
			try {
				birthDay = input.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (birthDay.isEmpty() || !ZodiacStuff.isValidDate(birthDay));
		
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(birthDay));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		zodiac.add(new Zodiac(name,surname, calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR)));
	}

	static void save(ArrayList<Zodiac> zodiac) {
		try {
			ZodiacStuff.writeZodiac(ZodiacStuff.ZODIAC_FNAME, zodiac);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static int readInt(String promt)
	{
		int result = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print(promt);

		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print(promt);
		}
		result = scan.nextInt();	

		//scan.close();
		
		return result;
	}
}
