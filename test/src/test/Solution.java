package test;

import java.util.concurrent.CountDownLatch;

public class Solution {
	/*
	 * @param s: A string
	 * 
	 * @return: A string
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "This won iz correkt. It has, No Mistakes et Oll. But there are two BIG mistakes in this sentence. and here is one more.";
		Solution a=new Solution();
		System.out.println(a.count(string));
		


	}


		// write your code here
    public boolean isLegalIdentifier(String str) {
    	boolean x = false;
    	if (str.isEmpty()) {
			return false;
		}
    	if (str.charAt(0)>='0'&&str.charAt(0)<='9') {
			return false;
		}

    	for(int i=0;i<str.length();i++) {
    		if(str.charAt(i)>='A'&&str.charAt(i)<='Z') {
    			x=true;
    		}
    		else if (str.charAt(i)>='a'&&str.charAt(i)<='z') {
				x=true;
			}
    		else if (str.charAt(i)>='0'&&str.charAt(i)<='9') {
				x=true;
			}
    		else if (str.charAt(i)=='_') {
				x=true;
			}
    		else {
				x=false;break;
			}
    	}
    	return x;
        // Write your code here.
    }

    public int co(String str) {

    	char i;
    	int cnt=0;
    	int max=0;
    	for(i='A';i<='Z';i++) {
    		for(int j=0;j<str.length();j++) {
    			if(str.charAt(j)==i) {
    				cnt++;
    			}
    		}
    		max=Math.max(cnt, max);
    		cnt=0;
    	}
    	for(i='a';i<='z';i++) {
    		for(int j=0;j<str.length();j++) {
    			if(str.charAt(j)==i) {
    				cnt++;
    			}
    		}
    		max=Math.max(cnt, max);
    		cnt=0;
    	}
		return max;
        // Write your code here.
    }
    public int count(String s) {
    	int cnt=0;
    	if(s.charAt(0)<='A'||s.charAt(0)>='Z') {
    		cnt++;
    	}
    	for(int i=3;i<s.length();i++) {
    		if (s.charAt(i)>='A'&&s.charAt(i)<='Z') {
				if(s.charAt(i-2)!='.') {
					cnt++;
				}
			}
//    		if (s.charAt(i+2)<='a'||s.charAt(i+2)>='z') {
//				if (s.charAt(i-2)!=',') {
//					
//				}
//			}
    	}
		return cnt;
        // Write your code here.
    }
}