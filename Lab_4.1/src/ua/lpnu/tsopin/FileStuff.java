package ua.lpnu.tsopin;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class FileStuff {

	static int countLinesInTextFile(String fileName) throws IOException {
		File file = new File(fileName);
		int res = 0;
		
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))){
	        while (reader.readLine() != null) {
	        	res++;
	        }
	    }
	    return res;
	}
	
	static void writeInTextFile(String fileName, double [] array) throws IOException {
		File file = new File(fileName);
		file.createNewFile();

		try(PrintWriter txtFile = new PrintWriter(file)) {
			for (double i : array) {
				txtFile.println(i);
			}
		}
	}
	
	static double [] readFromTextFile(String fileName) throws IOException {
		File file = new File(fileName);
		int countLines = countLinesInTextFile(fileName);
		
		if (countLines < 1)
			throw new IOException("Файл "+file.getAbsolutePath()+" пустий");
		
		double [] result = new double [countLines];
		
		try(BufferedReader txtFile = new BufferedReader(new FileReader(file))) {
			String line = null;
			for(int i = 0; i < result.length;i++) {
				line = txtFile.readLine();
				if(line == null)
					break;
				result[i] = Double.valueOf(line.trim());
			}
		}
		
		return result;
	}

	static void writeInBinaryFile(String fileName, double [] array) throws IOException {
		File file = new File(fileName);
		file.createNewFile();

		try(OutputStream binFile = new BufferedOutputStream(new FileOutputStream(file)) ) {
			byte [] bytesArray = Stuff.convertDoubleToByteArray(array);
			binFile.write(bytesArray);
		}
	}
	
	static double [] readFromBinaryFile(String fileName) throws IOException {
		File file = new File(fileName);
		double [] result = null;
		int fileLength = (int) file.length();
		if (fileLength < Double.BYTES)
			throw new IOException("Файл "+file.getAbsolutePath()+" пустий");

		try(FileInputStream binFile = new FileInputStream(file)) {
			byte[] data = new byte[fileLength];
			binFile.read(data, 0, data.length);
			result = Stuff.convertByteToDoubleArray(data);
		}
		
		return result;
	}
}
