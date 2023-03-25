import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		System.out.print("Enter byte value: ");
		Scanner input = new Scanner(System.in);
		byte num = input.nextByte();
		short signedNum = (short)(num);
		int unsignedNum = Short.toUnsignedInt(signedNum);
		while (unsignedNum < (Math.pow(2,16) - 1)) {
			if (num < (Math.pow(2,7) - 1)) {
				num++;
			}
			System.out.printf("%s\r", unsignedNum++);
		}
		System.out.printf("Signed byte range: -%s to %s\n", num, num);
		System.out.printf("Signed short range: -%s to %s\n", ((unsignedNum + 1)/2 - 1), ((unsignedNum + 1)/2 - 1));
		System.out.println("Unsigned short range: 0 to " + unsignedNum);
	}
}
