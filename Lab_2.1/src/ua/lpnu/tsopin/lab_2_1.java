package ua.lpnu.tsopin;

public class lab_2_1 {

	public static void main(String[] args) {
		
		int n = 0;
		int min, max;
		
		while((n = Stuff.readInt("Введіть довжину масива: ")) < 1) {
			System.out.println("Довжина масива повинна бути більше 0.");
		}
		
		int [] array = new int[n];
		
		Stuff.createArray(array);
		min = Stuff.min(array);
		max = Stuff.max(array);
		
		System.out.println("");
		System.out.println("Результат:");

		Stuff.printArray(array);

		System.out.println("Максимальне значення масиву = " + max);
		System.out.println("Мінімальне значення масиву = " + min);
		System.out.println("Сума максимального і мінімального елементів масиву = " + (min + max));

	}

}
