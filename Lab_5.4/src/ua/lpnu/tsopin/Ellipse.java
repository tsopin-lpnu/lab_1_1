package ua.lpnu.tsopin;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Ellipse extends Curves {

	public Ellipse(double a, double b) {
		super(a, b);
	}
	
	public Ellipse() {
		super();
	}

	@Override
	public boolean isPointAt(double x, double y) {
		BigDecimal xb = new BigDecimal(x);
		BigDecimal yb = new BigDecimal(y);
		BigDecimal ab = new BigDecimal(getA());
		BigDecimal bb = new BigDecimal(getB());
		BigDecimal one = new BigDecimal(1.0);
		
		xb = xb.pow(2);
		yb = yb.pow(2);
		ab = ab.pow(2);
		bb = bb.pow(2);
		
		BigDecimal firstPart = xb.divide(ab, 3, RoundingMode.HALF_UP);
		BigDecimal secondPart = yb.divide(bb, 3, RoundingMode.HALF_UP);
		BigDecimal res = firstPart.add(secondPart); // (Math.pow(x, 2.0) / Math.pow(getA(), 2.0)) + (Math.pow(y, 2.0) / Math.pow(getB(), 2.0))

		return (res.compareTo(one) == 0);
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
