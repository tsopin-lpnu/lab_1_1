package ua.lpnu.tsopin;

public class lab_4_2 {
	static final public String STUDENTS_FNAME = "students.db";

	public static void main(String[] args) {
		
		System.out.println("Формування списку студентів...");
		Student []students = Stuff.generateSudents(28);
		Student []newStudents = null;
		try {
			System.out.println("Зберігання списку студентів у файл...");
			SerializeStudent.writeStudents(STUDENTS_FNAME, students);
			System.out.println("Зчитування списку студентів з файлу...");
			newStudents = SerializeStudent.readStudents(STUDENTS_FNAME);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println();
		System.out.println("Результат:");
		Stuff.printStudents(newStudents);
		System.out.println();
		System.out.printf("Найбільший середній бал: %.2f\n",Stuff.getMaxAvgRating(newStudents));
		System.out.printf("Процент студентів, які отримали з фізики оцінки \"5\" або \"4\": %.2f%%\n",Stuff.getPercentageOfNerds(newStudents));

	}

}
