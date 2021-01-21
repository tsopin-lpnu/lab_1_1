package ua.lpnu.tsopin;

import java.util.Scanner;
import java.math.BigDecimal;

public class Line extends Curves {

	public Line(double a, double b) {
		super(a, b);
	}
	
	public Line() {
		super();
	}

	@Override
	public boolean isPointAt(double x, double y) {
		BigDecimal xb = new BigDecimal(x);
		BigDecimal yb = new BigDecimal(y);
		//BigDecimal ab = new BigDecimal(getA());
		BigDecimal bb = new BigDecimal(getB());
		
		BigDecimal res = new BigDecimal(getA()); // a * x + b
		res = res.multiply(xb);
		res = res.add(bb);
		return (res.compareTo(yb) == 0);
	}

	@Override
	public void Read() {
		double a, b = 0.0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("A: ");

		while(!scan.hasNextDouble()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print("A: ");
		}
		a = scan.nextDouble();
		
		System.out.print("B: ");

		while(!scan.hasNextDouble()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print("B: ");
		}
		b = scan.nextDouble();
		
		setA(a);
		setB(b);
	}

	@Override
	public void Display() {
		System.out.printf("a = %.2f, b = %.2f\n", getA(), getB());
	}

}
