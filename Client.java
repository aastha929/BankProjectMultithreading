package com.capgemini.ui;
import com.capgemini.service.Bank;
import com.capgemini.service.ICICIBank;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.service.BankRunner;
public class Client {
	public static void main(String[] args) 
	{
     Bank bank=new ICICIBank();
     BankRunner bankrunner=new BankRunner(bank);
     try {
    	    System.out.println(bank.createAccount(101,4000));
			System.out.println(bank.createAccount(102,5000));
			Thread firstThread = new Thread(bankrunner, "first");
			firstThread.start();
			Thread secondThread = new Thread(bankrunner, "second");
			secondThread.start();
			int[] total = bank.fundTransfer(101, 102, 500);
			System.out.println("Sender Balance = " + total[0] );
			System.out.println("Receiver Balance = " + total[1]);
			System.out.println("After deposit balance is " + bank.depositAmount(101, 400));
			System.out.println(bank.createAccount(103, 200));		
		}
		catch(InsufficientOpeningAmountException iob)
		{
			System.out.println("Insufficient opening balance");
		}
		catch(InsufficientBalanceException ibae)
		{
			System.out.println("Insufficient Balance");
		}
		catch(InvalidAccountNumberException iane)
		{
			System.out.println("Invalid account number");
		}
	}

}