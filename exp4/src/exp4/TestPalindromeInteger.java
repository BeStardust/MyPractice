package exp4;

import java.util.Scanner;

public class TestPalindromeInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number:");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		//PalindromeInteger chargePalindrome = new PalindromeInteger(number);
		// 静态引用方法
    	if (PalindromeInteger.isPalindrome(number) == true) {
			System.out.println("Number " + number + " is a palindrome");
		} else {
			System.out.println("Number" + number + "is not a palindrome");
		}
		input.close();

	}
}

class PalindromeInteger {
	int number;

	PalindromeInteger(int Number) {
		this.number = Number;
	}

	public static int reverse(int number) {
		String str = Integer.toString(number);
		char[] tempstr = str.toCharArray();
		String endstr="";
		for (int i = str.length()-1; i>=0; i--) {
			endstr+=tempstr[i];
		}
		int newNumber = Integer.parseInt(endstr);
		return newNumber;
	}

	public static boolean isPalindrome(int number) {
		boolean charge;
		if (reverse(number) == number) {
			charge = true;
		} else {
			charge = false;
		}
		return charge;

	}

}
