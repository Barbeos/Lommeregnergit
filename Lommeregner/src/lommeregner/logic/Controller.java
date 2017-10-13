package lommeregner.logic;

import java.util.ArrayList;

import javafx.scene.control.TextField;;

public class Controller {

	public String deleteOne(TextField display) {
		ArrayList<Character> findSidste = new ArrayList<Character>();
		for (char c : display.getText().toCharArray()) {
			findSidste.add(c);
		}
		String tal = "";
		findSidste.remove(findSidste.size() - 1);
		for (int x = 0; x < findSidste.size(); x++) {
			tal += findSidste.get(x);
		}
		return tal;
	}

	

	double tal,tal2;
	BinaryOperator plus = new Plus();
//	public String addition(String one, String two) {
//
//		tal = Double.parseDouble(display.getText());
//		plus.setA(tal);
//		return "";
//
//	}
	
//	public String addition(TextField display,BinaryOperator plus) {
//
//		tal = Double.parseDouble(display.getText());
//		plus.setA(tal);
//		return "";
//
//	}
	public String subtraction(TextField display,BinaryOperator minus) {

		tal = Double.parseDouble(display.getText());
		minus.setA(tal);
		return "";

	}
	public String multiply(TextField display,BinaryOperator gange) {

		tal = Double.parseDouble(display.getText());
		gange.setA(tal);
		return "";

	}
	public String division(TextField display,BinaryOperator divider) {

		tal = Double.parseDouble(display.getText());
		divider.setA(tal);
		return "";

	}
	public String ligmedBinary(TextField display, BinaryOperator binaryOperators) {
		tal2 = Double.parseDouble(display.getText());
		binaryOperators.setB(tal2);

		return ""+ binaryOperators.getValue() ;
	}
	public String gSin(TextField display, UnaryOperator sinus) {
		tal = Double.parseDouble(display.getText());
		sinus.setA(tal);
		return "" + sinus.getValue();
	}
	public String gCos(TextField display, UnaryOperator cosinus) {
		tal = Double.parseDouble(display.getText());
		cosinus.setA(tal);
		return "" + cosinus.getValue();
	}
	public String gTan(TextField display, UnaryOperator tangens) {
		tal = Double.parseDouble(display.getText());
		tangens.setA(tal);
		return "" + tangens.getValue();
	}
	public String iAnden(TextField display, UnaryOperator iAnden) {
		tal = Double.parseDouble(display.getText());
		iAnden.setA(tal);
		return "" + iAnden.getValue();
	}
	public String sqrtx(TextField display, UnaryOperator sqrt) {
		tal = Double.parseDouble(display.getText());
		sqrt.setA(tal);
		return "" + sqrt.getValue();
	}
	public String plusMinus(TextField display, UnaryOperator pm) {
		tal = Double.parseDouble(display.getText());
		pm.setA(tal);
		return "" + pm.getValue();
	}
	
}
