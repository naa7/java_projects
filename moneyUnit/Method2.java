// Method2, user enters amount and without adding `.` before the cents. Ex., 347540 where 40 is the value of cents

// Scanner class from java.util to get user input
import java.util.Scanner;

public class Method2 {
	public static void main(String[] args) {
		
		// while loop to iterate through user's inputs
		while (true) {
			
			// Create a Scanner object
			Scanner userInput = new Scanner(System.in);
			
			// Prompt user to enter amount of money
			System.out.print("Enter amount or [0] to exit: ");
			int total = userInput.nextInt();
			
			// Condition to stop the while loop if user inputs a value of 0
			if (total != 0) {
			
				// computing the value of thousands, hundreds, tens, dollars, and cents
				int cents = total % 100;
				int remainingTotal = total / 100;
				int thousands = remainingTotal / 1000;
				remainingTotal = remainingTotal % 1000;
				int hundreds = remainingTotal / 100;
				remainingTotal = remainingTotal % 100;
				int tens = remainingTotal / 10;
				remainingTotal = remainingTotal % 10;
				int dollars = remainingTotal;
				
				// condition to add a zero before the value of cents if it is less than 10 cents
				if ((thousands == 0) && (hundreds == 0) && (tens == 0) && (dollars == 0) && (cents >= 10)) {
					System.out.println("0" + total + " is " + thousands + " thousand " + hundreds + " hundred " + tens + " tens " + dollars + " dollars" + " and " + cents + " cents");
				}
				else {
					System.out.println(total + " is " + thousands + " thousand " + hundreds + " hundred " + tens + " tens " + dollars + " dollars" + " and " + cents + " cents");
				}
			}
			else {
				// Printing a statement before breaking the loop and ending the program
				System.out.println("Bye...");
				break;
			}
		}
	}
}

/*
Output:

Enter amount or [0] to exit: 732567
732567 is 7 thousand 3 hundred 2 tens 5 dollars and 67 cents
Enter amount or [0] to exit: 12354
12354 is 0 thousand 1 hundred 2 tens 3 dollars and 54 cents
Enter amount or [0] to exit: 10000
10000 is 0 thousand 1 hundred 0 tens 0 dollars and 0 cents
Enter amount or [0] to exit: 1254
1254 is 0 thousand 0 hundred 1 tens 2 dollars and 54 cents
Enter amount or [0] to exit: 054
54 is 0 thousand 0 hundred 0 tens 0 dollars and 54 cents
Enter amount or [0] to exit: 999999
999999 is 9 thousand 9 hundred 9 tens 9 dollars and 99 cents
Enter amount or [0] to exit: 9999999
9999999 is 99 thousand 9 hundred 9 tens 9 dollars and 99 cents
Enter amount or [0] to exit: 0

*/
