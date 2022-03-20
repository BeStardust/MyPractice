package exp;

import exp6.Shape;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape = new Shape("shape0");
		System.out.println(shape.getArea());
		System.out.println(shape.getPerimeter());
		Shape s=new Circle("circle1");
		((Circle) s).setRadius(3);
		System.out.println(((Circle) s).getArea());
		System.out.println(((Circle) s).getPerimeter());
		
		Shape tri = new Triangle("triangle1");
		((Triangle) tri).setSide1(3);((Triangle) tri).setSide2(4);((Triangle) tri).setSide3(5);
		System.out.println(tri.getArea());
		System.out.println( tri.getPerimeter());
	
		Shape rect =new Rectangle("triangle1");
		((Rectangle) rect).setWidth(3);((Rectangle) rect).setLength(4);
		System.out.println(((Rectangle) rect).getArea());
		System.out.println(((Rectangle) rect).getPerimeter());
		

	}

}
class Circle extends Shape{
	public double radius;

	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Circle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public double getArea() {
		return Math.PI*radius*radius;
	}
	public double getPerimeter() {
		return 2*Math.PI*radius;
	}	
}
class Triangle extends Shape{

	double side1=1.0;
	double side2=1.0;
	double side3=1.0;
	
	public double getSide1() {
		return side1;
	}
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	public double getSide2() {
		return side2;
	}
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	public double getSide3() {
		return side3;
	}
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	public Triangle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public double getArea() {
		double s=(side1+side2+side3)/2;
		double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}
	@Override
	public double getPerimeter() {
		return side1+side2+side3;
	}
}
class Rectangle extends Shape{
	double width;
	double length;

	public Rectangle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	public double getArea() {
		return width*length;
	}
	public double getPerimeter() {
		return 2*(width+length);
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
}
