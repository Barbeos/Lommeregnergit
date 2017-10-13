package lommeregner.logic;

public class Sqrt implements UnaryOperator{
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return Math.sqrt(a);
	}
}
