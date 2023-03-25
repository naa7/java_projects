import java.util.Scanner;

public class Total {
	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter amount of money: ");

		double total = userInput.nextDouble();
		int totalCents = (int)(total*100);
		int dollars = (int)total;
		int cents = totalCents%100;
		int quarters = cents/25;
		cents = cents%25;
		int dimes = cents/10;
		cents = cents%10;
		int nickels = cents/5;
		cents = cents%5;

		System.out.println(total + " is " + dollars + " dollars " + quarters + " quarters " + nickels + " nickels " + cents + " cents");

	}
}
