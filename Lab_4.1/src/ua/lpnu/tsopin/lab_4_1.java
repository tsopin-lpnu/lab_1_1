package ua.lpnu.tsopin;

import java.io.IOException;

public class lab_4_1 {
	
	final static String TXT_FNAME = "array.txt";
	final static String BIN_FNAME = "array.bin";
	final static String TXT_RESULT_FNAME = "result.txt";
	final static String BIN_RESULT_FNAME = "result.bin";

	public static void main(String[] args) {
		int count = 0;
		
		while((count = Stuff.readInt("Введіть кількість чисел: ")) < 1) {
			System.out.println("кількість чисел повинно бути більше 0.");
		}
		
		double [] array = Stuff.generateArray(count);
		
		try {
			System.out.println("Запис чисел в текстовий файл...");
			FileStuff.writeInTextFile(TXT_FNAME, array);
			System.out.println("Запис чисел в бінарний файл...");
			FileStuff.writeInBinaryFile(BIN_FNAME, array);
			
			System.out.println("Читання чисел з текстового файлу...");
			double [] fromTextFile = FileStuff.readFromTextFile(TXT_FNAME);
			System.out.println("Читання чисел з бінарного файлу...");
			double [] fromBinaryFile = FileStuff.readFromBinaryFile(BIN_FNAME);
			
			double [] resultText = new double[2];
			resultText[0] = Stuff.avgNegative(fromTextFile);
			resultText[1] = Stuff.avgPositive(fromTextFile);
			System.out.println("Запис результату в текстовий файл...");
			FileStuff.writeInTextFile(TXT_RESULT_FNAME, resultText);
			
			double [] resultBinary = new double[2];
			resultBinary[0] = Stuff.avgNegative(fromBinaryFile);
			resultBinary[1] = Stuff.avgPositive(fromBinaryFile);
			System.out.println("Запис результату в бінарний файл...");
			FileStuff.writeInBinaryFile(BIN_RESULT_FNAME, resultBinary);
			
			double [] resultTextFile = FileStuff.readFromTextFile(TXT_RESULT_FNAME);
			double [] resultBinaryFile = FileStuff.readFromBinaryFile(BIN_RESULT_FNAME);
			
			System.out.println();
			System.out.println("Результат:");
			System.out.printf("\t\t\t| середнє арифметичне від’ємних\t| середнє арифметичне додатних\t|\n");
			System.out.printf("З текстового файлу \t| %8.4f\t\t\t| %8.4f\t\t\t|\n",resultTextFile[0],resultTextFile[1]);
			System.out.printf("З бінарного файлу \t| %8.4f\t\t\t| %8.4f\t\t\t|\n",resultBinaryFile[0],resultBinaryFile[1]);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
	}

}
