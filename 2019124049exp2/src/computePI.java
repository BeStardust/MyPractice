
public class computePI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int temp=10000;temp<=100000;temp+=10000) {
			double PIonefourth=0;
			for(int i=1;i<=temp;i++) {
				if(i%2!=0) {
					PIonefourth+=1/(double)(2*i-1);
				}
				else {
					PIonefourth-=1/(double)(2*i-1);
				}
			}
			System.out.println("PI="+4*PIonefourth);
		}
	}
}
