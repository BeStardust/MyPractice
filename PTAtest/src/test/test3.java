package test;


import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String numString = scanner.next();
		String printString = "";
		for (int i = 0; i < numString.length(); i++) {
			printString += PY(numString.charAt(i));

		}
		
		System.out.println(printString.substring(0,printString.length()-1));
		scanner.close();
	}

	private static String PY(char charAt) {
		// TODO Auto-generated method stub
		switch (charAt) {
		case '-':
			return "fu ";
		case '0':
			return "ling ";
		case '1':
			return "yi ";
		case '2':
			return "er ";
		case '3':
			return "san ";
		case '4':
			return "si ";
		case '5':
			return "wu ";
		case '6':
			return "liu ";
		case '7':
			return "qi ";
		case '8':
			return "ba ";
		case '9':
			return "jiu ";
		default:
			break;
		}
		return null;
	}

}
