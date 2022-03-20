package exp6;

public class Triangle extends Shape {

	double side1=1.0;
	double side2=1.0;
	double side3=1.0;
	
	public Triangle(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public Triangle() {
		super("Triangle0");
		side1=1.0;
		side2=1.0;
		side3=1.0;
	}
	public Triangle(String name,double side1,double side2, double side3) {
		super(name);
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	@Override
	public double getArea() {
		double s=(side1+side2+side3)/2;
		double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		return area;
	}
	@Override
	public double getPerimeter() {
		return side1+side2+side3;
	}
	@Override
	public String toString() {
		return "Triangle "+getName()+" : side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3 +" area =" + getArea() +" perimeter =" + getPerimeter();   
	}

}
