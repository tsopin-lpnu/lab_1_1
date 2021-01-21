package ua.lpnu.tsopin;

import java.math.BigDecimal;
import java.util.Scanner;

public class LineImp implements iCurves {

	private double a;
	private double b;
	
	public LineImp(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public LineImp() {
		this.a = 0.0;
		this.b = 0.0;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	@Override
	public boolean isPointAt(double x, double y) {
		BigDecimal xb = new BigDecimal(x);
		BigDecimal yb = new BigDecimal(y);
		//BigDecimal ab = new BigDecimal(getA());
		BigDecimal bb = new BigDecimal(getB());
		
		BigDecimal res = new BigDecimal(getA()); // a * x + b
		res.multiply(xb);
		res.add(bb);
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
