
// Method1, user enters amount and adding `.` before the value of cents. Ex., 3475.40 where 40 is the value of cents

// Scanner class imported from java.util to get user input
import java.util.Scanner;

public class Method1 {
    public static void main(String[] args) {
    
    	// while loop to iterate through user's inputs
        while (true) {
        
       		// Create a Scanner object
            Scanner userInput = new Scanner(System.in);
            
            // Prompt user to enter amount of money
            System.out.print("Enter amount or [0] to exit: ");
            double total = userInput.nextDouble();
            
            // Condition to stop the while loop if user inputs a value of 0
            if (total != 0.0) {
            
            	// Copmuting the value of thousands, hundreds, tens, dollars, and cents
                int totalCents = (int)(total * 100);
                int remainingTotal = (int) total;
                int cents = totalCents%100;
                int thousand = remainingTotal / 1000;
                remainingTotal = remainingTotal % 1000;
                int hundred = remainingTotal / 100;
                remainingTotal = remainingTotal % 100;
                int tens = remainingTotal / 10;
                remainingTotal = remainingTotal % 10;
                int dollars = remainingTotal / 1;
                
                // Condition to add a zero before the value of cents if the value is less than 10 cents
                if (thousand == 0 && hundred == 0 && tens == 0 && dollars == 0 && cents >= 10) {
	                System.out.println("0" + totalCents + " is " + thousand + " thousand " + hundred + " hundred " + tens + " tens " + dollars + " dollars" + " and " + cents + " cents");
                }
                else if (thousand == 0 && hundred == 0 && tens == 0 && dollars == 0 && cents < 10) {
	                System.out.println("00" + totalCents + " is " + thousand + " thousand " + hundred + " hundred " + tens + " tens " + dollars + " dollars" + " and " + cents + " cents");
                }
                else {

                	System.out.println(totalCents + " is " + thousand + " thousand " + hundred + " hundred " + tens + " tens " + dollars + " dollars" + " and " + cents + " cents");
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

Enter amount or [0] to exit: 7325.67
732567 is 7 thousand 3 hundred 2 tens 5 dollars and 67 cents
Enter amount or [0] to exit: 123.54
12354 is 0 thousand 1 hundred 2 tens 3 dollars and 54 cents
Enter amount or [0] to exit: 100.00
10000 is 0 thousand 1 hundred 0 tens 0 dollars and 0 cents
Enter amount or [0] to exit: 12.54
1254 is 0 thousand 0 hundred 1 tens 2 dollars and 54 cents
Enter amount or [0] to exit: 0.54
054 is 0 thousand 0 hundred 0 tens 0 dollars and 54 cents
Enter amount or [0] to exit: 99999.99
9999999 is 99 thousand 9 hundred 9 tens 9 dollars and 99 cents
Enter amount or [0] to exit: 0

*/