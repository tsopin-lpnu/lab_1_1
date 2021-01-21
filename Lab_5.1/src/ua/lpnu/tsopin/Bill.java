package ua.lpnu.tsopin;

import java.util.Scanner;

public class Bill {
	private int first;
	private double second;
	
	public Bill(int first, double second) {
		this.Init(first, second);
	}

	public Bill() {
		this.first = 0;
		this.second = 0.0;
	}
	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		if (first >= 0)
			this.first = first;
		else
			this.first = 0;
	}

	public double getSecond() {
		return second;
	}

	public void setSecond(double second) {
		if (second >= 0.0)
			this.second = second;
		else
			this.second = 0.0;
	}
	
	public double cost() {
		return this.first * this.second;
	}
	
	public void Init(int first, double second) {
		this.setFirst(first);
		this.setSecond(second);
	}
	
	public void Read() {
		int f = 0;
		double s = 0.0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Введіть тривалість розмови: ");

		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print("Введіть тривалість розмови: ");
		}
		f = scan.nextInt();
		
		System.out.print("Введіть вартість однієї хвилини: ");

		while(!scan.hasNextDouble()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print("Введіть вартість однієї хвилини: ");
		}
		s = scan.nextDouble();
		
		this.Init(f, s);
	}
	
	public void Display() {
		System.out.printf("Тривалість розмови(хвилин): %d, Вартість однієї хвилини(грн): %.2f, Вартість розмови: %.2f грн\n",this.first,this.second, this.cost());
	}
}
