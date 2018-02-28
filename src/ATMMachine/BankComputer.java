package ATMMashine;

import java.util.ArrayList;

public class BankComputer {

	private int bankID = 9;
	
	private String bankName = "";
	
	private ArrayList<Account> acconts = new ArrayList<Account>();
	
	public static int numberOfBanks = 0;
	
	
	public BankComputer(String bankName) {
		this.bankName = bankName;	
		
		numberOfBanks++;
		
		this.bankID+=numberOfBanks;
	}
	
	public void addAcctToBank(Account newAccount){
		this.acconts.add(newAccount);
	}

	public boolean verifyTheStripNumber(Card theCard){
		
		boolean CardVerification = false;
		
		for(Account account: acconts){
			
			if(account.getStripNumber() == theCard.getStripNumber()){
				return true;
			}
			
		}
		return CardVerification;
	}

	


	public int getBankID() {
		return bankID;
	}

	public boolean verifyThePIN(Transaction transaction) {
		
		boolean cardVerification = false;
		
		if(transaction.getDidCardVerify()){
			for(Account accont : acconts){
				if((accont.getPin() == transaction.getPin()) && (accont.getStripNumber() == transaction.getStripNumber())){
					cardVerification = true;
					
					transaction.setCustomerName(accont.getCustomerName());
				}
			}
		}
		return cardVerification;
		
	}

	public void requestWithDravalAmoun(Transaction transaction) {
		
		for(Account account : acconts){
			if(account.getAcctNumber() == transaction.getAccountNumberUsed()){
				if(account.getAcctBalance() >= transaction.getAcctToWithdrawalFrom()){
					double newAccountBalance = account.getAcctBalance() -  transaction.getAcctToWithdrawalFrom();
					account.setAcctBalance(newAccountBalance);
					transaction.setAcctBalance(newAccountBalance);
					
				}else{
					System.out.println("You cant withdrawl that much money");
				}
			}
		}
		
	}

}
