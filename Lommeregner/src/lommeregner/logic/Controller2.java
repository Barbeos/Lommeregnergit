package lommeregner.logic;

import java.util.ArrayList;

public class Controller2 {

	String temp2;
	double tal = 0;
	ArrayList<Input> operatorObjects = new ArrayList<Input>();
	ArrayList<String> numbers = new ArrayList<String>();
	ArrayList<String> operators = new ArrayList<String>();

	public double stringManipulation(String temp) {
		// step 1: make 2 different lists
		// A numbers list in the order they where typed
		// A operators list in the order they where typed
		if (temp.contains("=")) {
			for (char c : temp.toCharArray()) {
				String temp3 = "" + c;
				if (isInt(temp3)) {
					temp2 += "" + c;
				} else {
					numbers.add(temp2);
					operators.add(temp3);
					temp2 = "";
				}
			}
		}
		
		ArrayList<Input> num = new ArrayList<Input>();
		Input plus = new Plus();
		num.add(plus);
		BinaryOperator h = (BinaryOperator)num.get(0);
		
		
		temp2 = "";
		// step 2: make the operator objects ready for use
		// Checks which operators are needed to do the calculations of the input
		// and adding them to the Input ArrayList as objects
		/*
		 * makes new objects for each operator by going through the operator list adds
		 * them in order keeps them in the order for precedence
		 */
		if (temp.contains("=")) {
			for (String s : operators) {
				if (s.equals("+")) {
					operatorObjects.add(new Plus());
				} else if (s.equals("-")) {
					operatorObjects.add(new Minus());
				} else if (s.equals("*")) {
					operatorObjects.add(new Gange());
				}
			}
		}

		// step 3:
		// precedence of operators and doing the calculations by using the objects made
		// in step 2
		// the order in which the while loops is set determines the precedence order
		if (temp.contains("=")) {
			while (operators.contains("*")) {
				resultBinary("*");
			}
			while (operators.contains("+")) {
				resultBinary("+");
			}
		}
		return tal;
	}

	public Boolean isInt(String temp3) {
		try {
			Integer.parseInt(temp3);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	// is used with step 3
	// make sure the indexes of various ArrayLists are up to date.
	public void resultBinary(String operator) {
		int index = 0;
		index = operators.indexOf(operator);
		BinaryOperator h = (BinaryOperator)operatorObjects.get(index);
		h.setA(Double.parseDouble(numbers.get(index)));
		h.setB(Double.parseDouble(numbers.get(index + 1)));
		numbers.remove(index + 1);
		numbers.remove(index);
		numbers.add(index, String.valueOf(operatorObjects.get(index).getValue()));
		tal = operatorObjects.get(index).getValue();
		operatorObjects.remove(index);
		operators.remove(operator);
	}
	
	public void resultUnary(String operator) {
		int index = 0;
		index = operators.indexOf(operator);
		UnaryOperator h = (UnaryOperator)operatorObjects.get(index);
		h.setA(Double.parseDouble(numbers.get(index)));
		numbers.remove(index + 1);
		numbers.remove(index);
		numbers.add(index, String.valueOf(operatorObjects.get(index).getValue()));
		tal = operatorObjects.get(index).getValue();
		operatorObjects.remove(index);
		operators.remove(operator);
	}
}
