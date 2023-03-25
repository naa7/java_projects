// Scanner class imported from java.util to get user input
import java.util.Scanner;
public class InterestRate {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner userInput = new Scanner(System.in);
        // Prompt user to enter monthly deposit
        System.out.print("Enter a monthly amount to deposit: ");
        double monthlyDeposit = userInput.nextDouble();
        // prompt user to enter yearly interest rate
        System.out.print("Enter yearly interest rate: ");
        double yearlyInterestRate = userInput.nextDouble();
        System.out.println("Monthly deposit: " + monthlyDeposit + ", yearly interest rate: " + yearlyInterestRate);
        // Compute monthly interest rate
        double monthlyInterestRate = (yearlyInterestRate/100)/12;
        // Declare a variable monthlyValue and initialize it to 0
        double monthlyValue = 0.;
        // Declare a variable for the while loop to stop at a certain number
        int counter = 1;
        while (counter < 7) {
            // Compute the value of monthlyValue
            monthlyValue = (monthlyDeposit + monthlyValue) * (1 + monthlyInterestRate);
            System.out.println("Month " + counter + " value: " + Math.round(monthlyValue * 100.0) / 100.0);
            counter++;
        }

    }
}

/*
Output 1:
Enter a monthly amount to deposit: 100.0
Enter yearly interest rate: 5.0
Monthly deposit: 100.0, yearly interest rate: 5.0
Month 1 value: 100.42
Month 2 value: 201.25
Month 3 value: 302.51
Month 4 value: 404.18
Month 5 value: 506.28
Month 6 value: 608.81

Output 2:
Enter a monthly amount to deposit: 200.50
Enter yearly interest rate: 3.75
Monthly deposit: 200.5, yearly interest rate: 3.75
Month 1 value: 201.13
Month 2 value: 402.88
Month 3 value: 605.27
Month 4 value: 808.29
Month 5 value: 1011.94
Month 6 value: 1216.23
 */