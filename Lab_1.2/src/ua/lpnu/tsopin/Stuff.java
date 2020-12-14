package ua.lpnu.tsopin;
import java.util.Scanner;

public class Stuff {

	static double FShortForm(double a, double b, double c, double x) throws RuntimeException
	{
		double result = 0.0;

		if ((x < 0) && (b != 0))
			result = ((-a) * Math.pow(x, 2.0)) + b;
		if ((x > 0) && (b == 0)) {
			if (x == c) {
				throw new RuntimeException("Помилка. Якщо x > 0 і b = 0, значення x і c повинно відрізнятися.");
			} else {
				result = (x / (x - c) ) + 5.5;
			}
		}
		if (!((x < 0) && (b != 0)) && !((x > 0) && (b == 0))) {
			if (c == 0.0) {
				throw new RuntimeException("Помилка. У \"інших випадках\" -  с не може дорівнювати 0.");
			} else {
				result = x / (-c);
			}
		}
		
		return result;
	}

	static double FFullForm(double a, double b, double c, double x) throws RuntimeException
	{
		double result = 0.0;

		if ((x < 0) && (b != 0)) {
			result = ((-a) * Math.pow(x, 2.0)) + b;
		} else if ((x > 0) && (b == 0)) {
			if (x == c) {
				throw new RuntimeException("Помилка. Якщо x > 0 і b = 0, значення x і c повинно відрізнятися.");
			} else {
				result = (x / (x - c) ) + 5.5;
			}
		} else {
			if (c == 0.0) {
				throw new RuntimeException("Помилка. У \"інших випадках\" -  с не може дорівнювати 0.");
			} else {
				result = x / (-c);
			}
		}
		
		return result;
	}
	
	static void FShortForm(double a, double b, double c, double x, double [] z) throws RuntimeException {
		z[0] = FShortForm(a, b, c, x);
	}
	
	static void FShortForm(double a, double b, double c, double x, MyDouble z) throws RuntimeException {
		z.value = FShortForm(a, b, c, x);
	}
	
	static void FFullForm(double a, double b, double c, double x, double [] z) throws RuntimeException {
		z[0] = FFullForm(a, b, c, x);
	}

	static void FFullForm(double a, double b, double c, double x, MyDouble z) throws RuntimeException {
		z.value = FFullForm(a, b, c, x);
	}
	
	static double readDouble(String promt)
	{
		double result = 0.0;

		Scanner scan = new Scanner(System.in);
		System.out.print(promt);

		while(!scan.hasNextDouble()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print(promt);
		}
		result = scan.nextDouble();	

		//scan.close();
		
		return result;
	}
}
