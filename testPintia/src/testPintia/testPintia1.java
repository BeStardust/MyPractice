package testPintia;


import java.util.Scanner;

public class testPintia1{
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        switch(x){
            case 1:
//                Scanner input = new Scanner(System.in);
                double radius=input.nextDouble();
                if(radius<=0){
                    System.out.println("Wrong Format");
                    break;
                }                
                Circle circle=new Circle();
                circle.setRadius(radius);
                System.out.println("Circle's area:"+(int)(circle.getArea()*100)/(double)100);break;
            case 2:
//                Scanner input=new Scanner(System.in);
                double width=input.nextDouble();
                double length=input.nextDouble();
                if(width<=0||length<=0){
                    System.out.println("Wrong Format");
                    break;
                }                
                Rectangle rectangle=new Rectangle();
                rectangle.setWidth(width);
                rectangle.setLength(length);
                System.out.println("Rectangle's area:"+(int)(rectangle.getArea()*100)/(double)100);break;
            case 3:
                double RADIUS=input.nextDouble();
                if(RADIUS<=0){
                    System.out.println("Wrong Format");
                    break;
                }
                Ball ball=new Ball();
                ball.setRadius(RADIUS);
                
                System.out.println("Ball's surface area:"+(int)(ball.getArea()*100)/(double)100+"\nBall's volume:"+(int)(ball.getVolume()*100)/(double)100);break;
            case 4:
                double WIDTH=input.nextDouble();
                double LENGTH=input.nextDouble();
                double height=input.nextDouble();
                if(WIDTH<=0||LENGTH<=0||height<=0){
                    System.out.println("Wrong Format");
                    break;
                }
                Box box=new Box();
                box.setWidth(WIDTH);
                box.setLength(LENGTH);
                box.setHeight(height);
                System.out.println("Box's surface area:"+(int)(box.getArea()*100)/(double)100+"\nBox's volume:"+(int)(box.getVolume()*100)/(double)100);      break;           
            default:System.out.println("Wrong Format");
        }
        input.close();
    }
}
class Shape{
    Shape(){
        System.out.println( "Constructing Shape");
    }
    public double getArea(){
        return 0.0;
    }
}
class Circle extends Shape{
    private double radius=0;
    Circle(){
        super();
        System.out.println( "Constructing Circle");
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double NewRadius){
        this.radius=NewRadius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}
class Rectangle extends Shape{
    private double width=0;
    private double length=0;
    public Rectangle(){
        super();
        System.out.println( "Constructing Rectangle");
    }
    public double getWidth(){
        return width;
    }
    public double getLength(){
        return length;
    }
    public void setWidth(double newWidth){
        this.width=newWidth;
    }
    public void setLength(double newLength){
        this.length=newLength;
    }
    public double getArea(){
        return width*length;
    }
}
class Ball extends Circle{
    Ball(){
        super();
        System.out.println( "Constructing Ball");
    }
    public double getArea(){
        return 4*Math.PI*super.getRadius()*super.getRadius();
    }
    public double getVolume(){
    	return 4/3*Math.PI*super.getRadius()*super.getRadius()*super.getRadius();
    }
}
class Box extends Rectangle{
    private double height;
    Box(){
        super();
        System.out.println( "Constructing Box");
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double newHeight){
        this.height=newHeight;
    }
    public double getArea(){
        return 2*(super.getWidth()*super.getLength()+super.getWidth()*height+super.getLength()*height);
    }
    public double getVolume(){

        return super.getWidth()*super.getLength()*height;
    }
}
