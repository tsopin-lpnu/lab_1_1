package ua.lpnu.tsopin;

import java.util.Random;

public class lab_5_4 {
	
	static double getRandomDouble(double min, double max) {
		Random r = new Random();
		return (min + (max - min) * r.nextDouble());
	}

	public static void main(String[] args) {
		
		double x = getRandomDouble(-1.0, 1.0);
		double y = getRandomDouble(-1.0, 1.0);
		
		Curves curves [] = {	new Line(getRandomDouble(-1.0, 1.0), getRandomDouble(-1.0, 1.0)), 
								new Ellipse(getRandomDouble(-1.0, 1.0), getRandomDouble(-1.0, 1.0)),
								new Hyperbole(getRandomDouble(-1.0, 1.0), getRandomDouble(-1.0, 1.0))};
		
		System.out.println("Криві:");
		
		for(Curves c: curves) {
			c.Display();
		}
		
		System.out.println();
		System.out.printf("x = %.2f , y = %.2f\n", x, y);
		System.out.println();
		
		System.out.println("Чи належить точка прямій: " + curves[0].isPointAt(x, y));
		System.out.println("Чи належить точка еліпсу: " + curves[1].isPointAt(x, y));
		System.out.println("Чи належить точка гіперболі: " + curves[2].isPointAt(x, y));

	}

}
