package lommeregner.logic;

public class Tangens implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.tan(Math.toRadians(a));
	}
}
