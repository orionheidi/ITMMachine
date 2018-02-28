package ATMMashine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	private int bankID;
	private Date currentDateTime;
	private String customerName;
	private double acctBalance;
	private int withdrawalAmt;
	private int accountNumberUsed;
	private int pin;
	private int stripNumber;
	private int acctToWithdrawalFrom;
	
	private boolean didCardVerify = false;
	
	

	public Transaction(int stripNumber) {
		bankID = BankNetwork.getFirstTwoDigits(stripNumber);
		
		currentDateTime = new Date();
		
		accountNumberUsed = stripNumber;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public String getCurrentDateTime() {
		return dateFormat.format(currentDateTime);
	}


	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}

	public int getWithdrawalAmt() {
		return withdrawalAmt;
	}

	public void setWithdrawalAmt(int withdrawalAmt) {
		this.withdrawalAmt = withdrawalAmt;
	}

	public int getAccountNumberUsed() {
		return accountNumberUsed;
	}

	public void setAccountNumberUsed(int accountNumberUsed) {
		this.accountNumberUsed = accountNumberUsed;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getStripNumber() {
		return stripNumber;
	}

	public void setStripNumber(int stripNumber) {
		this.stripNumber = stripNumber;
	}

	public int getAcctToWithdrawalFrom() {
		return acctToWithdrawalFrom;
	}

	public void setAcctToWithdrawalFrom(int acctToWithdrawalFrom) {
		this.acctToWithdrawalFrom = acctToWithdrawalFrom;
		this.accountNumberUsed = (stripNumber * 10) + acctToWithdrawalFrom;
	}

	public boolean getDidCardVerify() {
		return didCardVerify;
	}

	public void setDidCardVerify(boolean cardVerify) {
		didCardVerify = (cardVerify)?true:false;
	}
	
	
	

}
