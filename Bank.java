package com.capgemini.service;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;


public interface Bank {

	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException;
	public String createAccount(int accountNumber,int amount) throws InsufficientOpeningAmountException;
	public int[] fundTransfer(int senderAccountNumber,int recieverAccountNumber,int transferAmount) throws InvalidAccountNumberException, InsufficientBalanceException;
	public int depositAmount(int accountNumber,int amount)throws InvalidAccountNumberException;

}
