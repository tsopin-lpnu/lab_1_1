package ua.lpnu.tsopin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class SerializeStudent {
	
	static byte [] serialize(Student sdnt){
		ByteBuffer bb = ByteBuffer.allocate(1024);
		bb.putInt(sdnt.pn);
		bb.putInt(sdnt.surname.getBytes().length);
		bb.put(sdnt.surname.getBytes());
		bb.putInt(sdnt.mClass);
		bb.putInt(sdnt.specialty.ordinal());
		bb.putInt(sdnt.rPhysics);
		bb.putInt(sdnt.rMath);
		bb.putInt(sdnt.rComputerScience);
		
		return bb.array();
	}
	
	static Student deserialize() {
		
		return null;
	}
	
	static public void writeStudents(String fileName, Student []students) throws FileNotFoundException, IOException {
		File file = new File(fileName);
		file.createNewFile();
		
		ArrayList<Student> mStudents= new ArrayList<Student>();
		for (Student sdnt : students) {
			mStudents.add(sdnt);
		}
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)))
        {
				oos.writeObject(mStudents);
        }
	}
	
	static public Student [] readStudents(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(fileName);
		ArrayList<Student> mStudents = new ArrayList<Student>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
			mStudents=(ArrayList<Student>) ois.readObject();
        }
		
		Student []students = new Student[mStudents.size()];
		for(int i = 0; i < students.length; i++) {
			students[i] = mStudents.get(i);
		}
		
		//return (Student[]) mStudents.toArray();
		return students;
	}
}
