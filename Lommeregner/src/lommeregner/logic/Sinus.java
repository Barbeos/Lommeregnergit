package lommeregner.logic;

public class Sinus implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.sin(Math.toRadians(a));
	}
}
