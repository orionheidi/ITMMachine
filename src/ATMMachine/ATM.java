package ATMMashine;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class ATM {
	
	private Transaction transaction = null;
	private BankNetwork bankNetwork;
	
	static Scanner userInput = new Scanner(System.in);
	
	
	public ATM(BankNetwork bankNetwork) {
		super();
		this.bankNetwork = bankNetwork;
	}
	
	public boolean isStripReadable(Card theCard){
		
		int numberOfDigitsInStrip = (int)(Math.log10(theCard.getStripNumber()));
	
		transaction = new Transaction(theCard.getStripNumber());
		
		if(numberOfDigitsInStrip == 8){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isATMCardsBankInNetwork(Card theCard){
		
		if(bankNetwork.isATMCardsBankInNetwork(theCard)){
			transaction.setStripNumber(theCard.getStripNumber());
			transaction.setDidCardVerify(true);
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean insertPIN(Card card, int pin){
		
		int numberOfdigitsInPin = (int) (Math.log10(pin) + 1);
		
		if(numberOfdigitsInPin != 4){
			System.out.println("You have to enter 4 digits for a pin");
			return false;
		}
		else{
			transaction.setPin(pin);
			bankNetwork.verifyThePin(transaction);
			
		}
		return false;
		
	}

	public void pickAcctToAccess() {
		System.out.println("What account you want to withdrow from_");
		System.out.println("( 1 - Savings,  2 - Checking)");
		
		if(userInput.hasNextInt()){
			
			int numberEntered = userInput.nextInt();
			
			transaction.setAcctToWithdrawalFrom(numberEntered);
		}
		else{
			System.out.println("You entered an Invalid option. ");
		}
		
	}

	public void amountToWithdrawal() {
		
		System.out.println("How much you want to withdraval_");
		System.out.println("( Increments of 10)");
		
		if(userInput.hasNextInt()){
			
			int numberEntered = userInput.nextInt();
			
			transaction.setWithdrawalAmt(numberEntered);
			
			bankNetwork.requestWithDravalAmount(transaction);
		}
		else{
			System.out.println("You entered an Invalid amounth. ");
		}
		
	}

	public void getTransactionInfo() {
		
		System.out.println("Thank you " + transaction.getCustomerName() + " for using XYZ bank");
	
		System.out.println("Date / Time of Transaction " + transaction.getCurrentDateTime());
		
		System.out.println("\nTRANSACTION");
		
		System.out.println("Removed $ " + transaction.getWithdrawalAmt());
		
		if(transaction.getAcctToWithdrawalFrom() == 1){
			
			System.out.println("You remove form savings account. Your current balance is: " + transaction.getAcctBalance());
		} else{
			System.out.println("You remove form chekings account. Your current balance is: " + transaction.getAcctBalance());
		}
	}
	

}
