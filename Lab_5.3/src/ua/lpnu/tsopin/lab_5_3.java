package ua.lpnu.tsopin;

public class lab_5_3 {

	public static void main(String[] args) {
		Time t = new Time(10, 59, 29);
		
		t.Display();
		t.incSeconds();
		t.Display();
		t.incMinutes();
		t.Display();
		t.addHour(20);
		t.Display();
		t.addMinutes(120);
		t.Display();
		t.addSeconds(3500);
		t.Display();

	}

}
