package ua.lpnu.tsopin;

public class lab_2_2 {

	public static void main(String[] args) {
		int n = 0, k = 0;
		
		while((k = Stuff.readInt("������ ������� ����� � �������: ")) < 1) {
			System.out.println("������� ����� ������o ���� ����� 0.");
		}
		
		while((n = Stuff.readInt("������ ������� ������� � �������: ")) < 1) {
			System.out.println("������� ������� ������o ���� ����� 0.");
		}
		
		int [][] array = new int[k][n];
		
		Stuff.createArray(array);
		System.out.println();
		System.out.println("����������� �������:");
		Stuff.printArray(array);
		System.out.println();
		Stuff.doSomething(array);
		System.out.println();
		System.out.println("���������:");
		Stuff.printArray(array);

	}

}
