package test1;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int count=0;
		int[][] a=new int[n][k];
		for (int i = 0; i <n; i++) {
			for(int j=0;j<k;j++) {
				a[i][j]=scanner.nextInt();
			}
		}
	
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				for(int id=0;id<k-1;id++) {
					if ((a[i][id]+a[j][id])==(a[i][id+1]+a[j][id+1])) {
					}
					else {
						break;
					}
					if(id==k-2){
						count++;
					}
				}

			}
		}
		System.out.print(count);
	}

}
