import java.util.Scanner;

public class compoundvalue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter the monthly saving amount:");
		Scanner input = new Scanner(System.in);
		double in = input.nextDouble();
		double sum = 0;
		for (int i = 0; i < 6; i++) {
			sum = ((in + sum) * (1 + 0.00417));
		}
		System.out.println("After the sixth month, the account value is $" + (double)((int)(sum*100))/100);
		input.close();
	}
}
