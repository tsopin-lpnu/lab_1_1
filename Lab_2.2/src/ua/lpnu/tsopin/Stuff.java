package ua.lpnu.tsopin;

import java.util.Random;
import java.util.Scanner;

public class Stuff {
	
	final static int MIN_VALUE = -999;
	final static int MAX_VALUE =  999;

	static void printArray(int [][] array) {
		String temp = "";
		
		for (int i = 0; i < array.length; i++) {
			temp = "|";
			for (int j = 0; j < array[i].length; j++) {
				temp += String.format(" %4d |", array[i][j]);
			}
			System.out.println(temp);
		}
	}
	
	static void createArray(int [][] array) {
		Random r = new Random();
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = r.nextInt(Stuff.MAX_VALUE - Stuff.MIN_VALUE) + Stuff.MIN_VALUE;
			}
		}
	}
	
	static void minInRow(int [][] array, MatrixStuff temp) {
		int row = temp.row;

		temp.value = array[0][row];
		temp.col = 0;

		for (int col = 0; col < array.length; col++) {
			if (array[col][row] < temp.value) {
				temp.value = array[col][row];
				temp.col = col;
			}
		}
	}
	
	static void maxInRow(int [][] array, MatrixStuff temp) {
		int row = temp.row;
		
		temp.value = array[0][row];
		temp.col = 0;
		
		for (int col = 0; col < array.length; col++) {
			if (array[col][row] > temp.value) {
				temp.value = array[col][row];
				temp.col = col;
			}
		}
	}
	
	static void doSomething(int [][] array) {

		MatrixStuff minValue = new MatrixStuff(0, 0, Integer.MIN_VALUE);
		MatrixStuff maxValue = new MatrixStuff(0, 0, Integer.MAX_VALUE);
		MatrixStuff tmpValue = new MatrixStuff(0, 0, 0);

		for (int row = 0; row < array[0].length; row++) {
			tmpValue.row = row;
			if (row % 2 == 0) {
				minInRow(array,tmpValue);
				if (minValue.value < tmpValue.value) {
					minValue.value = tmpValue.value;
					minValue.col = tmpValue.col;
					minValue.row = tmpValue.row;
				}
			} else {
				maxInRow(array,tmpValue);
				if (maxValue.value > tmpValue.value) {
					maxValue.value = tmpValue.value;
					maxValue.col = tmpValue.col;
					maxValue.row = tmpValue.row;
				}
			}
		}
		
		System.out.printf("Ќайб≥льший з м≥н≥мальних елемент≥в по парних стовпц€х a[%d][%d] = %d\n", minValue.col, minValue.row, minValue.value);
		System.out.printf("Ќайменьший з максимальних елемент≥в по непарних стовпц€х a[%d][%d] = %d\n", maxValue.col, maxValue.row, maxValue.value);
		
		array[maxValue.col][maxValue.row] = minValue.value;
		array[minValue.col][minValue.row] = maxValue.value;
	}

	static int readInt(String promt)
	{
		int result = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print(promt);

		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("¬ведено некоректне значенн€. —пробуйте ще раз.");
			System.out.print(promt);
		}
		result = scan.nextInt();	

		//scan.close();
		
		return result;
	}
}
