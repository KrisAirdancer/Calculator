package calculatorApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {

	private JButton zeroB, oneB, twoB, threeB, fourB, fiveB, sixB, sevenB, eightB,
	nineB, equalsB, addB, subtractB, multiB, divisionB, clearB, decimalB, negativeB;
	private double num, result;
	private char operator;
	private JTextField TextArea;
	private Object lastButton;
	private boolean firstCalculation, decimalCheck;
	Font text = new Font("Calibri", Font.BOLD, 16);
	
	public Calculator() {
				
		// Setting boolean flags
		firstCalculation = true;
		decimalCheck = false;
		
		// Creating a window for the calculator
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setLayout(new GridLayout());
		frame.setPreferredSize(new Dimension(300, 350)); // Setting the size of the calculator
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tell the program to terminate when the "X" button is clicked
		frame.setResizable(false); // Prevent resizing of the window
		
		// Creating GridBagConstraints for GridBagLayout
		GridBagConstraints gBC = new GridBagConstraints();
		
		// Creating a panel to hold the calculator buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		
		// Creating a Text Field to display input and output
		TextArea = new JTextField();
		TextArea.setBackground(Color.LIGHT_GRAY);
		TextArea.setFont(new Font("Calibri", Font.BOLD, 25));
		TextArea.setEditable(false);
		
		// Creating buttons for the calculator
		zeroB = new JButton("0");
		oneB = new JButton("1");
		twoB = new JButton("2");
		threeB = new JButton("3");
		fourB = new JButton("4");
		fiveB = new JButton("5");
		sixB = new JButton("6");
		sevenB = new JButton("7");
		eightB = new JButton("8");
		nineB = new JButton("9");
		equalsB = new JButton("=");
		addB = new JButton("+");
		subtractB = new JButton("-");
		multiB = new JButton("x");
		divisionB = new JButton("/");
		clearB = new JButton("C");
		decimalB = new JButton(".");
		negativeB = new JButton("+/-");
		
		// Setting buttons' font size
		zeroB.setFont(text);
		oneB.setFont(text);
		twoB.setFont(text);
		threeB.setFont(text);
		fourB.setFont(text);
		fiveB.setFont(text);
		sixB.setFont(text);
		sevenB.setFont(text);
		eightB.setFont(text);
		nineB.setFont(text);
		equalsB.setFont(text);
		addB.setFont(text);
		subtractB.setFont(text);
		multiB.setFont(text);
		divisionB.setFont(text);
		clearB.setFont(text);
		decimalB.setFont(text);
		negativeB.setFont(text);
		
		// Adding ActionListeners to buttons
		zeroB.addActionListener(this);
		oneB.addActionListener(this);
		twoB.addActionListener(this);
		threeB.addActionListener(this);
		fourB.addActionListener(this);
		fiveB.addActionListener(this);
		sixB.addActionListener(this);
		sevenB.addActionListener(this);
		eightB.addActionListener(this);
		nineB.addActionListener(this);
		equalsB.addActionListener(this);
		addB.addActionListener(this);
		subtractB.addActionListener(this);
		multiB.addActionListener(this);
		divisionB.addActionListener(this);
		clearB.addActionListener(this);
		decimalB.addActionListener(this);
		negativeB.addActionListener(this);

		// Adding buttons to the frame panel
		// Setting the buttons to fill the panel and frame
		gBC.weightx = 1;
		gBC.weighty = 1;
		// Setting the width and height of the buttons (in terms of the grid)
		gBC.gridwidth = 1;
		gBC.gridheight = 1;
		gBC.fill = GridBagConstraints.BOTH; // Set buttons to fill their grid space
		
		// Loop for row number
		for (int index = 0; index < 5; index++) {
			gBC.gridy = index;
			// Loop for column number
			for (int i = 0; i < 4; i++) {
				gBC.gridx = i;
				
				if (index == 0 && i == 0) {					
					buttonPanel.add(clearB, gBC);
				} else if (index == 0 && i == 1) {
					buttonPanel.add(negativeB, gBC);
				} else if (index == 0 && i == 2) {
					gBC.gridx = 2;
					gBC.gridwidth = 2;
					buttonPanel.add(TextArea, gBC);
					// Resetting variables
					gBC.gridwidth = 1;
					gBC.gridx = 3;
				} else if (index == 0 && i == 3) {
					// Do nothing
				} else if (index == 1 && i == 0) {
					buttonPanel.add(sevenB, gBC);
				} else if (index == 1 && i == 1) {
					buttonPanel.add(eightB, gBC);
				} else if (index == 1 && i == 2) {
					buttonPanel.add(nineB, gBC);
				} else if (index == 1 && i == 3) {
					buttonPanel.add(divisionB, gBC);
				} else if (index == 2 && i == 0) {
					buttonPanel.add(fourB, gBC);
				} else if (index == 2 && i == 1) {
					buttonPanel.add(fiveB, gBC);
				} else if (index == 2 && i == 2) {
					buttonPanel.add(sixB, gBC);
				} else if (index == 2 && i == 3) {
					buttonPanel.add(multiB, gBC);
				} else if (index == 3 && i == 0) {
					buttonPanel.add(oneB, gBC);
				} else if (index == 3 && i == 1) {
					buttonPanel.add(twoB, gBC);
				} else if (index == 3 && i == 2) {
					buttonPanel.add(threeB, gBC);
				} else if (index == 3 && i == 3) {
					buttonPanel.add(subtractB, gBC);
				} else if (index == 4 && i == 0) {
					buttonPanel.add(decimalB, gBC);
				} else if (index == 4 && i == 1) {
					buttonPanel.add(zeroB, gBC);
				} else if (index == 4 && i == 2) {
					buttonPanel.add(equalsB, gBC);
				} else if (index == 4 && i == 3) {
					buttonPanel.add(addB, gBC);
				}
			}
		}
		
		buttonPanel.setVisible(true);
		frame.add(buttonPanel);		
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		/* Prevents the calculator from concatenating the results of two consecutive
		 * calculations that are separated by an equals operator. Acts like the 
		 * clear button's operation. */
		if (lastButton == equalsB && e.getSource() != addB
				&& e.getSource() != subtractB && e.getSource() != multiB
				&& e.getSource() != divisionB) {
			TextArea.setText("");
			num = 0;
			result = 0;
			firstCalculation = true;
			decimalCheck = false;
		}
		
		/* Prevents the program from crashing after a DivZero error b/c
		 * the program pulls the "DivZero" string from the text field as
		 * the previous numerical input. */
		if (TextArea.getText().equals("DivZero")) {
			TextArea.setText("");
		}
		
		if (e.getSource() == zeroB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "0");
			decimalCheck(0);
			
		} else if (e.getSource() == oneB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "1");
			decimalCheck(1);
			
		} else if (e.getSource() == twoB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "2");
			decimalCheck(2);
			
		} else if (e.getSource() == threeB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "3");
			decimalCheck(3);
			
		} else if (e.getSource() == fourB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "4");
			decimalCheck(4);
			
		} else if (e.getSource() == fiveB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "5");
			decimalCheck(5);
			
		} else if (e.getSource() == sixB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "6");
			decimalCheck(6);
			
		} else if (e.getSource() == sevenB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "7");
			decimalCheck(7);
			
		} else if (e.getSource() == eightB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "8");
			decimalCheck(8);
			
		} else if (e.getSource() == nineB) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "9");
			decimalCheck(9);
			
		} else if (e.getSource() == equalsB) {
			calculate();
			num = result;
			firstCalculation = true;
			decimalCheck = false;
			
		} else if (e.getSource() == addB) {
			TextArea.setText(""); // Clear the text field
			operator = '+';
			storeNum();
			
		} else if (e.getSource() == subtractB) {
			TextArea.setText("");
			operator = '-';
			storeNum();
			
		} else if (e.getSource() == multiB) {
			TextArea.setText("");
			operator = '*';
			storeNum();
			
		} else if (e.getSource() == divisionB) {
			TextArea.setText("");
			operator = '/';
			storeNum();
			
		} else if (e.getSource() == clearB) {
			TextArea.setText("");
			num = 0;
			result = 0;
			firstCalculation = true;
			decimalCheck = false;
			
		} else if (e.getSource() == decimalB) {
			int temp = (int) num;
			System.out.println(temp);
			String stringTemp = String.valueOf(temp) + ".";
			System.out.println(stringTemp);
			num = Double.parseDouble(stringTemp);
			System.out.println(num);
			TextArea.setText(stringTemp);
			decimalCheck = true;
			
		} else if (e.getSource() == negativeB) {
			num = num * -1;
			TextArea.setText(String.valueOf(num));
		}
		
		// Setting the lastButton variable
		lastButton = e.getSource();
	}
		
		
	
	public void calculate() {
		
		switch (operator) {
			case '+':
				result = result + num;
				break;
			case '-':
				result = result - num;
				break;
			case '*':
				result = result * num;
				break;
			case '/':
				if (num == 0) { // Check for division by zero. If so, display error message.
					TextArea.setText("DivZero");
					num = 0;
					result = 0;
					return;
				}
				result = result / num;
				break;
			default:
				break;
		}
		roundResult();
		TextArea.setText(String.valueOf(result));
		num = 0; // Reset num
	}

	/**
	 * Checks if the calculator is currently displaying the result of a previous calculation.
	 * If true, it clears the text area. Otherwise, it does nothing.
	 */
	public void clearDisplayedResult() {
		if (!TextArea.getText().isEmpty() && Double.parseDouble(TextArea.getText()) == result) {
			TextArea.setText("");
		}
	}
	
	public void storeNum() {
		if (firstCalculation) {
			System.out.println("result: " + result + ", num: " + num);
			result = num;
			num = 0;
			firstCalculation = false;
			System.out.println("result: " + result + ", num: " + num);
		} else {
			calculate();
		}
	}
	
	public void decimalCheck(int value) {
		if (decimalCheck) {
			int temp = (int) num;
			String stringTemp = String.valueOf(temp) + "." + value;
			num = Double.parseDouble(stringTemp);
			TextArea.setText(stringTemp);
			decimalCheck = false;
		} else {
			num = num * 10 + value;
		}
	}
	
	public void roundResult() {
		result = (double) Math.round(result * 100) / 100;
	}
	
	public static void main(String[] args) {

		Calculator calc = new Calculator();

	}

}