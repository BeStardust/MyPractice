package ch3;

public class NumberCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrNumber = new int[100];
		int[] numberCount = new int[] {0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<100;i++) {
			arrNumber[i] = (int)(Math.random()*10);			
			numberCount[arrNumber[i]]++;
		}
		for(int i=0;i<10;i++) {
			System.out.println(i+"-"+numberCount[i]+"times");
		}

	}

}
