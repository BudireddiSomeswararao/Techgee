package ATM.com.somu;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	
	private int CustomerNumber;
	private int PinNumber;
	private double CheckingBalance=0;
	private double SavingBalance=0;
	
	
	DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00");
	Scanner input=new Scanner(System.in);
	
	

	public int getCustomerNumber() {
		return CustomerNumber;
	}




	public void setCustomerNumber(int customerNumber) {
		CustomerNumber = customerNumber;
	}




	public int getPinNumber() {
		return PinNumber;
	}




	public void setPinNumber(int pinNumber) {
		PinNumber = pinNumber;
	}




	public double getCheckingBalance() {
		return CheckingBalance;
	}




	public void setCheckingBalance(double checkingBalance) {
		CheckingBalance = checkingBalance;
	}




	public double getSavingBalance() {
		return SavingBalance;
	}




	public void setSavingBalance(double savingBalance) {
		SavingBalance = savingBalance;
	}
	
	public double calcCheckingWithdraw(double amount) {
		 CheckingBalance = (CheckingBalance-amount);
		return CheckingBalance;
	}
	
	public double calcSavingWithdraw(double amount) {
		 SavingBalance = (SavingBalance-amount);
		return SavingBalance;
	}
	public double calcCheckingDeposit(double amount) {
		 CheckingBalance = (CheckingBalance+amount);
		return CheckingBalance;
	}
	public double calcSavingDeposit(double amount) {
		 SavingBalance = (SavingBalance+amount);
		return SavingBalance;
	}
	
	public void getCheckingWithdrawInput() {
		
		System.out.println("Checking Account Balance: "+ moneyFormat.format(CheckingBalance));
		System.out.println("Amount you want to withdraw from Checking Account: ");
		double amount = input.nextDouble();
		
		if((CheckingBalance-amount) >=0) {
			calcCheckingWithdraw(amount);
			System.out.println("New Checking account Balance: "+ moneyFormat.format(CheckingBalance));
		}
		else {
			System.out.println("Balance cannot be Negativ "+"\n");
		}
	}
	
	public void getCheckingDepositInput() {
		
		System.out.println("Checking Account Balance: "+ moneyFormat.format(CheckingBalance));
		System.out.println("Amount you want to Deposit from Checking Account: ");
		double amount = input.nextDouble();
		
		if((CheckingBalance+amount) >=0) {
			calcCheckingDeposit(amount);
			System.out.println("New Checking account Balance: "+ moneyFormat.format(CheckingBalance));
		}
		else {
			System.out.println("Balance cannot be Negativ "+"\n");
		}
	}
	
	public void getSavingWithdrawInput() {
		
		System.out.println("Saving Account Balance: "+ moneyFormat.format(SavingBalance));
		System.out.println("Amount you want to withdraw from Saving Account: ");
		double amount = input.nextDouble();
		
		if((SavingBalance-amount) >=0) {
			calcSavingWithdraw(amount);
			System.out.println("New Saving account Balance: "+ moneyFormat.format(SavingBalance));
		}
		else {
			System.out.println("Balance cannot be Negativ "+"\n");
		}
	}
	
	public void getSavingDepositInput() {
		
		System.out.println("Saving Account Balance: "+ moneyFormat.format(SavingBalance));
		System.out.println("Amount you want to Deposit from Saving Account: ");
		double amount = input.nextDouble();
		
		if((CheckingBalance+amount) >=0) {
			calcSavingDeposit(amount);
			System.out.println("New Saving account Balance: "+ moneyFormat.format(SavingBalance));
		}
		else {
			System.out.println("Balance cannot be Negativ "+"\n");
		}
	}
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
