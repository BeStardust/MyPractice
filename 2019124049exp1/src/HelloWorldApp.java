
public class HelloWorldApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long num=312032486;
		long temp=365*24*60*60;
		for(int i=0;i<5;i++) {
			num+=(temp/45-temp/13+temp/7);
			System.out.println("The population of No."+(i+1)+" year is "+num);
		}
	}
}
