package ua.lpnu.tsopin;

public class lab_1_1 {
	
	public static void main(String[] args) {
		
		double s, t;
		double resultOfTheFuction, resultArrayParametrs, resultObjectsParametrs;
		
		double [] arrayParam1 = new double[1];
		double [] arrayParam2 = new double[1];
		double [] arrayParam3 = new double[1];
		
		MyDouble objectParam1 = new MyDouble();
		MyDouble objectParam2 = new MyDouble();
		MyDouble objectParam3 = new MyDouble();
		
		s = Stuff.readDouble("������ s: ");
		t = Stuff.readDouble("������ t: ");

		Stuff.h(s, Math.pow(t, 2), arrayParam1);
		Stuff.h(t, (1.0 + Math.pow(s, 2)), arrayParam2);
		Stuff.h(s * t, 1.0, arrayParam3);

		Stuff.h(s, Math.pow(t, 2), objectParam1);
		Stuff.h(t, (1.0 + Math.pow(s, 2)), objectParam2);
		Stuff.h(s * t, 1.0, objectParam3);
		
		resultOfTheFuction = (Stuff.h(s, Math.pow(t, 2.0)) + Math.pow(Stuff.h(t, (1.0 + Math.pow(s, 2.0))), 2.0)) / (1.0 + Stuff.h(s * t, 1.0));
		resultArrayParametrs = (arrayParam1[0] + Math.pow(arrayParam2[0], 2.0)) / (1.0 + arrayParam3[0]);
		resultObjectsParametrs = (objectParam1.value + Math.pow(objectParam2.value, 2.0)) / (1.0 + objectParam3.value);
		
		System.out.println("���������(��������� �������):\t\t\t" + resultOfTheFuction);
		System.out.println("���������(���������-��������� ����� �����):\t" + resultArrayParametrs);
		System.out.println("���������(���������-��������� ����� ��'���):\t" + resultObjectsParametrs);
		
	}
}
