package ua.lpnu.tsopin;

public class lab_1_3 {

	public static void main(String[] args) {
		int n;
		
		double resultWhileFunction, resultDoWhileFunction, resultForIncFunction, resultForDecFunction;
		
		double [] resultWhileArray = new double[1]; 
		double [] resultDoWhileArray = new double[1]; 
		double [] resultForIncArray = new double[1]; 
		double [] resultForDecArray = new double[1];
		
		MyDouble resultWhileObject = new MyDouble();
		MyDouble resultDoWhileObject = new MyDouble();
		MyDouble resultForIncObject = new MyDouble();
		MyDouble resultForDecObject = new MyDouble();
		
		n = Stuff.readInt("Введіть N: ");
		
		resultWhileFunction = Stuff.FWhile(n);
		resultDoWhileFunction = Stuff.FDoWhile(n);
		resultForIncFunction = Stuff.FForInc(n);
		resultForDecFunction = Stuff.FForDec(n);
		
		Stuff.FWhile(n, resultWhileArray);
		Stuff.FDoWhile(n, resultDoWhileArray);
		Stuff.FForInc(n, resultForIncArray);
		Stuff.FForDec(n, resultForDecArray);
		
		Stuff.FWhile(n, resultWhileObject);
		Stuff.FDoWhile(n, resultDoWhileObject);
		Stuff.FForInc(n, resultForIncObject);
		Stuff.FForDec(n, resultForDecObject);
		
		System.out.println("Результати(while):");
		System.out.println("Результат функції:\t\t\t" + resultWhileFunction);
		System.out.println("Параметри-посилання через масив:\t" + resultWhileArray[0]);
		System.out.println("Параметри-посилання через об'єкт:\t" + resultWhileObject.value);
		System.out.println("");
		System.out.println("Результати(do-while):");
		System.out.println("Результат функції:\t\t\t" + resultDoWhileFunction);
		System.out.println("Параметри-посилання через масив:\t" + resultDoWhileArray[0]);
		System.out.println("Параметри-посилання через об'єкт:\t" + resultDoWhileObject.value);
		System.out.println("");
		System.out.println("Результати(for i++):");
		System.out.println("Результат функції:\t\t\t" + resultForIncFunction);
		System.out.println("Параметри-посилання через масив:\t" + resultForIncArray[0]);
		System.out.println("Параметри-посилання через об'єкт:\t" + resultForIncObject.value);
		System.out.println("");
		System.out.println("Результати(for i--):");
		System.out.println("Результат функції:\t\t\t" + resultForDecFunction);
		System.out.println("Параметри-посилання через масив:\t" + resultForDecArray[0]);
		System.out.println("Параметри-посилання через об'єкт:\t" + resultForDecObject.value);
	}

}
