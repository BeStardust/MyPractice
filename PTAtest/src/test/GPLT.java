package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;



public class GPLT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Scanner scanner = new Scanner(System.in);
//		StreamTokenizer read=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String str=reader.readLine();
//		str = scanner.next();
		ArrayList<Character> G = new ArrayList<Character>();
		ArrayList<Character> P = new ArrayList<Character>();
		ArrayList<Character> L = new ArrayList<Character>();
		ArrayList<Character> T = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'G'||str.charAt(i) =='g') {
				G.add('G');
			} else if (str.charAt(i) == 'P'||str.charAt(i) =='p') {
				P.add('P');
			} else if (str.charAt(i) == 'L'||str.charAt(i) =='l') {
				L.add('L');
			} else if (str.charAt(i) == 'T'||str.charAt(i) =='t') {
				T.add('T');
			}
		}

		for (int i = 0; i < Math.max(Math.max(Math.max(G.size(), P.size()), L.size()), T.size()); i++) {
			if (i < G.size()) {
				System.out.print(G.get(i));
			}
			if (i < P.size()) {
				System.out.print(P.get(i));
			}
			if (i < L.size()) {
				System.out.print(L.get(i));
			}
			if (i < T.size()) {
				System.out.print(T.get(i));
			}
		}
		System.out.println();
	}

}
