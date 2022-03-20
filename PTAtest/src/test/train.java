package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class train {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Integer[]> arr=new ArrayList<Integer[]>();
		int train[]=new int[10000];
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer strToken=new StreamTokenizer(reader);
		strToken.nextToken();
		for (int i = 0; i < (int) strToken.nval; i++) {
			strToken.nextToken();
			train[i]=(int) strToken.nval;
		}
		Integer integers[];
		integers[0]=train[0];
		arr.add(integers);
		for (int i = 1; i < train.length; i++) {
			for (int j = 0; j < 100; j++) {
				if (train[i])>arr[j][i] {
					
				}
			}
		}
	}

}
