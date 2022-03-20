package ch5;



/**
 * @author Steven Suo
 * @version 1.0
 *  第一个JavaBean
 */
 public class Hello { 
	
	//定义私有的成员变量hello,hello为字符串类型；
	private String hello;
	
	//定义无参数的构造方法
	public Hello(){}

	/**
	 * @return the hello
	 */
	public String getHello() {
		return hello;
	}

	/**
	 * @param hello the hello to set
	 */
	public void setHello(String hello) {
		this.hello = hello;
	}

	
	
}
