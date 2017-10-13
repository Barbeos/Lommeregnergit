package lommeregner.logic;

public class PlusMinus implements UnaryOperator {
	private double a;

	public void setA(double a) {
		this.a = a;
	}

	public double getValue() {
		return a * -1;
	}

}
