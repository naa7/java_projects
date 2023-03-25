public class CharacterCounter {
    public static void main(String[] args) {
        int value = 0;
        int numDigit = 0, numUpper = 0, numLower = 0, numOther = 0, numLetter = 0;
        char chr;
        String str = "";
        for (int i = 0; i < 100; i++) {
            value = (int) (48 + Math.random() * (122 - 48 + 1));
            chr = (char) value;
            str = str + chr;
        }
        for (int i = 0; i < str.length(); i++) {
            char tempChr = str.charAt(i);
            if (Character.isDigit(tempChr)) {
                numDigit++;
            } else if (Character.isLowerCase(tempChr)) {
                numLower++;
                numLetter++;
            } else if (Character.isUpperCase(tempChr)) {
                numUpper++;
                numLetter++;
            } else {
                numOther++;
            }
        }
        System.out.println("String: " + str);
        System.out.println("Total number of characters: " + str.length());
        System.out.println("Total number of digits: " + numDigit);
        System.out.println("Total number of letters: " + numLetter);
        System.out.println("Total number of upper-case letters: " + numUpper);
        System.out.println("Total number of lower-case letters: " + numLower);
        System.out.println("Total number of other characters: " + numOther);
    }
}
