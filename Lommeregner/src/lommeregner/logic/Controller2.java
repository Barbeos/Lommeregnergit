package lommeregner.logic;

import java.util.ArrayList;

public class Controller2 {
	BinaryOperator plus = new Plus();
	BinaryOperator minus = new Minus();
	BinaryOperator gange = new Gange();
	BinaryOperator divider = new Divider();
	String saveOperator = "";
	UnaryOperator sinus = new Sinus();
	UnaryOperator cosinus = new Cosinus();
	UnaryOperator tangens = new Tangens();
	UnaryOperator iAnden = new Ianden();
	UnaryOperator sqrt = new Sqrt();
	UnaryOperator pm = new PlusMinus();
	String temp2;
	ArrayList<String> tempString = new ArrayList<String>();
	ArrayList<BinaryOperator> inputString = new ArrayList<BinaryOperator>();
	ArrayList<String> numbers = new ArrayList<String>();
	
	
	public double stringManipulation(String temp) {
		//make a String ArrayList of the input
		if (temp.contains("=")) {
			for (char c : temp.toCharArray()) {
				String temp3 = "" + c;
				if (isInt(temp3)) {
					temp2 += "" + c;
				} else {
					numbers.add(temp2);
					tempString.add(temp2);
					tempString.add(temp3);
					temp2 = "";
				}
			}
		}
		//Checks which operators are needed to do the calculations of the input 
		//and adding them to the Input ArrayList as objects
		if (temp.contains("=")) {
			for (String s : tempString) {
				if (s.equals("+")) {
					BinaryOperator plus = new Plus();
					inputString.add(plus);
				}else if(s.equals("-")) {
					BinaryOperator minus = new Minus();
					inputString.add(minus);
				}else if(s.equals("*")) {
					//BinaryOperator gange = new Gange();
					inputString.add(new Gange());
					System.out.print(s+"s");
				}
				
				//System.out.println(s);
			}
		}
		int index = 0;
		double tal = 0;
		
		for(Input s : inputString) {
			System.out.println(s);
		}
		
		System.out.println(inputString);
		//precedence of operators and doing the calculations
		if (temp.contains("=")) {
		while(inputString.contains(gange)) {
			index = inputString.indexOf(gange);
		
			inputString.get(index).setA(Double.parseDouble(numbers.get(index)));
			inputString.get(index).setA(Double.parseDouble(numbers.get(index+ 1)));
			tal = inputString.get(index).getValue();
			System.out.println(Double.parseDouble(tempString.get(index)));
			
		}
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		int x = 0;
//		if (temp.contains("=")) {
//			for (String s : tempString) {
//				if (s.equals("+")) {
//					inputString.add(plus);
//					plus.setA(Double.parseDouble(tempString.get(x)));
//					plus.setB(Double.parseDouble(tempString.get(x+2)));
//					System.out.println(plus.getValue());
//					x = x+1;
//				}else if(s.equalsIgnoreCase("-")) {
//					inputString.add(minus);
//				}else if(s.equalsIgnoreCase("="))
//				System.out.println(s + "   " + "yay");
//			}
//
//		}
		temp = "";
		temp2 = "";
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
}
