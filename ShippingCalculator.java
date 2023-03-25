// Scanner class imported from java.util to get user input
import java.util.Scanner;
public class ShippingCalculator {
    public static void main(    String[] args) {
        try {
            System.out.println("----------------------------------");
            // while loop to iterate through user's inputs
            while (true) {
            	// Create a Scanner object
                Scanner userInput = new Scanner(System.in);
                // Prompt user to enter amount of money
                System.out.print("Enter package weight OR [q]uit: ");
                double packageWeight = userInput.nextDouble();
				// Setting conditions for user's input
                if (packageWeight <= 0) {
                    System.out.println("      ***  Invalid input  ***");
                } else if (packageWeight <= 1) {
                    System.out.println("Cost of shipping: $3.50");
                } else if (packageWeight <= 3) {
                    System.out.println("Cost of shipping: $5.50");
                } else if (packageWeight <= 10) {
                    System.out.println("Cost of shipping: $8.50");
                } else if (packageWeight <= 20) {
                    System.out.println("Cost of shipping: $10.50");
                } else {
                    System.out.println("* The Package can not be shipped *");
                }
                System.out.println("----------------------------------");
            }
        }
        // Catching a specific error and setting it to end of program
        catch (Exception InputMismatch) {
            System.out.println("Good bye!");
        }
    }
}
/*
OUTPUT:
----------------------------------
Enter package weight OR [q]uit: -10
      ***  Invalid input  ***
----------------------------------
Enter package weight OR [q]uit: 0
      ***  Invalid input  ***
----------------------------------
Enter package weight OR [q]uit: 0.5
Cost of shipping: $3.50
----------------------------------
Enter package weight OR [q]uit: 1
Cost of shipping: $3.50
----------------------------------
Enter package weight OR [q]uit: 2
Cost of shipping: $5.50
----------------------------------
Enter package weight OR [q]uit: 7.25
Cost of shipping: $8.50
----------------------------------
Enter package weight OR [q]uit: 20
Cost of shipping: $10.50
----------------------------------
Enter package weight OR [q]uit: 21
* The Package can not be shipped *
----------------------------------
Enter package weight OR [q]uit: q
Good bye!
 */