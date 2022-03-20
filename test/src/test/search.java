package test;

public class search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	int serach(int[] A,int target){
	int flag=0;
	int index=-1;
	for(int i=0;i<A.length;i++) {
		if(A[i]==target) {
			index=i;
			flag=1;
			break;
		}
	}
	if(flag!=1) {
		for (int i = 0; i < A.length-1; ) {
			if(A[i]<target) {
				i++;
			}
            else {
				
			}
		}
	}
	return index;
	}
}
