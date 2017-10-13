package lommeregner.logic;

public class Asin implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.asin(Math.toRadians(a));
	}
}
