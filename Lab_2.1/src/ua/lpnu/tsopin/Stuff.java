package ua.lpnu.tsopin;

import java.util.Arrays;
import java.util.Scanner;

public class Stuff {

	static void printArray(int [] array) {
		System.out.println(Arrays.toString(array));
	}
	
	static void createArray(int [] array) {
		for (int i = 0; i < array.length; i++) {
	         array[i] = readInt("a["+i+"] = ");
	      }
	}
	
	static void printArrayFoo(int [] array) {
		String temp = "|";
		for (int i : array) {
			temp += String.format(" %4d |", i);
		}
		
		System.out.println(temp);
	}
	
	static int min(int [] array) {
		int min = Integer.MAX_VALUE;
		
		for (int i : array) {
			min = Math.min(min, i);
		}
		
		return min;
	}
	
	static int max(int [] array) {
		int max = Integer.MIN_VALUE;
		
		for (int i : array) {
			max = Math.max(max, i);
		}
		
		return max;
	}
	
	static int readInt(String promt)
	{
		int result = 0;

		Scanner scan = new Scanner(System.in);
		System.out.print(promt);

		while(!scan.hasNextInt()) {
			scan.next();
			System.out.println("Введено некоректне значення. Спробуйте ще раз.");
			System.out.print(promt);
		}
		result = scan.nextInt();	

		//scan.close();
		
		return result;
	}
}
