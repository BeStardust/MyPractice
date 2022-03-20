package review;

public class Main{
    @SuppressWarnings("unused")
	public static void main(String args[]) {
      one:
      two:
      for(int i=0; i<3; i++) {
          three:
          for(int j=10; j<30; j+=10) {
             System.out.println(i+j);
             if(i>0)
                break one;
          }
      }
    }
}
