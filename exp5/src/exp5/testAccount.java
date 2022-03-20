package exp5;

import java.util.Date;

public class testAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account(1122,20000);
		account.setAnnualInterestRate(4.5);
		account.withdraw(2500);
		account.deposit(3000);
		System.out.println("balance:"+account.getBalance()+"\nmonthly interest:"+account.getMonthlyInterest()+"\nCreation Date:"+account.getDate());

	}

}

class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;

	public Account() {
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		dateCreated= new Date();
	}
	public Account(int newId,double newBalance) {
		id=newId;
		balance=newBalance;
		dateCreated=new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int newId) {
		id=newId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double newBalance) {
		balance=newBalance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate=newAnnualInterestRate/100;
	}
	public Date getDate() {
		return dateCreated;
	}
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	public double getMonthlyInterest() {
		return getBalance()*getMonthlyInterestRate();
	}
	public void withdraw(double amount) {
		balance-=amount;
	}
	public void deposit(double amount) {
		balance+=amount;
	}
}
