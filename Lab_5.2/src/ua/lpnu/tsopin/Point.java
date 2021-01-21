package ua.lpnu.tsopin;

import java.util.Scanner;

public class Point {
	private double x;
	private double y;
	
	public Point() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void Init(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void Read() {
		double x,y = 0.0;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Введіть x: ");

		while(!scan.hasNextDouble()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print("Введіть x: ");
		}
		x = scan.nextDouble();
		
		System.out.print("Введіть y: ");

		while(!scan.hasNextDouble()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print("Введіть y: ");
		}
		y = scan.nextDouble();
		
		this.Init(x, y);
	}
	
	public void Display() {
		System.out.println(this.toString());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point))
			return false;
		return ((this.x == ((Point)obj).x) && (this.y == ((Point)obj).y));
	}

	public boolean notEquals(Object obj) {
		return !(this.equals(obj));
	}
	
	@Override
	public String toString() {
		return String.format("x: %.2f, y: %.2f", this.x, this.y);
	}
	
	public double distanceTo(Point point) {
        double result = 0;
        if (point != null) {
            result = Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
        }
        return result;
    }

	public double distanceToCenter() {
        return this.distanceTo(new Point(0.0, 0.0));
    }
	
	public void printPolarCoord() {
		double radius = 0.0;
		double degrees = 0.0;
		double radians = 0.0;
		
		radius = Math.sqrt((x*x) + (y*y));
		radians = Math.atan2(y, x);
		degrees = radians * (180/Math.PI);
		
		System.out.printf("Відстань: %.2f, кут: %.2f\n", radius, degrees);
	}
}
