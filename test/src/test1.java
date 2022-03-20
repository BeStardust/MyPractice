import java.util.ArrayList;
public class test1 {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
	public static void main(String[] args) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 
		 int n=3;
		 result=test1.getNarcissisticNumbers(n);
		 System.out.println(result);
	}
    public static ArrayList<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n==1){
            for(int i=0;i<10;i++){
                result.add(i);
            }
            return result;
        }
        for(int i=pow(10,n-1);i<pow(10,n);i++)
        {
            if(i==rightResult(n,i))
            {
                result.add(i);
            }
        }
        return result;
    }
    public static int rightResult(int n,int number){
        int num=number;
        String str=Integer.toString(num);
        int rightResult=0;
        for(int i=0;i<n;i++){
            rightResult+=pow((str.charAt(i)-'0'),n);
        }
        return rightResult;
    }
    public static int pow(int x,int y){
        int temp=1;
        for(int i=0;i<y;i++){
            temp*=x;
        }
        return temp;
    } 

}
