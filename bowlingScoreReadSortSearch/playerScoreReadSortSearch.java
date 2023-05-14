import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class playerScoreReadSortSearch {
    public static void main(String[] args) throws IOException {
        playerScoreReadSortSearch obj = new playerScoreReadSortSearch();
        String[] names = new String[50];
        writeToFile("", false);
        double[] avgScore = new double[50];
        int size = readData(names, avgScore);
        obj.arrayIteration(names, avgScore, size);
        obj.parallelSort(names, avgScore, size);
        obj.arrayIteration(names, avgScore, size);
        obj.parallelSort(avgScore, names, size);
        obj.arrayIteration(names, avgScore, size);
        String[] keys = {"Sam", "Roberta"};
        for (String key : keys) {
            if (binarySearch(names, key, size) > 0) {
                System.out.println(key + " Found");
                writeToFile((key + " Found\n"), true);
            } else {
                System.out.println(key + " Not Found");
                writeToFile((key + " Not Found\n"), true);
            }
        }
        writeToFile("\n", true);
    }

    void arrayIteration(String[] arrStr, double[] arrDbl, int ndx) throws IOException {
        for (int i = 0; i < ndx; i++) {
            System.out.println(arrStr[i] + " " + arrDbl[i]);
            writeToFile((arrStr[i] + " " + arrDbl[i] + '\n'), true);
        }
        System.out.println();
        writeToFile("\n", true);
    }
    public static int readData(String[] names, double[] avgScore) throws IOException {
        File inputFile = new File("bowlingInput.txt");
        Scanner input = new Scanner(inputFile);
        int playerCount = 0;
        while (input.hasNext()) {
            names[playerCount] = input.next();
            int gamesCount = input.nextInt();
            double totalScores = 0;
            for (int i = 0; i < gamesCount; i++) {
                totalScores = totalScores + input.nextInt();
            }
            avgScore[playerCount] = Math.round((totalScores/gamesCount)*100.0)/100.0;
            playerCount++;
        }
        input.close();
        return playerCount;
    }

    void parallelSort(String[] arrStr, double[] arrDbl, int ndx) {
        for (int i = 0; i < ndx; i++) {
            for (int j = 0; j < ndx-i-1; j++) {
                if (arrStr[j].compareTo(arrStr[j+1]) > 0) {
                    String tempStr = arrStr[j];
                    arrStr[j] = arrStr[j+1];
                    arrStr[j+1] = tempStr;

                    double tempDbl = arrDbl[j];
                    arrDbl[j] = arrDbl[j+1];
                    arrDbl[j+1] = tempDbl;
                }
            }
        }
    }

    void parallelSort(double[] arrDbl, String[] arrStr, int ndx) {
        for (int i = 0; i < ndx; i++) {
            for (int j = 0; j < ndx-i-1; j++) {
                if (arrDbl[j] < arrDbl[j+1]) {

                    double tempDbl = arrDbl[j];
                    arrDbl[j] = arrDbl[j+1];
                    arrDbl[j+1] = tempDbl;

                    String tempStr = arrStr[j];
                    arrStr[j] = arrStr[j+1];
                    arrStr[j+1] = tempStr;
                }
            }
        }
    }

    public static int binarySearch(String[] list, String key, int ndx) {
        int low = 0;
        int high = ndx - 1;
        while (high >= low) {
            int mid = (low+high)/2;
            if (key.compareTo(list[mid]) < 0)
                high = mid - 1;
            else if (key.compareTo(list[mid]) == 0)
                return mid;
            else
                low = mid + 1;
        }
        return (-1 - low);
    }

    public static void writeToFile(String text, boolean appendStatus) throws IOException {
        FileWriter outputFile = new FileWriter("bowlingOutput.txt", appendStatus);
        PrintWriter output = new PrintWriter(outputFile);
        output.print(text);
        output.close();
    }
}