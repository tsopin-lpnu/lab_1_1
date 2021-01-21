package ua.lpnu.tsopin;

import java.util.Random;

public class zalik {
	
	final static double MIN_VALUE = -999.0;
	final static double MAX_VALUE =  999.0;
	final static int ROWS = 6;
	final static int COLS = 5;
	
	static void generateArray(double [][] array) {
		Random r = new Random();
		
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[i].length; j++)
				array[i][j] = MIN_VALUE + (MAX_VALUE - MIN_VALUE) * r.nextDouble();
	}
	
	static void printArray(double [][] array) {
		String temp = "";
		
		for (int i = 0; i < array.length; i++) {
			temp = "|";
			for (int j = 0; j < array[i].length; j++) {
				temp += String.format(" %7.2f |", array[i][j]);
			}
			System.out.println(temp);
		}
	}

	static void doSomething(double [][] array) {
		double lastInRow = 0.0;
		
		for (int row = 0; row < array[0].length; row++) {
			lastInRow = array[COLS-1][row];
			
			if (lastInRow == 0.0)
				continue;
			
			for (int col = 0; col < array.length; col++) {
				array[col][row] = array[col][row] / lastInRow;
			}
		}
	}
	
	public static void main(String[] args) {
		
		double [][] T = new double[COLS][ROWS];
		
		generateArray(T);
		
		System.out.println("Матриця Т:");
		printArray(T);
		
		doSomething(T); // Alohomora
		
		System.out.println("Результат:");
		printArray(T);

	}

}
