package ch3;

import java.util.Scanner;

public class CheckPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.print("Please input a password:");
		String password = input.nextLine();
		boolean result =Check(password);
		if(result==false) {
			System.out.println("Invalid Password!\nPlease follow the rules:");
			System.out.println("¡ö A password must have at least eight characters.\n" + 
					                         "¡ö A password consists of only letters and digits.\n" + 
					                         "¡ö A password must contain at least two digits.");
		}
		else {
			System.out.println("Valid Password!");
		}
		input.close();

	}
	static boolean Check(String str) {
		boolean result = true;
		int digitCnt=0;
		int characterCnt=0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)>='A'&&str.charAt(i)<='Z'||str.charAt(i)>='a'&&str.charAt(i)<='z'||str.charAt(i)>='0'&&str.charAt(i)<='9') {
				if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
					digitCnt++;
				}
				else {
					characterCnt++;
				}
			}
			else {
				result=false;
				break;
			}
		}
			if(digitCnt<2||characterCnt<8) {
				result =false;
			}
		return result;
	}

}
