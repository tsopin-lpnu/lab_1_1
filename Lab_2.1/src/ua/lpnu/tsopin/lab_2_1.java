package ua.lpnu.tsopin;

public class lab_2_1 {

	public static void main(String[] args) {
		
		int n = 0;
		int min, max;
		
		while((n = Stuff.readInt("������ ������� ������: ")) < 1) {
			System.out.println("������� ������ ������� ���� ����� 0.");
		}
		
		int [] array = new int[n];
		
		Stuff.createArray(array);
		min = Stuff.min(array);
		max = Stuff.max(array);
		
		System.out.println("");
		System.out.println("���������:");

		Stuff.printArray(array);

		System.out.println("����������� �������� ������ = " + max);
		System.out.println("̳������� �������� ������ = " + min);
		System.out.println("���� ������������� � ���������� �������� ������ = " + (min + max));

	}

}
