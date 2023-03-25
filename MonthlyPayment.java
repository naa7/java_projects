public class MonthlyPayment {

    private static void horizontalLine() {
        int counter = 0;
        System.out.print("+");
        while (counter < 81) {
            System.out.print("-");
            counter++;
        }
        System.out.print("+");
        System.out.println();
    }

    private static void intRates() {
        double intRate = 0.07;
        for ( intRate = 0.07; intRate < 0.101; intRate = intRate + 0.005) {
            System.out.printf("%10.3f", intRate);
        }
        System.out.printf("%2s\n", "|");
    }

    private static void principalMonthlyPayment(int principal, int numYears, double intRate) {
        double monPayment = 0.0;
        double pow = 0.0;
        while (principal <= 1000000) {
            System.out.printf("| %2s%7d |", " ", principal);
            while (intRate < 0.101) {
                pow = Math.pow((1 + (intRate / 12)), numYears * 12);
                monPayment = ((principal * (intRate / 12) * pow) / (pow - 1));
                System.out.printf("%8.2f |",(monPayment));
                intRate = intRate + 0.005;
            }
            System.out.println();
            principal = principal + 100000;
            intRate = 0.070;
        }
    }

    public static void main(String[] args) {
        int principal = 100000;
        int numYears = 30;
        double intRate = 0.070;
        horizontalLine();
        System.out.printf("| [Enter Name here]%31s%27s%6s\n", "Monthly Payment", "Version 1", "|");
        horizontalLine();
        System.out.printf("| Principal%38s%34s\n|%10s", "Interest Rate", "|", " ");
        intRates();
        horizontalLine();
        principalMonthlyPayment(principal, numYears, intRate);
        horizontalLine();
    }
}

/*
Output:
+---------------------------------------------------------------------------------+
| [Enter Name here]                Monthly Payment                  Version 1     |
+---------------------------------------------------------------------------------+
| Principal                         Interest Rate                                 |
|               0.070     0.075     0.080     0.085     0.090     0.095     0.100 |
+---------------------------------------------------------------------------------+
|    100000 |  665.30 |  699.21 |  733.76 |  768.91 |  804.62 |  840.85 |  877.57 |
|    200000 | 1330.60 | 1398.43 | 1467.53 | 1537.83 | 1609.25 | 1681.71 | 1755.14 |
|    300000 | 1995.91 | 2097.64 | 2201.29 | 2306.74 | 2413.87 | 2522.56 | 2632.71 |
|    400000 | 2661.21 | 2796.86 | 2935.06 | 3075.65 | 3218.49 | 3363.42 | 3510.29 |
|    500000 | 3326.51 | 3496.07 | 3668.82 | 3844.57 | 4023.11 | 4204.27 | 4387.86 |
|    600000 | 3991.81 | 4195.29 | 4402.59 | 4613.48 | 4827.74 | 5045.13 | 5265.43 |
|    700000 | 4657.12 | 4894.50 | 5136.35 | 5382.39 | 5632.36 | 5885.98 | 6143.00 |
|    800000 | 5322.42 | 5593.72 | 5870.12 | 6151.31 | 6436.98 | 6726.83 | 7020.57 |
|    900000 | 5987.72 | 6292.93 | 6603.88 | 6920.22 | 7241.60 | 7567.69 | 7898.14 |
|   1000000 | 6653.02 | 6992.15 | 7337.65 | 7689.13 | 8046.23 | 8408.54 | 8775.72 |
+---------------------------------------------------------------------------------+

 */