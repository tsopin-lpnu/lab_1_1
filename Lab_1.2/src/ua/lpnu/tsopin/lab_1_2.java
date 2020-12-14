package ua.lpnu.tsopin;

public class lab_1_2 {

	public static void main(String[] args) {
		
		double a, b, c, x;
		double resultShortFunction = 0.0, resultFullFunction = 0.0;
		
		double [] resultShortArray = new double[1];
		double [] resultFullArray  = new double[1]; 
		
		MyDouble resultFullObject = new MyDouble();
		MyDouble resultShortObject = new MyDouble();
		
		a = Stuff.readDouble("Введіть a: ");
		b = Stuff.readDouble("Введіть b: ");
		c = Stuff.readDouble("Введіть c: ");
		x = Stuff.readDouble("Введіть x: ");
		
		try {
			resultShortFunction = Stuff.FShortForm(a, b, c, x);
			resultFullFunction = Stuff.FFullForm(a, b, c, x);
			
			Stuff.FShortForm(a, b, c, x, resultShortArray);
			Stuff.FFullForm(a, b, c, x, resultFullArray);
			
			Stuff.FShortForm(a, b, c, x, resultShortObject);
			Stuff.FFullForm(a, b, c, x, resultFullObject);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Результати(скорочена форма розгалуження):");
		System.out.println("Результат функції:\t\t\t" + resultShortFunction);
		System.out.println("Параметри-посилання через масив:\t" + resultShortArray[0]);
		System.out.println("Параметри-посилання через об'єкт:\t" + resultShortObject.value);
		System.out.println("");
		System.out.println("Результати(повна форма розгалуження):");
		System.out.println("Результат функції:\t\t\t" + resultFullFunction);
		System.out.println("Параметри-посилання через масив:\t" + resultFullArray[0]);
		System.out.println("Параметри-посилання через об'єкт:\t" + resultFullObject.value);
	}

}
