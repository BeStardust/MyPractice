package exp4;

public class TestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rec1=new Rectangle(4.0,40.0);
		System.out.println("The 1st rectangle's width:"+rec1.width+",height:"+rec1.height+",area:"+rec1.getArea()+",perimeter:"+rec1.getPerimeter());
		Rectangle rec2=new Rectangle(3.5,35.9);
		System.out.println("The 2nd rectangle's width:"+rec2.width+",height:"+rec2.height+",area:"+rec2.getArea()+",perimeter:"+rec2.getPerimeter());

	}

}

class Rectangle {
	double width = 1;
	double height = 1;
	Rectangle(){
		
	}
	Rectangle(double newWidth,double newHeight){
		width=newWidth;height=newHeight;
	}
	double getArea() {
		return width * height;
	}

	double getPerimeter() {
		return 2 * (width + height);
	}
}
