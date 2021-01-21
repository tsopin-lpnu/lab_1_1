package ua.lpnu.tsopin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Random;

enum ZodiacSign {
	ARIES("Овен"),
	TAURUS("Телець"),
	GEMINI("Близнюки"),
	CANCER("Рак"),
	LEO("Лев"),
	VIRGO("Діва"),
	LIBRA("Терези"),
	SCORPIO("Скорпіон"),
	SAGITTARIUS("Стрілець"),
	CAPRICORN("Козеріг"),
	AQUARIUS("Водолій"),
	PISCES("Риби"),
	UNKNOWN("Невідомо");

	private String title;

	ZodiacSign(String title) {
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

class SortByDate implements Comparator<Zodiac> 
{ 
    public int compare(Zodiac a, Zodiac b) 
    {
    	Calendar firstDate = new GregorianCalendar(a.getBirthDay()[2], a.getBirthDay()[1] - 1, a.getBirthDay()[0]);
    	Calendar secondDate = new GregorianCalendar(b.getBirthDay()[2], b.getBirthDay()[1] - 1, b.getBirthDay()[0]);
    	
        return firstDate.compareTo(secondDate);
    } 
} 

public class ZodiacStuff {
	
	static final public String ZODIAC_FNAME = "zodiac.db";
	
	static final public String [] ARRAY_OF_SURNAMES = {
			"Мельник",	"Кравчук",	"Коломієць","Козак",	"Яценко",
			"Шевченко",	"Клименко",	"Павлюк",	"Ковтун",	"Жук",
			"Бойко",	"Павленко",	"Ткач",		"Назаренко","Литвин",
			"Коваленко","Савчук",	"Литвиненко","Пилипенко","Герасименко",
			"Бондаренко","Кузьменко","Панченко","Гончар",	"Кириченко",
			"Ткаченко",	"Швець",	"Костенко",	"Іщенко",	"Колесник",
			"Ковальчук","Гаврилюк",	"Кулик",	"Федоренко","Міщенко",
			"Кравченко","Іванова",	"Кравець",	"Гончарук",	"Тимошенко",
			"Олійник",	"Харченко",	"Юрченко",	"Нестеренко","Попова",
			"Шевчук",	"Пономаренко","Білоус",	"Колісник",	"Фоп",
			"Коваль",	"Мельничук","Дяченко",	"Демченко",	"Паламарчук",
			"Поліщук",	"Василенко","Семенюк",	"Терещенко","Власенко",
			"Бондар",	"Мазур",	"Костюк",	"Тищенко",	"Шаповал",
			"Ткачук",	"Хоменко",	"Іванов",	"Бабенко",	"Бондарчук",
			"Мороз",	"Левченко",	"Гуменюк",	"Попович",	"Луценко",
			"Марченко",	"Карпенко",	"Вовк",		"Тарасенко","Кондратюк",
			"Лисенко",	"Кушнір",	"Гончаренко","Макаренко","Чорна",
			"Руденко",	"Сидоренко","Яковенко",	"Марчук",	"Щербина",
			"Савченко",	"Романюк",	"Романенко","Москаленко","Антонюк",
			"Петренко",	"Мартинюк",	"Приходько","Зінченко",	"Сорока"};
	
	static final public String [] ARRAY_OF_NAMES = {
			"Марія", "Тамара", "Стефанія", "Юрій", "Станіслав",
			"Ганна", "Лариса", "Ярослава", "Андрій", "Геннадій",
			"Валентина", "Антоніна", "Леся", "Олексій", "Руслан",
			"Ольга", "Євгенія", "Ксенія", "Григорій", "Георгій",
			"Галина", "Анастасія", "Василина", "Віталій", "Костянтин",
			"Тетяна", "Алла", "Єфросинія", "Ігор", "Євгеній",
			"Надія", "Євдокія", "Дарія", "Дмитро", "Вадим",
			"Людмила", "Зінаїда", "Мотрона", "Олег", "Максим",
			"Олена", "Юлія", "Поліна", "Валерій", "Антон",
			"Наталія", "Наталя", "Неля", "Леонід", "Ілля",
			"Ніна", "Софія", "Микола", "Павло", "Владислав",
			"Любов", "Вікторія", "Володимир", "Степан", "Яків",
			"Катерина", "Марина", "Олександр", "Роман", "Тарас",
			"Світлана", "Інна", "Іван", "Борис", "Йосип",
			"Лідія", "Зоя", "Василь", "Федір", "Семен",
			"Віра", "Варвара", "Сергій", "Валентин", "Едуард",
			"Ірина", "Парасковія", "Віктор", "Євген", "Мирослав",
			"Оксана", "Клавдія", "Анатолій", "Ярослав", "Денис",
			"Олександра", "Лілія", "Михайло", "Вячеслав", "Артем",
			"Раїса", "Уляна", "Петро", "Богдан", "Ростислав"
	};
	
	static public ZodiacSign getZodiacSignFromDate(int day, int month) {
		ZodiacSign res = ZodiacSign.UNKNOWN;

		if (month == 1 && day >= 20 || month == 2 && day <= 18)
			res=ZodiacSign.AQUARIUS;
		else if (month == 2 && day >= 19 || month == 3 && day <= 20)
			res = ZodiacSign.PISCES;
		else if (month == 3 && day >= 21 || month == 4 && day <= 19)
			res = ZodiacSign.ARIES;
		else if (month == 4 && day >= 20 || month == 5 && day <= 20)
			res = ZodiacSign.TAURUS;
		else if (month == 5 && day >= 21 || month == 6 && day <= 21)
			res = ZodiacSign.GEMINI;
		else if (month == 6 && day >= 22 || month == 7 && day <= 22)
			res = ZodiacSign.CANCER;
		else if (month == 7 && day >= 23 || month == 8 && day <= 22)
			res = ZodiacSign.LEO;
		else if (month == 8 && day >= 23 || month == 9 && day <= 22)
			res = ZodiacSign.VIRGO;
		else if (month == 9 && day >= 23 || month == 10 && day <= 22)
			res = ZodiacSign.LIBRA;
		else if (month == 10 && day >= 23 || month == 11 && day <= 21)
			res = ZodiacSign.SCORPIO;
		else if (month == 11 && day >= 22 || month == 12 && day <= 21)
			res = ZodiacSign.SAGITTARIUS;
		else if (month == 12 && day >= 22 || month == 1 && day <= 19)
			res = ZodiacSign.CAPRICORN;

		return res;
	}
	

	public static boolean isValidDate(String date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		sdf.setLenient(false);
		
		try {
			sdf.parse(date);
			return true;
		} catch (Exception e) {}

		return false;
	}
	
	public static boolean isValidDate(int day, int month, int year) {
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		
		if ((calendar.get(Calendar.YEAR) != year) || (calendar.get(Calendar.MONTH) != (month - 1)) || (calendar.get(Calendar.DAY_OF_MONTH) != day))
			return false;
		return true;
	}
	
	static public ArrayList<Zodiac> generateZodiac(int count) {
		Random r = new Random();
		String surname, name;
		int day, month, year;
		
		ArrayList<Zodiac> zodiac = new ArrayList<Zodiac>();
		
		for (int i = 0; i < count; i++) {
			surname = ARRAY_OF_SURNAMES[r.nextInt(ARRAY_OF_SURNAMES.length)];
			name = ARRAY_OF_NAMES[r.nextInt(ARRAY_OF_NAMES.length)];
			day = r.nextInt(27) + 1;
			month = r.nextInt(11) + 1;
			year = r.nextInt(2020 - 1900) + 1900;
			zodiac.add(new Zodiac(name, surname, day, month, year));
		}
		
		return zodiac;
	}
	
	static public void writeZodiac(String fileName, ArrayList<Zodiac> zodiac) throws FileNotFoundException, IOException {
		File file = new File(fileName);
		file.createNewFile();
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
				oos.writeObject(zodiac);
        }
	}
	
	static public ArrayList<Zodiac> readZodiac(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(fileName);
		ArrayList<Zodiac> zodiac = new ArrayList<Zodiac>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
			zodiac = (ArrayList<Zodiac>) ois.readObject();
        }

		return zodiac;
	}
}
