package test;

public class duotai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat a=new Cat();
		System.out.println(a.age);
		a.eat();
//		a.eat();
				a.work();
	}

}
class Animal { 
	int age;
    public void eat() {
    	System.out.println("≥‘ ∫");
    }
}  
  
class Cat extends Animal { 
	int age=20;
	
    public void eat() {  
        System.out.println("≥‘”„");  
    }  
    public void work() {
    	System.out.println("◊•”„");
    }

}