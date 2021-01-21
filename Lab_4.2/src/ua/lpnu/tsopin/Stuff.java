package ua.lpnu.tsopin;

import java.util.Random;


public class Stuff {
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
	
	static final public int CLASS_COUNT = 5;
	
	static public Student []generateSudents(int count) {
		Random r = new Random();
		String surname;
		int mPhysics, mMath, mComputerScience, mClass, pn;
		Specialty spec = Specialty.UNKNOWN;
		int specialtyLength = Specialty.values().length-1;
		
		Student [] students = new Student[count];
		int [][] sequenceNumbers = new int[specialtyLength][CLASS_COUNT];
		
		for (int i = 0; i < students.length; i++) {
			surname = ARRAY_OF_SURNAMES[r.nextInt(ARRAY_OF_SURNAMES.length)];
			spec = Specialty.values()[r.nextInt(specialtyLength)];
			mPhysics = r.nextInt(5) + 1;
			mMath = r.nextInt(5) + 1;
			mComputerScience = r.nextInt(5) + 1;
			mClass = r.nextInt(CLASS_COUNT) + 1;
			pn = sequenceNumbers[spec.ordinal()][(mClass - 1)] + 1;
			sequenceNumbers[spec.ordinal()][(mClass - 1)] = pn; 
			students[i] = new Student(pn, surname, mClass, spec, mPhysics, mMath, mComputerScience);
		}
		
		return students;
	}
	
	static public void printStudents(Student [] students) {
		System.out.println("\t\t\t\t\t\t\t|\t\tОцінки\t\t    |");
		System.out.println(" #|   Прізвище  | Курс |          Спеціальність         | Фізика | Математика | Інформатика |");
		for (Student sdnt: students) {
			System.out.printf("%2d| %11s |    %d | %-30s |      %d |          %d |           %d |\n", sdnt.pn, sdnt.surname, sdnt.mClass, sdnt.specialty, sdnt.rPhysics, sdnt.rMath, sdnt.rComputerScience);
		}
	}
	
	static public double getMaxAvgRating(Student [] students) {
		double max = Double.MIN_VALUE;
		
		for (Student sdnt: students) {
			max = Math.max(max, sdnt.getAvgRating());
		}
		return max;
	}
	
	static public double getPercentageOfNerds(Student [] students) {
		int countOfNerds = 0;
		double res = 0.0;
		
		for (Student sdnt: students) {
			if(sdnt.rPhysics > 3)
				countOfNerds++;
		}

		if (countOfNerds > 0)
			res = ((double)countOfNerds / (double)students.length) * 100.0;
		
		return res;
	}

}
