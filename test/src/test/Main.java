package test;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	int object=0;
    	double area=0;
    	int temp;
    	Scanner input=new Scanner(System.in);
    	temp=input.nextInt();
    	while(temp!=0) {
    		switch(temp) {
    		case 1:
    			double NEWradius=input.nextDouble();
   // 		    int NULL=input.nextInt();
    		    
    		    Circle circle=new Circle(NEWradius);
    		    String color=input.next();
    		    circle.setColor(color);
    		    boolean filled=input.nextBoolean();
    		    circle.setFilled(filled);
    		    System.out.printf("Circle area is:%.6f color is:%s\n",circle.getArea(),circle.getColor());
    		    object++;area+=circle.getArea();temp=input.nextInt();continue;
    		case 2:
    			double length=input.nextDouble();
    		    double width=input.nextDouble();
    		    Rectangle rect=new Rectangle(length, width);
    		    String color1=input.next();
    		    rect.setColor(color1);
    		    boolean filled1=input.nextBoolean();
    		    rect.setFilled(filled1);
    		    System.out.printf("Rectangle area is:%.6f color is:%s\n",rect.getArea(),rect.getColor());
    		    object++;area+=rect.getArea();temp=input.nextInt();continue;
    		}
                	
    	}
    	System.out.println("----------\n"+object+" objects,total area are: "+area);
    	input.close();

    }
}
abstract class GeometricObject{
	private String color;
	private boolean filled;
	public GeometricObject() {
		color="white";
		filled=true;
	}
	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	} 
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public abstract double getArea();
	
}
class Circle extends GeometricObject{
	double radius;
//	private String color;
//	private boolean filled;
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI*radius*radius;
	}
	public Circle(double NEWradius) {
		// TODO Auto-generated constructor stub
//		super();
		this.radius=NEWradius;
	}
	public Circle(double radius,String color,boolean filled) {
		this.radius=radius;
//		this.color=color;
//		this.filled=filled;
		super.setColor(color);
		super.setFilled(filled);
		
	}
}
class Rectangle extends GeometricObject{
	double width;
	double length;
	public Rectangle(double length,double width) {
		this.length=length;
		this.width=width;
		// TODO Auto-generated constructor stub
	}
	public Rectangle(double length,double width,String color,boolean filled) {
		this.length=length;
		this.width=width;
		super.setColor(color);
		super.setFilled(filled);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width*length;
	}
}