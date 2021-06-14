package calculatorApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	
	public Calculator() {
				
		// Setting boolean flags
		firstCalculation = true;
		decimalCheck = false;
		
		// Creating a window for the calculator
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setLayout(new GridLayout(1, 0));
		frame.setSize(new Dimension(250, 350));
//		frame.setPreferredSize(new Dimension(250, 350));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tell the program to terminate when the "X" button is clicked
//		frame.setResizable(false); // Prevent resizing of the window
		
		// Creating GridBagConstraints for GridBagLayout
		GridBagConstraints gBC = new GridBagConstraints();
		
		// Creating a panel to hold the calculator buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setSize(new Dimension(250, 350));
		buttonPanel.setPreferredSize(new Dimension(250, 350));
		buttonPanel.setMinimumSize(new Dimension(250, 350));
		buttonPanel.setLayout(new GridBagLayout());
		
		// Creating a Text Field to display input and output
		TextArea = new JTextField();
		TextArea.setBackground(Color.LIGHT_GRAY);
		TextArea.setEditable(false);
		
		// Adding display label to display panel
//		displayPanel.add(textArea);
		
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
		
		// Setting button sizes
		Dimension buttonDim = new Dimension(20, 20);
		
//		ClearButton.setPreferredSize(buttonDim);
//		negativeButton.setPreferredSize(buttonDim);
		
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
		
		gBC.gridwidth = 1;
		gBC.gridheight = 1;
		gBC.fill = GridBagConstraints.BOTH;
		
		// Loop for row number
		for (int index = 0; index < 5; index++) {
			gBC.gridy = index;
			System.out.println("index: " + index);
			// Loop for column number
			for (int i = 0; i < 4; i++) {
				System.out.println("i: " + i);
				gBC.gridx = i;
				
				if (index == 0 && i == 0) {
					System.out.println("gBC.gridx: " + gBC.gridx + ", gBC.gridy: " + gBC.gridy);
					gBC.gridx = 0;
					gBC.gridy = 0;
					gBC.gridwidth = 1;
					gBC.gridheight = 1;
					// Resetting variables
					gBC.gridx = 0;
					gBC.gridy = 0;
					gBC.gridwidth = 1;
					gBC.gridheight = 1;
					
					buttonPanel.add(ClearButton, gBC);
				} else if (index == 0 && i == 1) {
					System.out.println("gBC.gridx: " + gBC.gridx + ", gBC.gridy: " + gBC.gridy);
					buttonPanel.add(negativeButton, gBC);
				} else if (index == 0 && i == 2) {
					System.out.println("gBC.gridx: " + gBC.gridx + ", gBC.gridy: " + gBC.gridy);
					buttonPanel.add(ClearButton, gBC);
				} else if (index == 0 && i == 3) {
					System.out.println("gBC.gridx: " + gBC.gridx + ", gBC.gridy: " + gBC.gridy);
					gBC.gridx = 2;
					gBC.gridwidth = 2;
					buttonPanel.add(TextArea, gBC);
					// Resetting variables
					gBC.gridwidth = 1;
					gBC.gridx = 3;
					System.out.println("gBC.gridx: " + gBC.gridx + ", gBC.gridy: " + gBC.gridy);
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
		
// ********************
		
//		//Row 0
//		gBC.gridx = 0;
//		gBC.gridy = 0;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		gBC.fill = GridBagConstraints.BOTH;
////		gBC.fill = GridBagConstraints.VERTICAL;
//		buttonPanel.add(ClearButton, gBC);
//		
//		gBC.gridx = 1;
//		gBC.gridy = 0;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(negativeButton, gBC);
//		
//		gBC.gridx = 2;
//		gBC.gridy = 0;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 2;
//		gBC.gridheight = 1;
//		gBC.fill = GridBagConstraints.HORIZONTAL;
//		buttonPanel.add(TextArea, gBC);
//		
//		// Row 1
//		gBC.gridx = 0;
//		gBC.gridy = 1;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
////		gBC.anchor = GridBagConstraints.NORTH;
//		buttonPanel.add(SevenButton, gBC);
//		
//		gBC.gridx = 1;
//		gBC.gridy = 1;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(EightButton, gBC);
//
//		gBC.gridx = 2;
//		gBC.gridy = 1;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(NineButton, gBC);
//		
//		gBC.gridx = 3;
//		gBC.gridy = 1;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(DivisionButton, gBC);
//		
//		// Row 2
//		gBC.gridx = 0;
//		gBC.gridy = 2;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
////		gBC.anchor = GridBagConstraints.NORTH;
//		buttonPanel.add(FourButton, gBC);
//		
//		gBC.gridx = 1;
//		gBC.gridy = 2;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(FiveButton, gBC);
//
//		gBC.gridx = 2;
//		gBC.gridy = 2;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(SixButton, gBC);
//		
//		gBC.gridx = 3;
//		gBC.gridy = 2;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(MultiplicationButton, gBC);
//		
//		// Row 3
//		gBC.gridx = 0;
//		gBC.gridy = 3;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
////		gBC.anchor = GridBagConstraints.NORTH;
//		buttonPanel.add(OneButton, gBC);
//		
//		gBC.gridx = 1;
//		gBC.gridy = 3;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(TwoButton, gBC);
//
//		gBC.gridx = 2;
//		gBC.gridy = 3;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(ThreeButton, gBC);
//		
//		gBC.gridx = 3;
//		gBC.gridy = 3;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(SubtractionButton, gBC);
//		
//		// Row 4
//		gBC.gridx = 0;
//		gBC.gridy = 4;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
////		gBC.anchor = GridBagConstraints.NORTH;
//		buttonPanel.add(DecimalButton, gBC);
//		
//		gBC.gridx = 1;
//		gBC.gridy = 4;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(ZeroButton, gBC);
//
//		gBC.gridx = 2;
//		gBC.gridy = 4;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(EqualsButton, gBC);
//		
//		gBC.gridx = 3;
//		gBC.gridy = 4;
////		gBC.weighty = 1;
////		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 1;
//		buttonPanel.add(AdditionButton, gBC);
		
// **********************		
		
		// Adding the panels to the window
//		frame.add(displayPanel);
//		frame.add(TextArea);
		
		// gBC for buttonPanel
//		gBC.gridx = 0;
//		gBC.gridy = 0;
//		gBC.weighty = 1;
//		gBC.weightx = 1;
//		gBC.gridwidth = 1;
//		gBC.gridheight = 2;
//		gBC.fill = GridBagConstraints.BOTH;
		
		frame.add(buttonPanel, gBC);		
		
		// Making the panel visible
		buttonPanel.setVisible(true);
		frame.pack();
		// Making the window visible
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// User input of numbers stored in num variable
		// When operator or equals button is pressed,
			// If operatorPending == true, calculate result and update result (result = result +-*/ num) <- switch statement
			// If operatorPending == false, the operator is stored in the operator variable and num is stored in the result variable, num is set to 0
					// operatorPending boolean is also updated to true
		// When next number is entered it is stored in num, which is now empty
		
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
					TextArea.setText("DivZero Error");
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