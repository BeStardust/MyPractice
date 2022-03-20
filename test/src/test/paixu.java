package test;

public class paixu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
    public void sortIntegers(int[] A) {
        // write your code here
        int i,j,temp;
        for(i=0;i<A.length;i++) {
        	for(j=i+1;j<A.length;j++) {
        		if(A[j]>A[j+1]) {
        			temp=A[j];
        			A[j]=A[j+1];
        			A[j+1]=temp;
        		}
        	}
        }
    }

}
