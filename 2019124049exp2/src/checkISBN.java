import java.util.Scanner;

public class checkISBN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first 9 digits of an ISBN an integer:");
		String str = input.nextLine();
		if (str.length() != 9) {
			System.out.println("Error!");
		} else {
			int i;
			int temp = 0;
			for (i = 0; i < 9; i++) {
				if ((str.charAt(i) - '0') > 9 || (str.charAt(i) - '0') < 0) {
					System.out.println("Error!");
					break;
				} else {
					temp += ((str.charAt(i) - '0') *( i+1));
				}
			}
			temp %= 11;
			if (temp == 10) {
				System.out.println("The ISBN-10 number is " +str+ "X");
			} else {
				System.out.println("The ISBN-10 number is " +str+ temp);
			}
		}
		input.close();
	}
}
