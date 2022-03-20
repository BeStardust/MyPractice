import java.util.Scanner;
public class sumdigits {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int sum=input.nextInt();
		if(sum<0||sum>1000) {
			System.out.println("Error!Please enter an integer between 0 and 1000!");
		}
		else {
			int qian=sum/1000;
			int bai=sum%1000/100;
			int shi=sum%1000%100/10;
			int ge=sum%1000%100%10;
			System.out.println("The sum of the digits is "+(qian+bai+shi+ge));
		}
		input.close();
	}
}
