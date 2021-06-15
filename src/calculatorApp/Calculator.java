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

	private JButton ZeroButton, OneButton, TwoButton, ThreeButton, FourButton, FiveButton, SixButton, SevenButton,
	EightButton, NineButton, EqualsButton, AdditionButton, SubtractionButton, MultiplicationButton, DivisionButton,
	ClearButton, DecimalButton, negativeButton;
	private double num, result;
	private char operator;
	private JTextField TextArea;
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
		ZeroButton = new JButton("0");
		OneButton = new JButton("1");
		TwoButton = new JButton("2");
		ThreeButton = new JButton("3");
		FourButton = new JButton("4");
		FiveButton = new JButton("5");
		SixButton = new JButton("6");
		SevenButton = new JButton("7");
		EightButton = new JButton("8");
		NineButton = new JButton("9");
		EqualsButton = new JButton("=");
		AdditionButton = new JButton("+");
		SubtractionButton = new JButton("-");
		MultiplicationButton = new JButton("x");
		DivisionButton = new JButton("/");
		ClearButton = new JButton("C");
		DecimalButton = new JButton(".");
		negativeButton = new JButton("+/-");
		
		// Setting buttons' font size
		ZeroButton.setFont(text);
		OneButton.setFont(text);
		TwoButton.setFont(text);
		ThreeButton.setFont(text);
		FourButton.setFont(text);
		FiveButton.setFont(text);
		SixButton.setFont(text);
		SevenButton.setFont(text);
		EightButton.setFont(text);
		NineButton.setFont(text);
		EqualsButton.setFont(text);
		AdditionButton.setFont(text);
		SubtractionButton.setFont(text);
		MultiplicationButton.setFont(text);
		DivisionButton.setFont(text);
		ClearButton.setFont(text);
		DecimalButton.setFont(text);
		negativeButton.setFont(text);
		
		// Adding ActionListeners to buttons
		ZeroButton.addActionListener(this);
		OneButton.addActionListener(this);
		TwoButton.addActionListener(this);
		ThreeButton.addActionListener(this);
		FourButton.addActionListener(this);
		FiveButton.addActionListener(this);
		SixButton.addActionListener(this);
		SevenButton.addActionListener(this);
		EightButton.addActionListener(this);
		NineButton.addActionListener(this);
		EqualsButton.addActionListener(this);
		AdditionButton.addActionListener(this);
		SubtractionButton.addActionListener(this);
		MultiplicationButton.addActionListener(this);
		DivisionButton.addActionListener(this);
		ClearButton.addActionListener(this);
		DecimalButton.addActionListener(this);
		negativeButton.addActionListener(this);

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
					buttonPanel.add(ClearButton, gBC);
				} else if (index == 0 && i == 1) {
					buttonPanel.add(negativeButton, gBC);
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
					buttonPanel.add(SevenButton, gBC);
				} else if (index == 1 && i == 1) {
					buttonPanel.add(EightButton, gBC);
				} else if (index == 1 && i == 2) {
					buttonPanel.add(NineButton, gBC);
				} else if (index == 1 && i == 3) {
					buttonPanel.add(DivisionButton, gBC);
				} else if (index == 2 && i == 0) {
					buttonPanel.add(FourButton, gBC);
				} else if (index == 2 && i == 1) {
					buttonPanel.add(FiveButton, gBC);
				} else if (index == 2 && i == 2) {
					buttonPanel.add(SixButton, gBC);
				} else if (index == 2 && i == 3) {
					buttonPanel.add(MultiplicationButton, gBC);
				} else if (index == 3 && i == 0) {
					buttonPanel.add(OneButton, gBC);
				} else if (index == 3 && i == 1) {
					buttonPanel.add(TwoButton, gBC);
				} else if (index == 3 && i == 2) {
					buttonPanel.add(ThreeButton, gBC);
				} else if (index == 3 && i == 3) {
					buttonPanel.add(SubtractionButton, gBC);
				} else if (index == 4 && i == 0) {
					buttonPanel.add(DecimalButton, gBC);
				} else if (index == 4 && i == 1) {
					buttonPanel.add(ZeroButton, gBC);
				} else if (index == 4 && i == 2) {
					buttonPanel.add(EqualsButton, gBC);
				} else if (index == 4 && i == 3) {
					buttonPanel.add(AdditionButton, gBC);
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
		
		if (TextArea.getText().equals("DivZero")) {
			TextArea.setText("");
		}
		
		if (e.getSource() == ZeroButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "0");
			decimalCheck(0);
			
		} else if (e.getSource() == OneButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "1");
			decimalCheck(1);
			
		} else if (e.getSource() == TwoButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "2");
			decimalCheck(2);
			
		} else if (e.getSource() == ThreeButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "3");
			decimalCheck(3);
			
		} else if (e.getSource() == FourButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "4");
			decimalCheck(4);
			
		} else if (e.getSource() == FiveButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "5");
			decimalCheck(5);
			
		} else if (e.getSource() == SixButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "6");
			decimalCheck(6);
			
		} else if (e.getSource() == SevenButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "7");
			decimalCheck(7);
			
		} else if (e.getSource() == EightButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "8");
			decimalCheck(8);
			
		} else if (e.getSource() == NineButton) {
			clearDisplayedResult();
			TextArea.setText(TextArea.getText() + "9");
			decimalCheck(9);
			
		} else if (e.getSource() == EqualsButton) {
			calculate();
			num = result;
			firstCalculation = true;
			decimalCheck = false;
			
		} else if (e.getSource() == AdditionButton) {
			TextArea.setText(""); // Clear the text field
			operator = '+';
			storeNum();
			
		} else if (e.getSource() == SubtractionButton) {
			TextArea.setText("");
			operator = '-';
			storeNum();
			
		} else if (e.getSource() == MultiplicationButton) {
			TextArea.setText("");
			operator = '*';
			storeNum();
			
		} else if (e.getSource() == DivisionButton) {
			TextArea.setText("");
			operator = '/';
			storeNum();
			
		} else if (e.getSource() == ClearButton) {
			TextArea.setText("");
			num = 0;
			result = 0;
			firstCalculation = true;
			decimalCheck = false;
			
		} else if (e.getSource() == DecimalButton) {
			int temp = (int) num;
			System.out.println(temp);
			String stringTemp = String.valueOf(temp) + ".";
			System.out.println(stringTemp);
			num = Double.parseDouble(stringTemp);
			System.out.println(num);
			TextArea.setText(stringTemp);
			decimalCheck = true;
		} else if (e.getSource() == negativeButton) {
			num = num * -1;
			TextArea.setText(String.valueOf(num));
		}
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