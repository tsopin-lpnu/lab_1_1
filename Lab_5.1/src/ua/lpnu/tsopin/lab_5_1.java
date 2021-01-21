package ua.lpnu.tsopin;

public class lab_5_1 {

	public static void main(String[] args) {
		
		Bill firstObj = new Bill(3, 5.0);
		firstObj.Display();
		
		System.out.println();
		
		Bill secondObj = new Bill();
		secondObj.Init(5, 6.0);
		secondObj.Display();
		
		System.out.println();
		
		Bill thirdObj = new Bill();
		thirdObj.Read();
		thirdObj.Display();

	}

}
