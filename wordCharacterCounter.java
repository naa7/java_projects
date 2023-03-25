import java.io.*;
import java.util.Scanner;

public class wordCharacterCounter {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter a message: ");
		//String msg = "CISC. 1115 Monday, Wednesday from 12:25pm to 2:25pm.";
		String msg = userInput.nextLine();
		int numDigit = 0;
		int numUpper = 0;
		int numLower = 0;
		int numWord = 0;
		int numOther = 0;
		int numLetter = 0;
		for (int i = 0; i < msg.length(); i++) {
			char c = msg.charAt(i);

			if (Character.isLowerCase(c)) {
				numLower++;
				numLetter++;
			}
			else if (Character.isUpperCase(c)) {
				numUpper++;
				numLetter++;
			}
			else if (Character.isDigit(c))
				numDigit++;
			else
				numOther++;

			if ( (c == ' ' && (Character.isLetter(msg.charAt(i-1)) ||
					(c == ' ' && (msg.charAt(i-1) == '.' ||
					msg.charAt(i-1) == '?' ||
					msg.charAt(i-1) == 	'!')))))
				numWord++;
		}

		System.out.printf("Word & Character Count:\n%d words\n%d letters --> %d uppercase\n%9s --> %d lowercase\n%d digits\n%d other characters\n",
		numWord, numLetter, numUpper, " ", numLower, numDigit, numOther);

	}

}