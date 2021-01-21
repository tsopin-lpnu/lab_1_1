package ua.lpnu.tsopin;

public class Triad {
	private int first;
	private int second;
	private int third;
	
	public Triad() {
		this.first = 0;
		this.second = 0;
		this.third = 0;
	}
	
	public Triad(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public Triad(Triad other) {
		this.first = other.first;
		this.second = other.second;
		this.third = other.third;
	}
	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public void incFirst() {
		this.first = this.first++;
	}

	public void incSecond() {
		this.second = this.second++;
	}

	public void incThird() {
		this.third = this.third++;
	}

	@Override
	public String toString() {
		return "[" + first + ", " + second + ", " + third + "]";
	}
	
	public void Display() {
		System.out.println(this.toString());
	}

}
