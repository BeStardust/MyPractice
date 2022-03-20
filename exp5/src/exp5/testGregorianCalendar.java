package exp5;

import java.util.GregorianCalendar;

public class testGregorianCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.GregorianCalendar GC1 = new java.util.GregorianCalendar();
		System.out.println(GC1.get(GregorianCalendar.YEAR)+"-"+(GC1.get(GregorianCalendar.MONTH)+1)+"-"+GC1.get(GregorianCalendar.DAY_OF_MONTH));
		GregorianCalendar GC2=new GregorianCalendar();
		GC2.setTimeInMillis(1234567898765L);
		System.out.println(GC2.get(GregorianCalendar.YEAR)+"-"+(GC2.get(GregorianCalendar.MONTH)+1)+"-"+GC2.get(GregorianCalendar.DAY_OF_MONTH));
	}

}
