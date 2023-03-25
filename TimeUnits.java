import java.util.Scanner;

public class TimeUnits {

	public static void main(String[] args) {

		long second = 0;
                long remainder = 0;
                long minute = 0;
                long hour = 0;
                long day = 0;
                long month = 0;
                long year = 0;
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter value of seconds or [0] to quit: ");
		while ((second = userInput.nextLong())!= 0) {
			if (second == 0)
				break;
			year = second/(12*30*24*60*60);
			remainder = second%(12*30*24*60*60);
			month = remainder/(30*24*60*60);
			remainder = remainder%(30*24*60*60);
			day = remainder/(24*60*60);
			remainder = remainder%(24*60*60);
			hour = remainder/(60*60);
			remainder = remainder%(60*60);
			minute = remainder/60;
			second = remainder%60;
			remainder = 1;

			if (minute == 0 && hour == 0 && day == 0 && month == 0 && year == 0)
        	                System.out.printf("%s second\n", second);
			else if (hour == 0 && day == 0 && month == 0 && year == 0)
				System.out.printf("%s minute%5s second\n", minute, second);
			else if (day == 0 && month == 0 && year == 0)
				System.out.printf("%s hour%5s minute%5s second\n", hour, minute, second);
			else if (month == 0 && year == 0)
				System.out.printf("%s day%5s hour%5s minute%5s second\n", day, hour,
					minute, second);
			else if (year == 0)
				System.out.printf("%s month%5s day%5s hour%5s minute%5s second\n",
					month, day, hour, minute, second);
			else
				System.out.printf("%s year%5s month%5s day%5s hour%5s minute%5s second\n",
					year, month, day, hour, minute, second);
			System.out.print("Enter value of seconds or [0] to quit: ");
		}
	}
}
