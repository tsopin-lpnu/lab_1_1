package ua.lpnu.tsopin;

import java.util.Random;

public class lab_5_2 {
	
	static double getRandomDouble(double min, double max) {
		Random r = new Random();
		return (min + (max - min) * r.nextDouble());
	}

	public static void main(String[] args) {
		
		System.out.println("Point_1");
		Point pnt1 = new Point(4.9, 7.3);
		pnt1.Display();
		System.out.printf("Відстань до початку координат: %.2f\n", pnt1.distanceToCenter());
		
		System.out.println("\nPoint_2");
		Point pnt2 = new Point(pnt1);
		pnt2.Display();
		
		System.out.println("\nPoint_3");
		Point pnt3 = new Point();
		pnt3.Init(5.0, 3.3);
		pnt3.Display();
		
		System.out.println("\nPoint_4");
		Point pnt4 = new Point();
		pnt4.Read();
		pnt4.Display();
		
		System.out.println();
		System.out.println("Point_1 == Point_2: " + pnt2.equals(pnt1));
		System.out.println("Point_2 != Point_3: " + pnt2.notEquals(pnt3));
		System.out.println("Point_3 == Point_4: " + pnt3.equals(pnt4));
		
		Point [] points = new Point[7];
		for(int i = 0; i < points.length; i++) {
			if(i % 2 == 0) {
				points[i] = new Point(getRandomDouble(-15.5, 13.0), getRandomDouble(-15.5, 13.0));
			} else {
				points[i] = new Point();
				points[i].Init(getRandomDouble(-15.5, 13.0), getRandomDouble(-15.5, 13.0));
			}
		}
		
		System.out.println();
		System.out.println("Point в масиві:");
		
		for(Point pnt : points) {
			pnt.Display();
			System.out.printf("Відстань до початку координат: %.2f\n", pnt.distanceToCenter());
			System.out.println("Полярна система координат:");
			pnt.printPolarCoord();
		}
		
		
	}

}
