package ATMMashine;

import java.util.ArrayList;

public class BankNetwork {
	
	private ArrayList<BankComputer> banksInDataBase = new ArrayList<BankComputer>();
	
	public void addBankToNetwork(BankComputer newBank){
		this.banksInDataBase.add(newBank);
	}

	public boolean isATMCardsBankInNetwork(Card theCard) {
		
		boolean cardVerification = false;
		
		int cardBankID = getFirstTwoDigits(theCard.getStripNumber());
		
		for(BankComputer bank : banksInDataBase){
			if(bank.getBankID() == cardBankID){
				return true;
			}
		}
		
		return cardVerification;
	}

	public static int getFirstTwoDigits(int stripNumber) {
		
		String stringOfStrip = Integer.toString(stripNumber);
		
		int bankIDFromString = Integer.parseInt(stringOfStrip.substring(0,2));
		
		return bankIDFromString;
	}

	

	public boolean verifyThePin(Transaction transaction) {
		
		boolean cardVerification = false;
		
		if(transaction.getDidCardVerify()){
			
			for(BankComputer bank : banksInDataBase){
				
				if(bank.getBankID() == transaction.getBankID()){
					
					bank.verifyThePIN(transaction);
					
					cardVerification = true;
				}
				else{
					System.out.println("The card bank id doesnt match any in the sistem.");
				}
			}
			
		}
		
		return cardVerification;	
		
	}

	public void requestWithDravalAmount(Transaction transaction) {
		
		if(transaction.getDidCardVerify()){
			for(BankComputer bank : banksInDataBase){
				if(bank.getBankID() == transaction.getBankID()){
					bank.requestWithDravalAmoun(transaction);
				}
			}
		} else{
			System.out.println("An error ocure during the withdroval");
		}
		
	}

}
