import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/* The class cannot be used to create objects (To access an abstract class,
it must be inherited from another class. */
/* Can only be used in an abstract class, and can only be used on methods. 
The method does not have a body, for example abstract void run();. 
The body is provided by the subclass (inherited from) */

// abstract class
abstract class ID_issuing_project {
    public String idNum, Class;
    public String fname, mname, lname;
    public String birthDate;
    public String hairColor, eyeColor;
    public String sex, height;
    public String issueYear, expirationYear;

    /* An abstract method belongs to an abstract class, and it does not have a body. 
    The body is provided by the subclass */
    public abstract void displayInfo();
}

// Subclass (inherit from ID)
class Person extends ID_issuing_project {

    public Person(String in, String cs, String fn, String mn, String ln, String yr, String hc, String ec, String sx, String ht, String iy, String ey) {
        idNum = in;
        Class = cs;
        fname = fn;
        mname = mn;
        lname = ln;
        birthDate = yr;
        hairColor = hc;
        eyeColor = ec;
        sex = sx;
        height = ht;
        issueYear = iy;
        expirationYear = ey;
    }
    public void displayInfo() {
        try {
            FileWriter file = new FileWriter("ID_info.txt");
            file.write("#####################################################\n");
            System.out.println("#####################################################");
            if (Class == "C" || Class == "C/M") {
                file.write("## DRIVER LICENSE:\n");
                System.out.println("## DRIVER LICENSE:");
            }
            else {
                file.write("## INFORMATION:\n");
                System.out.println("## INFORMATION:");
            }
            file.write("#####################################################\n");
            System.out.println("#####################################################");
            file.write("## ID: " + idNum + "   " + "Class: " + Class + '\n');
            System.out.println("## ID: " + idNum + "   " + "Class: " + Class);
            file.write("## Last name: " + lname + '\n');
            System.out.println("## Last name: " + lname);
            file.write("## First name: " + fname + ", " + mname + '\n');
            System.out.println("## First name: " + fname + ", " + mname);
            file.write("## DOB: " + birthDate + '\n');
            System.out.println("## DOB: " + birthDate);
            file.write("## Sex: " + sex + "        " + "Height: " + height + '\n');
            System.out.println("## Sex: " + sex + "        " + "Height: " + height);
            file.write("## Hair: " + hairColor + "   " + "Eyes: " + eyeColor + '\n');
            System.out.println("## Hair: " + hairColor + "   " + "Eyes: " + eyeColor);
            file.write("## Issued: " + issueYear + '\n');
            System.out.println("## Issued: " + issueYear);
            file.write("## Expires: " + expirationYear + '\n');
            System.out.println("## Expires: " + expirationYear);
            file.write("#####################################################\n");
            System.out.println("#####################################################");
            file.close();
            System.out.println("File written successfully");
        }
        catch (IOException e) {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
}

class Main extends Person {
    
     public Main(String in, String cs, String fn, String mn, String ln, String yr, String hc, String ec,
            String sx, String ht, String iy, String ey) {
        super(in, cs, fn, mn, ln, yr, hc, ec, sx, ht, iy, ey);
    }

    /*
     * A static method means that it can be accessed without creating an object of
     * the class, unlike public
     */
    public static void main(String[] args) {
        int idn =(int)(Math.random()*(999999999 - 100000000 + 1) + 100000000);
        String idnum = String.valueOf(idn);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String fname = scan.nextLine();
        
        System.out.println("Enter your middle name/initial: ");
        String mname = scan.nextLine();
        
        System.out.println("Enter your last name: ");
        String lname = scan.nextLine();
        
        System.out.println("Enter month of your birthdate (MM/DD): ");
        String bdatemd = scan.nextLine();
        
        System.out.println("Enter year of your birthdate (YYYY): ");
        String bdatey = scan.nextLine();
        
        String bdate = bdatemd + "/" + bdatey;
        
        System.out.println("Enter color of your hair: ");
        String hcolor = scan.nextLine();
        
        System.out.println("Enter color of your eyes: ");
        String ecolor = scan.nextLine();
        
        System.out.println("Enter your gender (M/F): ");
        String gender = scan.nextLine();
        
        System.out.println("Enter your height (example, 5'-08\"): ");
        String height = scan.nextLine();
        
        System.out.println("Enter today's date (MM/DD): ");
        String tdatemd = scan.nextLine();
        System.out.println("Enter year (YYYY): ");
        String tyear = scan.nextLine();

        String tdate = tdatemd + "/" + tyear;
        int eyear = Integer.valueOf(tyear) + 10;
        String edate = bdatemd + "/" + String.valueOf(eyear); 

        System.out.println("Do you want ID or Driver's license? (ID/DL): ");
        String idclass = scan.nextLine();

        if (idclass.equals("DL")) {
            System.out.println("Do you own a motorcycle? (Y/N): ");
            String answer = scan.nextLine();
            if (answer.equals("Y")) {
                idclass = "C/M";
            }
            else {
                idclass = "C";
            }
        }
        
        scan.close();
        // create an object of the Person class (which inherits attributes and methods from ID)
        Person id = new Person(idnum, idclass, fname, mname, lname, bdate, hcolor, ecolor, gender, height, tdate, edate); 
        id.displayInfo();
    }
}
