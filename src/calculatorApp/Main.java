package calculatorApp;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		String testInputToDivisionLevel = "(10/(4/2))"; 
		
		evaluateMathString(testInputToDivisionLevel); // Should return 5

	}
	
	// Driver to ensure ease of use by user and correct inputs into the actual method.
	public static int evaluateMathString(String input) {
		return evaluateMathString(input, 0, input.length() - 1);
	}
	
	public static int evaluateMathString(String input, int start, int end) {
		
		// Creating the stack
		Stack<Character> stack = new Stack<Character>();
		
		// Variable to hold the final result of the input equation - Negative one to help indicate that we had an issue somewhere
		int result = -1;
		
		// Creating temporary start and end variables to be used for recursive calls
		int tempStart = start;
		int tempEnd = end;
		
		// Parentheses block - evaluates the parentheses in the input String
		for (int index = start; index <= end; index++) {
			stack.push(input.charAt(index)); // Pushing elements to the stack
			
			if (input.charAt(index) == '(') {
				tempStart = index + 1; // Set the index to the first element INSIDE the parentheses
			}
			
			if (input.charAt(index) == ')') {
				tempEnd = index - 1; // Set the index to the last element INSIDE the parentheses
				
				for (int subIndex = index; subIndex >= tempStart; subIndex--) { // Pull all of the substring and its surrounding parentheses off of the stack - it is going to be replaced
					stack.pop();
				}
//				index++; // Increment the index up one so that when the value of the substring is pushed to the stack we don't override anything - DO I NEED THIS??
						// We don't want the above line (or an index-- statement) because we need to keep the index where it is or we will end up in a forever loop when we hit the same ')' over and over again, or skip stuff because we incremented forward
				stack.push((char) evaluateMathString(input, tempStart, tempEnd)); // Casting the final calculated value of the sub-string to a char then pushing it to the stack 
			}
		}
		
		// Division block - evaluates the division operators in the input String
		for (int index = start; index <= end; index++) {
			stack.push(input.charAt(index)); // Pushing elements to the stack
			
			if (input.charAt(index) == '/') { // Extract denominator and numerator, perform division operation, and push result to the stack
				for (int subIndex = index; subIndex <= end; subIndex++) { // Push denominator to the stack
					stack.push(input.charAt(subIndex)); // Push the next set of chars to the stack
//					index++; // Increment the index for the outer for loop to keep it on track for when we need to insert a new value in place of the sub equation - we only want this to run to the char right BEFORE the next operator after the '/' that triggered this block - maybe not, b/c we are working with the stack, so the outer for loop will just run over the next number...I don't think it would work that way.
					if (input.charAt(subIndex) == '+' || input.charAt(subIndex) == '/'
							|| input.charAt(subIndex) == '-' || input.charAt(subIndex) == 'x'
							|| input.charAt(subIndex) == '(' || input.charAt(subIndex) == ')') { // If an operator is found, stop the loop - we only want numbers here
						break;
					}
				}
				// PULL FROM STACK AND ADD TO VARIABLE TO SEND TO STRING TO INT METHOD
			}
		}
		
		return 100; // Ultimately this method needs to return the calculated value
	}

}

/*
 * ***** TITLE *****
 *  ADDITIONAL NOTES:
 *  - Once most of the calculation code (not GUI code) is done, find a way to get the calculator to accept doubles instead of just integers
 *  - Once the calculation code is done, make my own implementation of the stack class and modify the code to use that instead of the one built into Java
 *  	- Do this simply as practice
 *  - It might make more sense to push the ASCII values of the chars pulled from the String to the stack
 *  	- Leave it pushing Characters for now, but consider changing it around later
 *  
 *  RESTATEMENT OF PROBLEM:
 *  
 *  SOLUTION IDEA:
 *  
 *  FULL SOLUTION DESCRIPTION:
 *  - Initialize stack object
 *  
 *  - Evaluate PARENTHESES BLOCK - indexed for loop
 *  	- Push chars to stack until ")" is found - push this to stack as well so that the for loop gets the right index values
 *  		- Store index location of ")" in endIndex
 *  		- When ")" is found, begin pulling chars from the stack until "(" is reached, pull the "(", then move to next step
 *  			- Store index location of "(" in openIndex
 *  		- Recursive call to evaluateMathString(input, startIndex, endIndex) method with the original input String (input), the index of the last "(" pulled from the stack (startIndex), and the last ")" pulled from the stack (endIndex)
 *  		- When recursive call completes, push the returned value to the stack at the index location of the last "(" 
 *  
 *  - Evaluate DIVISION BLOCK - indexed for loop
 *  	- Push chars to stack until '/' is found - push the '/' to the stack to ensure that we get the right index value, and for consistency's sake
 *  		- When '/' is found, drop into another loop to push the chars after the '/' onto the stack until the current char is an operator or parentheses (will have to call the evaluate char method for this) - DO NOT push the thing that is found to the stack, we will be using a shared stack here, so we need to keep it clean
 *  			- When something other than an integer is found, begin pulling chars off the stack and concatenating them to a new String
 *  			- When the '/' is hit again, this time during the pull cycle, pull it, then start concatenating the chars that come off the stack after it to a new String until we hit something other than an integer (we should have two strings when this is finished, one with the numerator and one with the denominator)
 *  				NOTE: When doing this, conduct the check BEFORE pulling the char from the stack. This way whatever was on the shared stack, stays there 
 *  			- Once the two strings are created, send each one to the method that converts a string to an integer
 *  				- When the values are returned from this method, save each one to num1 and num2 variables
 *  			- Use the new num1 and num2 variables to perform the calculation, num1 / num2
 *  			- Push the result of the calculation in the last step to the stack
 *  		- Continue looping through the input string
 *  			- When the end of the string is reached, all division operations should have been completed, so the program should just exit the method with no other work to do
 *  
 *  - ***GONG TO ATTEMPT TO BUILD THE ABOVE PSEUDO-CODE TO SEE IF IT WORKS WITH JUST A STRING OF PARENTHESES AND DIVISION OPERATORS
 *  
 *  DEFINITIONS OF VARIABLES & PARAMETERERS:
 *  
 *  PSEUDO-CODE SOLUTION:
 *  
 */