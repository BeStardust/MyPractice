
import java.util.Scanner;
public class currency {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz1 = Class.forName("Converter");
        Class<?> clazz2 = Class.forName("ForeignExchangeAccount");
        System.out.println(clazz1.isInterface()+" "+clazz1.isAssignableFrom(clazz2));
        Scanner scanner = new Scanner(System.in);
        System.out.println("����������˻��ı���,���ʺͿ�������ı��ҽ��м��ÿո�");
        String currency = scanner.next();
        double exchangeRate = scanner.nextDouble();
        double balance = scanner.nextDouble();
        ForeignExchangeAccount account = new ForeignExchangeAccount(currency,exchangeRate,balance);
        account.convert();
        System.out.println(account.getCurrency()+"�˻������ʣ�"+account.getExchangeRate()+"��������"+account.getLocalCurrencyBalance()+"�������"+account.getForeignCurrencyBalance());
        account.setExchangeRate(0.71);
        account.convert();
        System.out.println(account.getCurrency()+"�˻������ʣ�"+account.getExchangeRate()+"��������"+account.getLocalCurrencyBalance()+"�������"+account.getForeignCurrencyBalance());
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

//������ʵ����
//����һ���� ForeignExchangeAccount ��ʾ����˻���Ҫ�����ʵ��Converter�ӿڣ�ʵ�ֻ��һ��㹦�ܣ� ����ForeignExchangeAccount�������Ҫ�����£�
//1����Ա���� localCurrencyBalance��ʾ�˻������������ RMB������������getter������
//2����Ա���� foreignCurrencyBalance ��ʾ�˻��������������getter������
//3����Ա���� currency ��ʾ���֣����磺��USD�� ��ʾ��Ԫ�˻�����JPY����ʾ��Ԫ�˻�����������getter������
//4����Ա���� exchangeRate ��ʾ���ʣ���ʾ 1ԪRMB����ɶ�Ӧ�������ҵĻ��ʣ���������getter��setter������
//5�������������Ĺ���������ʵ����ForeignExchangeAccount����ʱ��ʼ�����˻����֡������Լ���ʼ���ı��ң�RMB����
//6��ʵ��Converter�ӿ��е�convert�����������������ʻ����������