
public class patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		System.out.println("Pattern A");
		for (i = 0; i < 6; i++) {
			int n = 1;
			for (j = 0; j <= i; j++) {
				System.out.print(n++ + " ");
			}
			System.out.println();
		}
		System.out.println("Pattern B");
		for (i = 0; i < 6; i++) {
			int n = 1;
			for (j = 6 - i; j > 0; j--) {
				System.out.print(n++ + " ");
			}
			System.out.println();
		}
		System.out.println("Pattern C");
		for (i = 0; i < 6; i++) {
			for (j = 5 - i; j > 0; j--) {
				System.out.print("  ");
			}
			int n = i + 1;
			for (j = 0; j <= i; j++) {
				System.out.print(n-- + " ");
			}
			System.out.println();
		}
		System.out.println("Pattern D");
		for (i = 0; i < 6; i++) {
			for (j = 0; j < i; j++) {
				System.out.print("  ");
			}
			int n = 1;
			for (j = 6; j > i; j--) {
				System.out.print(n++ + " ");
			}
			System.out.println();
			}
		}
	}
