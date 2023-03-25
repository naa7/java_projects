import java.util.Scanner;

public class CharacterValidator {
    public static void main(String[] args) {
        char chr;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter SSN [DDD-DD-DDDX], [D]igit - [X](Digit | Letter)): ");
        String str = userInput.nextLine();
        System.out.println("---------------------------------------------------------------------");
        while (str.length() > 1) {
            if (str.length() < 11) {
                for (int j = str.length(); j < 11; j++)
                    str = str.concat(" ");
            }
            for (int i = 0; i < str.length(); i++) {
                chr = str.charAt(i);
                if (!Character.isDigit(chr)) {
                    if (chr == '-' && !(i == 3 || i == 6))
                        System.out.println("Invalid input: [" + chr + "] at position: [" + i + "]");
                    else if (Character.isUpperCase(chr) && i != 10)
                        System.out.println("Invalid input: [" + chr + "] at position: [" + i + "]");
                    if (chr == ' ')
                        System.out.println("Invalid input: [" + chr + "] at position: [" + i + "]");
                } else {
                    if (i == 3 || i == 6)
                        System.out.println("Invalid input: [" + chr + "] at position: [" + i + "]");
                }
                if (i >= 11 && !Character.isUpperCase(chr))
                    System.out.println("Invalid input: [" + chr + "] at position: [" + i + "]");
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.print("Enter SSN [DDD-DD-DDDX] - (D (digit), X (Digit | Letter): ");
            str = userInput.nextLine();
            System.out.println("---------------------------------------------------------------------");
        }
    }
}

/*
Output:
Enter SSN [DDD-DD-DDDX], [D]igit - [X](Digit | Letter)): ABC
---------------------------------------------------------------------
Invalid input: [A] at position: [0]
Invalid input: [B] at position: [1]
Invalid input: [C] at position: [2]
Invalid input: [ ] at position: [3]
Invalid input: [ ] at position: [4]
Invalid input: [ ] at position: [5]
Invalid input: [ ] at position: [6]
Invalid input: [ ] at position: [7]
Invalid input: [ ] at position: [8]
Invalid input: [ ] at position: [9]
Invalid input: [ ] at position: [10]
---------------------------------------------------------------------
Enter SSN [DDD-DD-DDDX] - (D (digit), X (Digit | Letter): 123-A8-1234
---------------------------------------------------------------------
Invalid input: [A] at position: [4]
---------------------------------------------------------------------
Enter SSN [DDD-DD-DDDX] - (D (digit), X (Digit | Letter): 12-345-6789 
---------------------------------------------------------------------
Invalid input: [-] at position: [2]
Invalid input: [3] at position: [3]
---------------------------------------------------------------------
Enter SSN [DDD-DD-DDDX] - (D (digit), X (Digit | Letter): 123-45-678A
---------------------------------------------------------------------
---------------------------------------------------------------------
Enter SSN [DDD-DD-DDDX] - (D (digit), X (Digit | Letter): 123-45-678AB
---------------------------------------------------------------------
Invalid input: [B] at position: [11]
---------------------------------------------------------------------
Enter SSN [DDD-DD-DDDX] - (D (digit), X (Digit | Letter): A
---------------------------------------------------------------------
*/
