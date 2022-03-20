package exp5;

import java.util.Random;

public class testRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random(200);
		for(int i=0;i<100;i++) {
			System.out.println("No"+(i+1)+" is "+rand.nextInt(200));
		}
	}

}
