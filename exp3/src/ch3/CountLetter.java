package ch3;

import java.util.Scanner;

public class CountLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input  = new Scanner(System.in);
		System.out.print("Please input a string:");
		String str = input.nextLine();
		int cnt = countLetters(str);
		System.out.print("The number of letters in the string is "+cnt);
		input.close();
	}

	public static int countLetters(String s) {
		int cnt=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='a'&&s.charAt(i)<='z') {
				cnt++;
			}
		}
		return cnt;
	}
	
}
