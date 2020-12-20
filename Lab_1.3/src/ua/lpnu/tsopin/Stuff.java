package ua.lpnu.tsopin;
import java.util.Scanner;

public class Stuff {
	
	final private static int START_K = 1;
	
	static private double F(int N, int K) {
		double doubleN = N * N;
		double doubleK = K * K;
		return (doubleK / doubleN) * Math.cos(doubleN / doubleK);
	}

	static double FWhile(int n)
	{
		double result = 1.0;
		int i = START_K;
		
		while (n >= i) {
			result *= F(n,i);
			i++;
		}
		
		return result;
	}

	static double FDoWhile(int n)
	{
		double result = 1.0;
		int i = START_K;

		if(n > 0) {
			do {
				result *= F(n, i);
			} while (n >= ++i);
		}
		return result;
	}
	
	static double FForInc(int n)
	{
		double result = 1.0;

		for(int i = START_K;i <= n;i++) {
			result *= F(n, i);
		}
		
		return result;
	}
	
	static double FForDec(int n)
	{
		double result = 1.0;

		for(int i = n;START_K <= i;i--) {
			result *= F(n, i);
		}
		
		return result;
	}
	
	static void FWhile(int n, double [] z) {
		z[0] = FWhile(n);
	}
	
	static void FDoWhile(int n, double [] z) {
		z[0] = FDoWhile(n);
	}
	
	static void FForInc(int n, double [] z) {
		z[0] = FForInc(n);
	}
	
	static void FForDec(int n, double [] z) {
		z[0] = FForDec(n);
	}
	
	static void FWhile(int n, MyDouble z) {
		z.value = FWhile(n);
	}
	
	static void FDoWhile(int n, MyDouble z) {
		z.value = FDoWhile(n);
	}
	
	static void FForInc(int n, MyDouble z) {
		z.value = FForInc(n);
	}
	
	static void FForDec(int n, MyDouble z) {
		z.value = FForDec(n);
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
