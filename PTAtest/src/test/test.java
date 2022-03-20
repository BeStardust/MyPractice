package test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int setCnt = scanner.nextInt();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for (int i = 0; i < setCnt; i++) {
			int setLen = scanner.nextInt();
			LinkedHashSet<Integer> hashSet = new LinkedHashSet<Integer>();
			for (int j = 0; j < setLen; j++) {
				hashSet.add(scanner.nextInt());
			}
			lists.add(new ArrayList<>(hashSet));
		}

		int compareCnt=scanner.nextInt();
		for (int i = 0; i < compareCnt; i++) {
			int first=scanner.nextInt()-1;
			int second=scanner.nextInt()-1;
			System.out.printf("%.2f%%\n",calculatePercent(lists.get(first), lists.get(second)));
		}
		scanner.close();
	}
	public static double calculatePercent(List<Integer> list1,List<Integer> list2) {
		int cnt=0;
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i))) {
				cnt++;
			}
		}
		return (double)cnt/(list1.size()+list2.size()-cnt)*100;
		
	}
}
