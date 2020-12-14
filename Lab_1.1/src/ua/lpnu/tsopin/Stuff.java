package ua.lpnu.tsopin;

import java.util.Scanner;

public class Stuff {

	static double h(double x, double y)
	{
		double temp = Math.pow(x, 2) + Math.pow(y, 2);
		return ((Math.sin(x * y) + temp) / (1 + temp));
	}

	static void h(double x, double y, double [] z)
	{
		z[0] = h(x, y);
	}

	static void h(double x, double y, MyDouble z)
	{
		z.value = h(x, y);
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
