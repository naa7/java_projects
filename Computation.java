// Scanner class is a java.util package used to get user input
import java.util.Scanner;
public class Computation {
    public static void main(String[] args) {

        // Declare a constant variable
        final double PI = 3.14159;

        // Create a Scanner object
        Scanner userInput = new Scanner(System.in);

        // Prompt user to enter radius of the sphere
        System.out.print("Enter the radius of the sphere: ");

        double radius = userInput.nextDouble();
        // System.out.println("The radius of the sphere = " + radius);

        // Compute area of the sphere
        double area = 4*PI*(radius*radius);
        // Display result
        System.out.println("The area of the sphere = " + area);

        // Compute volume of the sphere
        double volume = (4.0/3.0)*PI*(radius*radius*radius);
        //Display result
        System.out.println("The volume of the sphere = " + volume);
    }
}

// Output:
/*
Code output with radius = 1.0

Enter the radius of the sphere: 1.0
The area of the sphere = 12.56636
The volume of the sphere = 4.188786666666666
*/

/*
Code output with radius = 12.75

Enter the radius of the sphere: 12.75
The area of the sphere = 2042.8188974999998
The volume of the sphere = 8681.980314375
*/