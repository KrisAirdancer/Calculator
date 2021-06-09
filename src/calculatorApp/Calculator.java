package calculatorApp;

import java.awt.Color;
import java.awt.Dimension;
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
	ClearButton, DecimalButton;
	private double num1, num2, result;
	private char operator;
	private JTextField TextArea;
	
	public Calculator() {
				
		// Creating a window for the calculator
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setLayout(new GridLayout(2, 1));
		frame.setSize(new Dimension(250, 350));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tell the program to terminate when the "X" button is clicked
		frame.setResizable(false); // Prevent resizing of the window
		
		// Creating a panel to hold the calculator buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 4) );
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		
		// Crating a panel to hold the input/output display label
//		JPanel displayPanel = new JPanel();
//		displayPanel.setBackground(Color.LIGHT_GRAY);
//		displayPanel.setSize(240, 150);
//		
		// Creating a Text Field to display input and output
		TextArea = new JTextField();
		TextArea.setSize(200, 50);
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
		
		// Setting button colors - SET THESE LATER
//		ZeroButton.setBackground(Color.GRAY);
//		OneButton.setBackground(Color.GRAY);
//		TwoButton.setBackground(Color.GRAY);
//		ThreeButton.setBackground(Color.GRAY);
//		FourButton.setBackground(Color.GRAY);
//		FiveButton.setBackground(Color.GRAY);
//		SixButton.setBackground(Color.GRAY);
//		SevenButton.setBackground(Color.GRAY);
//		EightButton.setBackground(Color.GRAY);
//		NineButton.setBackground(Color.GRAY);
//		EqualsButton.setBackground(Color.DARK_GRAY);
//		AdditionButton.setBackground(Color.BLUE);
//		SubtractionButton.setBackground(Color.BLUE);
//		MultiplicationButton.setBackground(Color.BLUE);
//		DivisionButton.setBackground(Color.BLUE);
//		ClearButton.setBackground(Color.BLUE);
		
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
		
		
		// Adding buttons to the calculator panel
		buttonPanel.add(SevenButton);
		buttonPanel.add(EightButton);
		buttonPanel.add(NineButton);
		buttonPanel.add(AdditionButton);
		buttonPanel.add(FourButton);
		buttonPanel.add(FiveButton);
		buttonPanel.add(SixButton);
		buttonPanel.add(SubtractionButton);		
		buttonPanel.add(OneButton);
		buttonPanel.add(TwoButton);
		buttonPanel.add(ThreeButton);		
		buttonPanel.add(MultiplicationButton);		
		buttonPanel.add(ClearButton);
		buttonPanel.add(ZeroButton);		
		buttonPanel.add(EqualsButton);
		buttonPanel.add(DivisionButton);
		buttonPanel.add(DecimalButton);
		
		// Adding the panels to the window
//		frame.add(displayPanel);
		frame.add(TextArea);
		frame.add(buttonPanel);		
		
		// Making the panel visible
		buttonPanel.setVisible(true);
		// Making the window visible
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ZeroButton) {
			TextArea.setText(TextArea.getText() + "0");
			num1 = num1 * 10 + 0;
		} else if (e.getSource() == OneButton) {
			TextArea.setText(TextArea.getText() + "1");
			num1 = num1 * 10 + 1;
		} else if (e.getSource() == TwoButton) {
			TextArea.setText(TextArea.getText() + "2");
			num1 = num1 * 10 + 2;
		} else if (e.getSource() == ThreeButton) {
			TextArea.setText(TextArea.getText() + "3");
			num1 = num1 * 10 + 3;
		} else if (e.getSource() == FourButton) {
			TextArea.setText(TextArea.getText() + "4");
			num1 = num1 * 10 + 4;
		} else if (e.getSource() == FiveButton) {
			TextArea.setText(TextArea.getText() + "5");
			num1 = num1 * 10 + 5;
		} else if (e.getSource() == SixButton) {
			TextArea.setText(TextArea.getText() + "6");
			num1 = num1 * 10 + 6;
		} else if (e.getSource() == SevenButton) {
			TextArea.setText(TextArea.getText() + "7");
			num1 = num1 * 10 + 7;
		} else if (e.getSource() == EightButton) {
			TextArea.setText(TextArea.getText() + "8");
			num1 = num1 * 10 + 8;
		} else if (e.getSource() == NineButton) {
			TextArea.setText(TextArea.getText() + "9");
			num1 = num1 * 10 + 9;
		} else if (e.getSource() == EqualsButton) {
			calculate();
		} else if (e.getSource() == AdditionButton) {
			// TODO
		} else if (e.getSource() == SubtractionButton) {
			// TODO
		} else if (e.getSource() == MultiplicationButton) {
			// TODO
		} else if (e.getSource() == DivisionButton) {
			// TODO
		} else if (e.getSource() == ClearButton) {
			// TODO
		} else if (e.getSource() == DecimalButton) {
			// TODO
		}
	}
		
		
	
	public void calculate() {

		// TODO
		
	}

	public static void main(String[] args) {

		Calculator calc = new Calculator();

	}

}