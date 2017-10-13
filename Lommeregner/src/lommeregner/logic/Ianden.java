package lommeregner.logic;

public class Ianden implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.pow(a, 2);
	}
}
