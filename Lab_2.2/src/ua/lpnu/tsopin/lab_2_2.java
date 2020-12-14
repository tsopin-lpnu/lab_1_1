package ua.lpnu.tsopin;

public class lab_2_2 {

	public static void main(String[] args) {
		int n = 0, k = 0;
		
		while((k = Stuff.readInt("¬вед≥ть к≥льк≥сть р€дк≥в в матриц≥: ")) < 1) {
			System.out.println("к≥льк≥сть р€дк≥в повиннo бути б≥льше 0.");
		}
		
		while((n = Stuff.readInt("¬вед≥ть к≥льк≥сть стопц≥в в матриц≥: ")) < 1) {
			System.out.println("к≥льк≥сть стопц≥в повиннo бути б≥льше 0.");
		}
		
		int [][] array = new int[k][n];
		
		Stuff.createArray(array);
		System.out.println();
		System.out.println("«генерована матриц€:");
		Stuff.printArray(array);
		System.out.println();
		Stuff.doSomething(array);
		System.out.println();
		System.out.println("–езультат:");
		Stuff.printArray(array);

	}

}
