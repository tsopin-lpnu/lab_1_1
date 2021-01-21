package ua.lpnu.tsopin;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.Scanner;

public class Stuff {
	
	final static double MIN_VALUE = -999.0;
	final static double MAX_VALUE =  999.0;
	
	static double [] generateArray(int count) {
		Random r = new Random();
		double [] array = new double[count];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = MIN_VALUE + (MAX_VALUE - MIN_VALUE) * r.nextDouble();
		}

		return array;
	}
	
	static void printArray(double [] array) {
		String temp = "|";
		for (double i : array) {
			temp += String.format(" %8.4f |", i);
		}
		
		System.out.println(temp);
	}
	
	static byte[] convertDoubleToByteArray(double[] array) {
		ByteBuffer bb = ByteBuffer.allocate(array.length * Double.BYTES);
		for (double d : array) {
			bb.putDouble(d);
		}
		return bb.array();
	}
	
	static double[] convertByteToDoubleArray(byte[] array) {
		ByteBuffer bb = ByteBuffer.wrap(array);
		double[] doubles = new double[array.length / Double.BYTES];
		for (int i = 0; i < doubles.length; i++) {
			doubles[i] = bb.getDouble();
		}
		return doubles;
	}
	
	static double avgPositive(double [] array) {
		int count = 0;
		double sum = 0.0;
		double res = 0.0;
		
		for (double i : array) {
			if (i > 0.0) {
				sum += i;
				count++;
			}
		}
		
		if (count > 0)
			res = sum / count;
		
		return res;
	}
	
	static double avgNegative(double [] array) {
		int count = 0;
		double sum = 0.0;
		double res = 0.0;
		
		for (double i : array) {
			if (i < 0.0) {
				sum += i;
				count++;
			}
		}
		
		if (count > 0)
			res = sum / count;
		
		return res;
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
