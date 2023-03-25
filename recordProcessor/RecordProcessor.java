import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class RecordProcessor {

    public static void main(String[] args) throws IOException {
        File();
    }
    private static void File()throws IOException {

        int position = 0;
        int errorCounter = 0;
        int dCounter = 0;
        int fCounter = 0;
        File inputFile = new File("files/info.txt");
        Scanner input = new Scanner(inputFile);
        File outputFile1 = new File("files/strOutputD.txt");
        PrintWriter output1 = new PrintWriter(outputFile1);
        File outputFile2 = new File("files/strOutputF.txt");
        PrintWriter output2 = new PrintWriter(outputFile2);
        File outputFile3 = new File("files/badRecords.txt");
        PrintWriter output3 = new PrintWriter(outputFile3);
        File outputFile4 = new File("files/records.txt");
        PrintWriter output4 = new PrintWriter(outputFile4);
        drawLine();
        while (input.hasNext()) {
            position++;
            double salary;
            double salaryBonus;
            String firstName = input.next();
            String lastName = input.next();
            String salaryString = input.next();
            char statusCode = (input.next()).charAt(0);
            String location = input.next();
            int breakPoint = location.indexOf(',');
            String city = location.substring(0, breakPoint);
            String state = location.substring(breakPoint+1);
            String string1 = (firstName + " " + lastName + " " + statusCode + " " + salaryString +
                    " " + location);
            if (checkStatusCode(statusCode)) {
                boolean valid = checkSalary(firstName, lastName, salaryString, statusCode, location);
                if (valid) {
                    salary = Double.parseDouble(salaryString);
                    salaryBonus = bonus(salary, statusCode);
                    String string2 = (firstName + " " + lastName + " " + statusCode + " " + salary + " "
                            + salaryBonus + " " + city + " " + state);
                    if (statusCode == 'D') {
                        output1.println(string2);
                        dCounter++;
                    }
                    else {
                        output2.println(string2);
                        fCounter++;
                    }
                }
                else {
                    output3.println(string1);
                    errorCounter++;
                }
            } else {
                System.out.println("Error: [" + string1 + "] status code [" + statusCode + "] " +
                        "on line number [" + position + "]");
                output3.println(string1);
                errorCounter ++;
            }
        }
        drawLine();
        System.out.println("Total records processed: " + (dCounter + fCounter + errorCounter));
        System.out.println("D records processed: " + dCounter);
        System.out.println("F records processed: " + fCounter);
        System.out.println("Incorrect records processed: " + errorCounter);
        drawLine();
        output4.println("Total records processed: " + (dCounter + fCounter + errorCounter));
        output4.println("D records processed: " + dCounter);
        output4.println("F records processed: " + fCounter);
        output4.println("Incorrect records processed: " + errorCounter);
        input.close();
        output1.close();
        output2.close();
        output3.close();
        output4.close();
    }

    private static void drawLine() {
        int i = 0;
        while (i < 57) {
            System.out.print('-');
            i++;
        }
        System.out.println();
    }

    private static boolean checkStatusCode(char statusCode) {
        return (statusCode == 'D' || statusCode == 'F');
    }

    private static boolean checkSalary(String firstName, String lastName, String salaryString,
                                       char statusCode, String location) {
        boolean flag = true;
        int position;
        for (int i = 0; i < salaryString.length(); i++) {
            char chr = salaryString.charAt(i);
            position = salaryString.lastIndexOf(chr) - salaryString.length();
            if (!(Character.isDigit(chr))) {
                if (Character.isAlphabetic(chr)) {
                    System.out.println("Error: [" + firstName + " " + lastName + " " +
                            salaryString + " " + statusCode + " " + location +
                            "] char at position [" + salaryString.indexOf(chr) + "] in ["
                            + salaryString + "] is not a digit");
                    flag = false;
                } else if (chr == '.' && position != -3) {
                    System.out.println("Error: [" + firstName + " " + lastName + " " +
                            salaryString + " " + statusCode + " " + location +
                            "] period is in the wrong position");
                    flag = false;
                }
                break;
            }
        }
        if (salaryString.indexOf('.') == -1) {
            System.out.println("Error: [" + firstName + " " + lastName + " " +
                    salaryString + " " + statusCode + " " + location + "] period is missing");
            flag = false;
        }
        return flag;
    }

    private static double bonus(double salary, char statusCode) {
        double bonus;
        if (statusCode == 'D') {
            bonus = Math.round((salary * 0.125)*100);
        } else {
            bonus = Math.round((salary * 0.18)*100);
        }
        bonus = bonus / 100;
        return bonus;
    }
}