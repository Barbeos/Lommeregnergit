package lommeregner.logic;

public class Gange implements BinaryOperator {
	private double a;
	private double b;
	public void setA(double a) {
		this.a=a;
	}
	public void setB(double b) {
		this.b=b;
	}
	public double getValue() {
		return a * b;
	}
}