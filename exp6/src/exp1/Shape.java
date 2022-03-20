package exp1;

public abstract class Shape {
	private String name;
	public Shape(String name) {
		this.name = name;
	}
	public abstract double getArea() ;
	public abstract double getPerimeter() ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
//Rewriting the Shape class and to change
//the getArea() method and getPerimeter()
//method to be abstract in the Shape class and the Shape class is also abstracted.