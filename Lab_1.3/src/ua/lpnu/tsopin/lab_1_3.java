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
		
		n = Stuff.readInt("������ N: ");
		
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
		
		System.out.println("����������(while):");
		System.out.println("��������� �������:\t\t\t" + resultWhileFunction);
		System.out.println("���������-��������� ����� �����:\t" + resultWhileArray[0]);
		System.out.println("���������-��������� ����� ��'���:\t" + resultWhileObject.value);
		System.out.println("");
		System.out.println("����������(do-while):");
		System.out.println("��������� �������:\t\t\t" + resultDoWhileFunction);
		System.out.println("���������-��������� ����� �����:\t" + resultDoWhileArray[0]);
		System.out.println("���������-��������� ����� ��'���:\t" + resultDoWhileObject.value);
		System.out.println("");
		System.out.println("����������(for i++):");
		System.out.println("��������� �������:\t\t\t" + resultForIncFunction);
		System.out.println("���������-��������� ����� �����:\t" + resultForIncArray[0]);
		System.out.println("���������-��������� ����� ��'���:\t" + resultForIncObject.value);
		System.out.println("");
		System.out.println("����������(for i--):");
		System.out.println("��������� �������:\t\t\t" + resultForDecFunction);
		System.out.println("���������-��������� ����� �����:\t" + resultForDecArray[0]);
		System.out.println("���������-��������� ����� ��'���:\t" + resultForDecObject.value);
	}

}
