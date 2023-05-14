import java.io.*;
import java.util.Scanner;

public class DataReaderCounter {

    public static void main(String[] args) throws IOException {
        DataReaderCounter obj = new DataReaderCounter();
        double[] array = new double[100];
        int count = obj.readData(array);
        obj.fileHeader("[Name]", "Data Reader & Counter", "Version 1");
        System.out.printf("| %16s%-5d%36s\n", "Value of count: ", count, "|");
        obj.line();
        double avg = obj.computeAvg(count, array);
        System.out.printf("| %18s%-5.1f%34s\n" ,"Value of average: ",  avg, "|");
        obj.line();
        obj.compareToAvg(count, avg, array);
        obj.line();
        obj.smallest(count, array);
        obj.line();
        obj.largest(count, array);
        obj.line();
    }

    void line() {
        int length = 59;
        for (int i = 0; i < length; i++) {
            if ((i == 0) || (i == length - 1))
                System.out.print('+');
            else
                System.out.print('-');
        }
        System.out.println();
    }

    void fileHeader(String name, String title, String version) {
        line();
        System.out.printf("| %-16s%18s%18s%2s\n", name, title, version, "|");
        line();
    }

    int readData(double[] array) throws IOException {
        File inputFile = new File("sample.txt");
        Scanner input = new Scanner(inputFile);
        int counter = 0;
        while (input.hasNext()) {
            array[counter] = input.nextDouble();
            counter++;
        }
        input.close();
        return counter;
    }

    double computeAvg(int n, double[] array) {
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum = sum + array[i];
        }
        return (sum/n);
    }

    void compareToAvg(int n, double avg, double[] array) {
        for (int i = 0; i < n; i++) {
            if (array[i] < avg)
                System.out.printf("| %-5.1f%15s%37s\n", array[i], "below average", "|");
            else if (array[i] == avg)
                System.out.printf("| %-5.1f%18s%34s\n", array[i], "equal to average", "|");
            else
                System.out.printf("| %-5.1f%15s%37s\n", array[i], "above average", "|");
        }
    }

    void smallest(int n, double[] array) {
        double min = array[0];
        int position = 0;
        for (int i = 0; i < n; i++) {
            if (min > array[i]) {
                min = array[i];
                position = i;
            }
        }
        System.out.printf("| %26s%-5.1f%26s\n", "Value of minimum element: ", min, "|");
        System.out.printf("| %29s%-3d%25s\n", "Position of minimum element: ", position, "|");
    }

    void largest(int n, double[] array) {
        double max = array[0];
        int position = 0;
        for (int i = 0; i < n; i++) {
            if (max < array[i]) {
                max = array[i];
                position = i;
            }
        }
        System.out.printf("| %26s%-5.1f%26s\n", "Value of largest element: ", max, "|");
        System.out.printf("| %29s%-3d%25s\n", "Position of largest element: ", position, "|");
    }
}

/*
Output:
+---------------------------------------------------------+
| [Name]          Data Reader & Counter         Version 1 |
+---------------------------------------------------------+
| Value of count: 9                                       |
+---------------------------------------------------------+
| Value of average: 27.8                                  |
+---------------------------------------------------------+
| 10.0   below average                                    |
| 9.0    below average                                    |
| 8.0    below average                                    |
| 7.0    below average                                    |
| 100.0  above average                                    |
| 33.0   above average                                    |
| 56.0   above average                                    |
| -1.0   below average                                    |
| 27.8   equal to average                                 |
+---------------------------------------------------------+
| Value of minimum element: -1.0                          |
| Position of minimum element: 7                          |
+---------------------------------------------------------+
| Value of largest element: 100.0                         |
| Position of largest element: 4                          |
+---------------------------------------------------------+
 */