package ua.lpnu.tsopin;

public class lab_1_2 {

	public static void main(String[] args) {
		
		double a, b, c, x;
		double resultShortFunction = 0.0, resultFullFunction = 0.0;
		
		double [] resultShortArray = new double[1];
		double [] resultFullArray  = new double[1]; 
		
		MyDouble resultFullObject = new MyDouble();
		MyDouble resultShortObject = new MyDouble();
		
		a = Stuff.readDouble("������ a: ");
		b = Stuff.readDouble("������ b: ");
		c = Stuff.readDouble("������ c: ");
		x = Stuff.readDouble("������ x: ");
		
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
		
		System.out.println("����������(��������� ����� ������������):");
		System.out.println("��������� �������:\t\t\t" + resultShortFunction);
		System.out.println("���������-��������� ����� �����:\t" + resultShortArray[0]);
		System.out.println("���������-��������� ����� ��'���:\t" + resultShortObject.value);
		System.out.println("");
		System.out.println("����������(����� ����� ������������):");
		System.out.println("��������� �������:\t\t\t" + resultFullFunction);
		System.out.println("���������-��������� ����� �����:\t" + resultFullArray[0]);
		System.out.println("���������-��������� ����� ��'���:\t" + resultFullObject.value);
	}

}
