package ua.lpnu.tsopin;

public abstract class Curves {
	private double a;
	private double b;
	
	public Curves(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public Curves() {
		this.a = 0.0;
		this.b = 0.0;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
	public abstract boolean isPointAt(double x, double y);
	public abstract void Read();
	public abstract void Display();

}
