
import java.util.Scanner;
public class currency {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz1 = Class.forName("Converter");
        Class<?> clazz2 = Class.forName("ForeignExchangeAccount");
        System.out.println(clazz1.isInterface()+" "+clazz1.isAssignableFrom(clazz2));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入外汇账户的币种,汇率和开户存入的本币金额，中间用空格：");
        String currency = scanner.next();
        double exchangeRate = scanner.nextDouble();
        double balance = scanner.nextDouble();
        ForeignExchangeAccount account = new ForeignExchangeAccount(currency,exchangeRate,balance);
        account.convert();
        System.out.println(account.getCurrency()+"账户，汇率："+account.getExchangeRate()+"，本币余额："+account.getLocalCurrencyBalance()+"，外币余额："+account.getForeignCurrencyBalance());
        account.setExchangeRate(0.71);
        account.convert();
        System.out.println(account.getCurrency()+"账户，汇率："+account.getExchangeRate()+"，本币余额："+account.getLocalCurrencyBalance()+"，外币余额："+account.getForeignCurrencyBalance());
        scanner.close();
    }
}
 interface Converter{
	public void convert();
}

class ForeignExchangeAccount implements Converter{
	double  localCurrencyBalance;
	double foreignCurrencyBalance;
	 String currency;
		double exchangeRate;
	 

	public ForeignExchangeAccount(String currency, double exchangeRate, double localCurrencyBalance) {
			super();
			this.currency = currency;
			this.exchangeRate = exchangeRate;
			this.localCurrencyBalance = localCurrencyBalance;
		}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public double getLocalCurrencyBalance() {
		return localCurrencyBalance;
	}
	public double getForeignCurrencyBalance() {
		return foreignCurrencyBalance;
	}
	public String getCurrency() {
		return currency;
	}

	@Override
	public void convert() {
		// TODO Auto-generated method stub
		this.foreignCurrencyBalance=this.localCurrencyBalance*this.exchangeRate;
	}
	
}

//定义其实现类
//定义一个类 ForeignExchangeAccount 表示外汇账户，要求该类实现Converter接口，实现货币换算功能， 定义ForeignExchangeAccount类的其它要求如下：
//1、成员变量 localCurrencyBalance表示账户本币余额（人民币 RMB），并定义其getter方法；
//2、成员变量 foreignCurrencyBalance 表示账户外币余额，并定义其getter方法；
//3、成员变量 currency 表示币种，比如：”USD“ 表示美元账户，”JPY“表示日元账户，并定义其getter方法；
//4、成员变量 exchangeRate 表示汇率，表示 1元RMB换算成对应的外汇货币的汇率，并定义其getter和setter方法；
//5、带三个参数的构造器，在实例化ForeignExchangeAccount对象时初始化：账户币种、汇率以及初始化的本币（RMB）余额；
//6、实现Converter接口中的convert方法，将本币余额按汇率换算成外币余额