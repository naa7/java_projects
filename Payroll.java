import java.util.Scanner;
public class Payroll {
    public static void main(String[] args) {

        int counter = 0;
        double total = 0.0;
        double totalSalaries = 0.0;
        double tax = 0.0;
        double averageSalary = 0.0;
        double averageTax = 0.0;
        double totalTax = 0.0;
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Enter id, 0 or less to stop: ");
            int id = userInput.nextInt();
            if (id <= 0 ) {
                System.out.println("----------------------------------------------------------");
                break;
            }
            System.out.print("Enter [hours] and [rate]: ");
            double hours = userInput.nextDouble();
            double rate = userInput.nextDouble();
            double salary = hours * rate;
            if (salary < 300.0) {
                tax = salary * 0.03;
            } else if (salary <= 350.0) {
                tax = salary * 0.04;
            } else {
                tax = salary * 0.05;
            }
            total = salary + tax;
            totalSalaries = totalSalaries + salary;
            totalTax = totalTax + tax;
            System.out.println("----------------------------------------------------------");
            System.out.printf("%5s%10s%10s%10s%10s%10s", "id", "hours", "rate", "salary", "tax", "total");
            System.out.println();
            System.out.printf("%5s%10.2f%10.2f%10.2f%10.2f%10.2f", id, hours, rate, salary, tax, total);;
            System.out.println("\n----------------------------------------------------------");
            counter++;
        }
        if (counter > 0) {
            System.out.println("Number of employees: " + counter);
            System.out.printf("Total salary is %3.2f", totalSalaries);
            averageSalary = totalSalaries / counter;
            averageTax = totalTax / counter;
            System.out.printf("\nAverage salary is %3.2f", averageSalary);
            System.out.printf("\nTotal tax is %3.2f", totalTax);
            System.out.printf("\nAverage tax is %3.2f", averageTax);
            System.out.println();
        }
    }
}

/*
Sample Output:
Enter id, 0 or less to stop: 123
Enter [hours] and [rate]: 18.75 22.5
----------------------------------------------------------
   id     hours      rate    salary       tax     total
  123     18.75     22.50    421.88     21.09    442.97
----------------------------------------------------------
Enter id, 0 or less to stop: 987
Enter [hours] and [rate]: 20.50 13.25
----------------------------------------------------------
   id     hours      rate    salary       tax     total
  987     20.50     13.25    271.63      8.15    279.77
----------------------------------------------------------
Enter id, 0 or less to stop: 456
Enter [hours] and [rate]: 12 8.75
----------------------------------------------------------
   id     hours      rate    salary       tax     total
  456     12.00      8.75    105.00      3.15    108.15
----------------------------------------------------------
Enter id, 0 or less to stop: 0
----------------------------------------------------------
Number of employees: 3
Total salary is 798.50
Average salary is 266.17
Total tax is 32.39
Average tax is 10.80
*/

/*
Output:
Enter id, 0 or less to stop: 187
Enter [hours] and [rate]: 12.5 15.8
----------------------------------------------------------
   id     hours      rate    salary       tax     total
  187     12.50     15.80    197.50      5.93    203.43
----------------------------------------------------------
Enter id, 0 or less to stop: 972
Enter [hours] and [rate]: 15.25 21.2
----------------------------------------------------------
   id     hours      rate    salary       tax     total
  972     15.25     21.20    323.30     12.93    336.23
----------------------------------------------------------
Enter id, 0 or less to stop: 201
Enter [hours] and [rate]: 18.9 20.25
----------------------------------------------------------
   id     hours      rate    salary       tax     total
  201     18.90     20.25    382.72     19.14    401.86
----------------------------------------------------------
Enter id, 0 or less to stop: 0
----------------------------------------------------------
Number of employees: 3
Total salary is 903.52
Average salary is 301.17
Total tax is 37.99
Average tax is 12.66
 */