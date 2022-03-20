package ch3;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Please inpiut a decimal number:");
		Scanner input = new Scanner(System.in);
		int value = input.nextInt();
		String binary = decimalToBinary(value);
		System.out.print("The binary number is "+binary);
		input.close();
	}
	
	public static String decimalToBinary(int value) {
		String binarystr=Integer.toBinaryString(value);
		return binarystr;
	}
}
