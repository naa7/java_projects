import java.util.Scanner;

public class dateValidator {
    
    private static boolean generalChecker(int month, int day, int year) {
        return ((month >= 1 && month <= 12) && (day >= 1 && day <= 31) && (year >= 1));
    }

    private static boolean monthDayChecker(int month, int day) {
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
            System.out.println("Month " + month + " cannot have " + day + " days");
            return false;
        }
        if (month == 2 && day > 29) {
            System.out.println("Month " + month + " cannot have " + day + " days");
            return false;
        }
        return true;
    }

    private static boolean leapYearChecker(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    public static void main(String[] args) {
        try {
            Scanner userInput = new Scanner(System.in);
            while (true) {
                System.out.print("Enter [Month] [Day] [Year] separated by space or [q]uit: ");
                int month = userInput.nextInt();
                int day = userInput.nextInt();
                int year = userInput.nextInt();
                if (generalChecker(month, day, year)) {
                    if (!(monthDayChecker(month, day))) {
                        break;
                    } else {
                        if (day == 29 && !(leapYearChecker(year))) {
                            System.out.println(year + " is not a leap year, Feb can have only 28 days");
                            break;
                        }
                    }
                    System.out.println(month + " " + day + " " + year + " is a valid date");
                } else {
                    if (!(month >= 1 && month <= 12)) {
                        System.out.println("Error! Month can ONLY be between 1-12");
                    } else if (!(day >= 1 && day <= 31)) {
                        System.out.println("Error! Day can ONLY be between 1-31");
                    } else {
                        System.out.println("Error! Year cannot be less than 1");
                    }
                    break;
                }
            }
        } catch (Exception InputMismatch) {
            System.out.println("Good Bye!");
        }
    }
}

/*
OUTPUT: 
Enter [Month] [Day] [Year] separated by space: 6 30 2017
6 30 2017 is a valid date
Enter [Month] [Day] [Year] separated by space: 6 31 2017
Month 6 cannot have 31 days
Enter [Month] [Day] [Year] separated by space: -3 12 2019
Error! Month can ONLY be between 1-12
Enter [Month] [Day] [Year] separated by space: 2 29 2000
2 29 2000 is a valid date
Enter [Month] [Day] [Year] separated by space: 2 30 2000
Month 2 cannot have 30 days
Enter [Month] [Day] [Year] separated by space: 2 -12 2019
** Error! Invalid entry **
Enter [Month] [Day] [Year] separated by space: 9 31 1998
Month 9 cannot have 31 days
Enter [Month] [Day] [Year] separated by space: 2 29 2001
2001 is not a leap year, Feb can have only 28 days
Enter [Month] [Day] [Year] separated by space: 6 32 2017
Error! Day can ONLY be between 1-31
Enter [Month] [Day] [Year] separated by space: 11 32 2017
Error! Day can ONLY be between 1-31
Enter [Month] [Day] [Year] separated by space: 2 28 2001
2 28 2001 is a valid date
Enter [Month] [Day] [Year] separated by space: 2 28 1900
2 28 1900 is a valid date
Enter [Month] [Day] [Year] separated by space: 2 29 1900
1900 is not a leap year, Feb can have only 28 days
*/
