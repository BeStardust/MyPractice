package review;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Circle c1=new Circle();
		System.out.println(c1.toString());
		System.out.println("c1:area="+c1.gerArea());
		Circle c2=new Circle();
		System.out.println(c2.toString());
		c2.setRadius(input.nextInt());
		System.out.println(c2.toString());
		System.out.println("c2:area="+c2.gerArea());
		Circle c3=new Circle(input.nextInt());
		System.out.println(c3.toString());
		System.out.println("c3:area="+c3.gerArea());		
		input.close();
	}

}
class Circle{
	private int radius;

	public Circle() {
		this.radius = 2;
		System.out.println("this is a constructor");
	}
	public Circle(int radius) {
		if(radius>0) {
			this.radius = radius;
		}
		else {
			this.radius=2;
		}
		System.out.println("this is a constructor with para");
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if(radius>0) {
			this.radius = radius;
		}
		else {
			this.radius=2;
		}
	}

	public int gerArea() {
		return (int)(Math.PI*radius*radius);
	}
	public String toString( ) {
		return "Circle [radius=" + radius + "]";
	}
	
}