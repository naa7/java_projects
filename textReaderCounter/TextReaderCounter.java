import java.io.*;
import java.util.Scanner;

public class TextReaderCounter {

    public static void main(String[] args) throws IOException {
        writeFile(fileHeader("[Name]", "Text Reader & Counter", "Version 1"));
        appendToWriteFile(readStringHeader());
        String text = readFile();
        appendToWriteFile(readString(text));
        appendToWriteFile(countCharsHeader());
        appendToWriteFile(countChars(text, 'a', 'z'));
        appendToWriteFile(countChars(text, 'A', 'Z'));
        appendToWriteFile(countChars(text, '0', '9'));
        appendToWriteFile(countChars(text, ' ', '/'));
        appendToWriteFile(countChars(text, ':', '@'));
        appendToWriteFile(countChars(text, '[', '`'));
        appendToWriteFile(countChars(text, '{', '~'));
//        appendToWriteFile(countChars(text, '!', '~'));
//        appendToWriteFile(countChars(text, ',', ','));
//        appendToWriteFile(countChars(text, '.', '.'));
    }

    private static String line() {
        int length = 59;
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if ((i == 0) || (i == length - 1)) {
                System.out.print('+');
            text.append("+");
            } else {
                System.out.print('-');
                text.append('-');
            }
        }
        System.out.println();
        text.append('\n');
        return text.toString();
    }

    private static String fileHeader(String name, String title, String version) {
        String text = "";
        text = text + line();
        System.out.printf("| %-16s%22s%17s%2s\n", name, title, version, "|");
        text = text + String.format("| %-16s%22s%17s%2s\n", name, title, version, "|");
        System.out.printf("|%58s\n", "|");
        text = text + String.format("|%58s\n", "|");
        text = text + line();
        return text;
    }

    private static String readFile() throws IOException {
        File inputFile = new File("sample.txt");
        Scanner input = new Scanner(inputFile);
        StringBuilder text = new StringBuilder();
        while (input.hasNext()) {
            text.append(input.nextLine());
        }
        input.close();
        return text.toString();
    }

    private static void writeFile(String text) throws IOException {
        File outputFile = new File("outputFile.txt");
        PrintWriter output = new PrintWriter(outputFile);
        output.print(text);
        output.close();
    }

    private static void appendToWriteFile(String text) throws IOException {
        FileWriter outputFile = new FileWriter("outputFile.txt", true);
        PrintWriter output = new PrintWriter(outputFile);
        output.print(text);
        output.close();
    }

    private static String readStringHeader() {
        String text = "";
        System.out.printf("| %29s%28s\n", "Text", "|");
        text = text + String.format("| %29s%28s\n", "Text", "|");
        text = text + line();
        return text;
    }

    private static String readString(String text) {
        int flag = 0;
        StringBuilder newText = new StringBuilder("| ");
        System.out.print("| ");
        for (int i = 0; i < text.length(); i++) {
            if (flag == 55) {
                System.out.printf("%2s\n%2s", "|", "| ");
                newText.append(String.format("%2s\n%2s", "|", "| "));
                flag = 0;
            }
            newText.append(text.charAt(i));
            System.out.print(text.charAt(i));
            if ((i+1) == text.length()) {
                flag = 54 - flag;
                while (flag > 0) {
                    System.out.print(" ");
                    newText.append(" ");
                    flag--;
                }
                System.out.print(" |");
                newText.append(" |");
            }
            flag++;
        }
        System.out.println();
        newText.append("\n").append(line());
        return newText.toString();
    }

    private static String countCharsHeader() {
        String text = "";
        System.out.printf("| %35s%22s\n", "Characters Count", "|");
        text = text + String.format("| %35s%22s\n", "Characters Count", "|");
        text = text + line();
        return text;
    }

    private static String countChars(String text, char start, char end) {
        int counter = 0;
        StringBuilder newText = new StringBuilder();
        for (char ch = start; ch <= end; ch++) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ch)
                    counter++;
            }
            if (counter > 0) {
                System.out.printf("|%s%s%2s%-3d%49s\n", " [", ch, "]: ", counter, "|");
                newText.append(String.format("|%s%s%2s%-3d%49s\n", " [", ch, "]: ", counter, "|"));
            }
            counter = 0;
        }
        newText.append(line());
        return newText.toString();
    }
}