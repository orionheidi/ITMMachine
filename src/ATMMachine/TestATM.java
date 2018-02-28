package ATMMashine;

public class TestATM {

	public static void main(String[] args) {
		
		Account theAccount = new Account(10,"Darek Barns","C",10000,1234);
		
		Card custumerATMCard = new Card(theAccount.getPin(),theAccount.getStripNumber());
		
		Customer customer = new Customer(custumerATMCard);
		
		BankComputer bankComputer = new BankComputer("XYZ Bank");
		
		bankComputer.addAcctToBank(theAccount);
		
		BankNetwork bankNetwork = new BankNetwork();
		
		bankNetwork.addBankToNetwork(bankComputer);
		
		ATM atm = new ATM(bankNetwork);
		
		atm.isStripReadable(custumerATMCard);
		
		atm.isATMCardsBankInNetwork(custumerATMCard);
	
		atm.insertPIN(custumerATMCard, 1234);
		
		atm.pickAcctToAccess();
		
		atm.amountToWithdrawal();
		
		atm.getTransactionInfo();
		
		
		
		
	}

}
