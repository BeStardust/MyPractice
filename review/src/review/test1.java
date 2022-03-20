package review;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class test1{
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        ArrayList<Double> cnt=new ArrayList<>();
        double sum=0;
        int a=input.nextInt();
        int b=input.nextInt();
        int c=input.nextInt();
        if(a<0||b<0||c<0) {
    		System.out.println("Wrong Format");
    		return;
        }

        int temp=0;
//        double[] arr=new double[100];
//        for(int i=0;i<a+2*b+3*c;i++) {
//        	arr[temp++]=input.nextDouble();
//        }
        ArrayList<Double> arr =  new ArrayList<>();
        for(int i=0;i<a+2*b+c*3;i++) {
        	arr.add(input.nextDouble());
        }
        temp=0;
        for(int i=0;i<a;i++) {
        	double x=arr.get(temp++);
        	if(x<=0) {
        		System.out.println("Wrong Format");
        		return;
        	}
        }
        for(int i=0;i<b;i++) {
        	double x=arr.get(temp++);
        	double y=arr.get(temp++);
        	if(x<=0||y=<0) {
        		System.out.println("Wrong Format");
        		return;
        	}
        }
        
        for(int i=0;i<c;i++) {
        	double x=arr.get(temp++);
        	double y=arr.get(temp++);
        	double z=arr.get(temp++);
        	if(x<=0||y<=0||z<=0||(x+y<=z)||(x-y>=z)||(x+z<=y)||(x-z>=y)||(y+x<=z)||(y-x>=z)||(y+z<=x)||(y-z>=x)||(z+x<=y)||(z-x>=y)||(z+y<=x)||(z-y>=x)) {
        		System.out.println("Wrong Format");
        		return;
        	}
        }
        temp=0;
        System.out.println("Original area:");
        for(int i=0;i<a;i++) {
        	double x=arr.get(temp++);
        	Circle circle=new Circle(x);
        	System.out.printf("%.2f ",circle.getArea());
        	cnt.add(circle.getArea());
        	sum+=circle.getArea();
        }
        for(int i=0;i<b;i++) {
        	double x=arr.get(temp++);
        	double y=arr.get(temp++);
        	Rectangle rect=new Rectangle(x, y);
        	System.out.printf("%.2f ",rect.getArea());
        	cnt.add(rect.getArea());
        	sum+=rect.getArea();
        }
        
        for(int i=0;i<c;i++) {
        	double x=arr.get(temp++);
        	double y=arr.get(temp++);
        	double z=arr.get(temp++);
        	Triangle tri=new Triangle(x, y,z);
        	System.out.printf("%.2f ",tri.getArea());
        	cnt.add(tri.getArea());
        	sum+=tri.getArea();
        }
        System.out.printf("\nSum of area:%.2f\n",sum);
        System.out.println("Sorted area:");
        Collections.sort(cnt);
		for (double i : cnt) {
			System.out.printf("%.2f ",i);
		}
        System.out.printf("\nSum of area:%.2f\n",sum);		
        input.close();
    } 
}
class Circle{
	double r;
	public double getArea(){
		return r*r*Math.PI;
	}
	public Circle(double r) {
		super();
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

}
class Rectangle{
	double a,b;
	public double getArea(){
		return a*b;
	}
	public Rectangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}
	
}
class Triangle{
	double a,b,c;
	public double getArea(){
		double p=(a+b+c)/2;
		double S=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return S;
	}
	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
}
