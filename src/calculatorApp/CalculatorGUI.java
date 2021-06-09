package calculatorApp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorGUI {

	private static JButton ZeroButton, OneButton, TwoButton, ThreeButton, FourButton, FiveButton, SixButton, SevenButton,
						EightButton, NineButton, EqualsButton, AdditionButton, SubtractionButton, MultiplicationButton, 
						DivisionButton, ClearButton;
	
	public CalculatorGUI() {
		
		// Creating a window for the calculator
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setLayout(new GridLayout(2, 1));
		frame.setSize(new Dimension(250, 350));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tell the program to terminate when the "X" button is clicked
		frame.setResizable(false); // Prevent resizing of the window
		
		// Creating a panel to hold the calculator buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 5) );
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		
		// Crating a panel to hold the input/output display label
<<<<<<< Updated upstream
		JPanel displayPanel = new JPanel();
		displayPanel.setBackground(Color.LIGHT_GRAY);
		
		// Creating a JLabel to display input and output
		JLabel displayLabel = new JLabel();
=======
//		JPanel displayPanel = new JPanel();
//		displayPanel.setBackground(Color.LIGHT_GRAY);
//		displayPanel.setSize(240, 150);
//		
		// Creating a Text Field to display input and output
		textArea = new JTextField();
		textArea.setSize(200, 50);
		textArea.setEditable(false);
>>>>>>> Stashed changes
		
		// Adding display label to display panel
		displayPanel.add(displayLabel);
		
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
		DivisionButton = new JButton("÷");
		ClearButton = new JButton("C");
		
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

		
		// Adding the panels to the window
		frame.add(displayPanel);
		frame.add(buttonPanel);		
		
		// Making the panel visible
		buttonPanel.setVisible(true);
		// Making the window visible
		frame.setVisible(true);
	}
	
<<<<<<< Updated upstream
=======
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("It Worked!");
		
		if (e.getSource() == ZeroButton) {
			textArea.setText("1");
			Calculator.num1 = num1 * 10 + 1;
			
		} else if (e.getSource() == OneButton) {
			
		} else if (e.getSource() == TwoButton) {
			
		} else if (e.getSource() == ThreeButton) {
			
		} else {
			System.out.println("eeeeeeeekkkkkkkkk!");
		}
	}
		
>>>>>>> Stashed changes
	public static void main(String[] args) {
		
		

	}

}
