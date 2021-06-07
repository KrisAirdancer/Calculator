package calculatorApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {

	private static final long serialVersionUID = 1L;
	
	private int value1;
	private int value2;
	private int result;
	private char operator;
	
	public Calculator() {

		// Create calculator GUI
		CalculatorGUI GUI = new CalculatorGUI();
		
	}
	
	public void calculate(String input) {

		
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();

	}
}