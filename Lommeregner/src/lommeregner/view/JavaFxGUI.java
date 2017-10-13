package lommeregner.view;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import lommeregner.logic.BinaryOperator;
import lommeregner.logic.Controller;
import lommeregner.logic.*;

public class JavaFxGUI extends Application implements EventHandler<ActionEvent> {
	// display skabes som textfield udenfor "start" because reasons
	TextField display = new TextField();

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Lommeregner");

		// Grid skabes og styles
		GridPane grid = new GridPane();
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(20, 20, 20, 20));
		// grid.setGridLinesVisible(true);

		// Displayet styles
		display.setPrefSize(0, 50);
		grid.add(display, 0, 0, 6, 1);
		display.setAlignment(Pos.CENTER_RIGHT);
		display.setStyle("-fx-base: lightblue");
		display.setFont(Font.font("Batang", FontWeight.NORMAL, 30));
		display.setEditable(false);
		// Knapper med tallene 0-9 skabes, styles og tilføjes til array "numbers"
		ArrayList<Button> numbers = new ArrayList<Button>();
		for (int x = 0; x < 10; x++) {
			numbers.add(new Button("" + x));
			numbers.get(x).setFont(Font.font("Berlin sans fb", FontWeight.NORMAL, 35));
			numbers.get(x).setStyle("-fx-base: black");
			numbers.get(x).setPrefSize(80, 80);
			numbers.get(x).setOnAction(this);
		}

		// andre knapper skabes og tilføjes til arrayet "otherButts"
		ArrayList<Button> otherButts = new ArrayList<Button>();
		Button ce = new Button("CE");
		otherButts.add(ce);
		Button s = new Button("S");
		otherButts.add(s);
		Button pi = new Button("pi");
		otherButts.add(pi);
		Button iAnden = new Button("x^2");
		otherButts.add(iAnden);
		Button sqrt = new Button("sqrtx");
		otherButts.add(sqrt);
		Button divider = new Button("/");
		otherButts.add(divider);
		Button sin = new Button("Sin");
		otherButts.add(sin);
		Button arcSin = new Button("Sin-1");
		otherButts.add(arcSin);
		Button gange = new Button("*");
		otherButts.add(gange);
		Button cos = new Button("Cos");
		otherButts.add(cos);
		Button arcCos = new Button("Cos-1");
		otherButts.add(arcCos);
		Button minus = new Button("-");
		otherButts.add(minus);
		Button tan = new Button("Tan");
		otherButts.add(tan);
		Button arcTan = new Button("Tan-1");
		otherButts.add(arcTan);
		Button plusMinus = new Button("PM");
		otherButts.add(plusMinus);
		Button komma = new Button(".");
		otherButts.add(komma);

		// knapperne i arrayet "otherButts" styles
		for (Button z : otherButts) {
			z.setPrefSize(80, 80);
			z.setStyle("-fx-base: black");
			z.setFont(Font.font("Berlin sans fb", FontWeight.NORMAL, 20));
			z.setOnAction(this);
		}

		// = og + knapperne skabes og styles
		Button ligMed = new Button("=");
		Button plus = new Button("+");

		ligMed.setPrefSize(165, 80);
		ligMed.setStyle("-fx-base: black");
		ligMed.setFont(Font.font("Berlin sans fb", FontWeight.NORMAL, 20));
		ligMed.setOnAction(this);
		plus.setPrefSize(80, 165);
		plus.setStyle("-fx-base: black");
		plus.setFont(Font.font("Berlin sans fb", FontWeight.NORMAL, 20));
		plus.setOnAction(this);
		// knapper (otherButts, +, =) tilføjes til grid
		grid.add(ce, 0, 1);
		grid.add(s, 1, 1);
		grid.add(pi, 2, 1);
		grid.add(iAnden, 3, 1);
		grid.add(sqrt, 4, 1);
		grid.add(divider, 5, 1);
		grid.add(sin, 3, 2);
		grid.add(arcSin, 4, 2);
		grid.add(gange, 5, 2);
		grid.add(cos, 3, 3);
		grid.add(arcCos, 4, 3);
		grid.add(minus, 5, 3);
		grid.add(tan, 3, 4);
		grid.add(arcTan, 4, 4);
		grid.add(plusMinus, 0, 5);
		grid.add(komma, 2, 5);
		grid.add(plus, 5, 4, 1, 2);
		grid.add(ligMed, 3, 5, 3, 1);

		// knapper 1-9 tilføjes til grid
		int index = 9;
		for (int y = 2; y < 5; y++) {
			for (int x = 2; x >= 0; x--) {

				grid.add(numbers.get(index), x, y);
				index -= 1;
			}
		}
		
		

		// knap 0 tilføjes til grid
		grid.add(numbers.get(0), 1, 5);

		// scenen instantieres, styles og vises
		Scene scene = new Scene(grid);
		grid.setStyle("-fx-base: Darkblue");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	Controller controller = new Controller();
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
	ArrayList<Input> inputString = new ArrayList<Input>();
	String temp = "";
	String temp2 = "";
	// eventhandling
	@Override
	public void handle(ActionEvent e) {
		Object obj = e.getSource();
		Button button = (Button) obj;
		String text = button.getText();
		
		
		

		// display.setText(display.getText() + text);
		System.out.println(button.getText());
//		for (int x = 0; x < 10; x++) {
//			if (button.getText().equals("" + x)) {
				display.setText(display.getText() + text);
				temp = display.getText();
				System.out.println(temp + "string");
//			}
//		}
		
		
		ArrayList<String> tempString = new ArrayList<String>();
		
		
		if(button.getText().equals("=")) {
			for(char c : temp.toCharArray()) {
				String temp3 = "" + c; 
				if(isInt(temp3)) {
					temp2 += "" + c; 
					System.out.println(temp2 + "hej");
				}else {
					System.out.println(temp2 + "add");
					tempString.add(temp2);
					tempString.add(temp3);
					temp2 = "";
				}
				
				
				if(button.getText().equals("+")) {
					
				}
			}
		}
		
		if(button.getText().equals("=")) {
			for(String s : tempString) {
				if(button.getText().equals("+")) {
					
				}
				System.out.println(s + "   " +"yay");
			}
			
			
		}
		
		
		
		temp ="";
		temp2 ="";
//		if (button.getText().equals(".")) {
//			display.setText(display.getText() + text);
//		} else if (button.getText().equals("pi")) {
//			display.setText(String.valueOf(Math.PI));
//		} else if (button.getText().equals("CE")) {
//			display.setText("");
//		} else if (button.getText().equals("S")) {
//			display.setText(controller.deleteOne(display));
//		} else if (button.getText().equals("+")) {
//			saveOperator = button.getText();
//			display.setText(controller.addition(display, plus));
//		} else if (button.getText().equals("-")) {
//			saveOperator = button.getText();
//			display.setText(controller.subtraction(display, minus));
//		} else if (button.getText().equals("*")) {
//			saveOperator = button.getText();
//			display.setText(controller.multiply(display, gange));
//		} else if (button.getText().equals("/")) {
//			saveOperator = button.getText();
//			display.setText(controller.division(display, divider));
//		} else if (button.getText().equals("Sin")) {
//			saveOperator = button.getText();
//			display.setText(controller.gSin(display,sinus));
//		}
//		  else if (button.getText().equals("Cos")) {
//				saveOperator = button.getText();
//				display.setText(controller.gCos(display,cosinus));
//			}
//		  else if (button.getText().equals("Tan")) {
//				saveOperator = button.getText();
//				display.setText(controller.gTan(display,tangens));
//			}
//		  else if (button.getText().equals("x^2")) {
//				saveOperator = button.getText();
//				display.setText(controller.iAnden(display,iAnden));
//			}
//		  else if (button.getText().equals("sqrtx")) {
//				saveOperator = button.getText();
//				display.setText(controller.sqrtx(display,sqrt));
//			}
//		  else if (button.getText().equals("PM")) {
//				saveOperator = button.getText();
//				display.setText(controller.plusMinus(display,pm));
//			}
//		
//		
//		else if (button.getText().equals("=")) {
//			if (saveOperator.equals("+")) {
//				display.setText(controller.ligmedBinary(display, plus));
//			} else if (saveOperator.equals("-")) {
//				display.setText(controller.ligmedBinary(display, minus));
//			} else if (saveOperator.equals("*")) {
//				display.setText(controller.ligmedBinary(display, gange));
//			} else if (saveOperator.equals("/")) {
//				display.setText(controller.ligmedBinary(display, divider));
//			}
//			
//		}
	}
	
	public Boolean isInt(String temp3) {
		try {
			Integer.parseInt(temp3);
			return true;
		}catch(NumberFormatException ex){
			return false;
		}
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
// besked til os selv: husk at kunne flytte med piltasterne.
// pilletaster.
// fix komma. Det er lort.
//husk atan, acos