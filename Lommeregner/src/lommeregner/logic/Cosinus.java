package lommeregner.logic;

public class Cosinus implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.cos(Math.toRadians(a));
	}
}

