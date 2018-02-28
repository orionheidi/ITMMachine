package ATMMashine;

public class Account {
	
	private int bankID;
	private int acctNumber;
	private String customerName;
	private String acctType;
	private double acctBalance = 10000;
	private int pin;
	private int stripNumber;
	
	static int accountNumberIncrementor = 100000;

	public Account(int bankID, String customerName, String acctType, double acctBalance, int pin) {
		super();
		this.bankID = bankID;
		this.customerName = customerName;
		this.acctType = acctType;
		this.acctBalance = acctBalance;
		this.pin = pin;
		
		this.stripNumber = generateStripNumber(bankID);
		
		this.acctNumber = generateAccountNumber(stripNumber, acctType);
	
		
	}
	
	

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public int getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
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

	public static int getAccountNumberIncrementor() {
		return accountNumberIncrementor;
	}

	public static void setAccountNumberIncrementor(int accountNumberIncrementor) {
		Account.accountNumberIncrementor = accountNumberIncrementor;
	}
	
	
	public int generateStripNumber(int bankID){
		
		accountNumberIncrementor++;
		
		int newStripNumber = (bankID * 1000000) + accountNumberIncrementor;
		return newStripNumber;
		
	}
	
	public int generateAccountNumber(int stripNumber, String acctType){
		
		if((acctType.startsWith("s")) || (acctType.startsWith("S"))){
		
				acctNumber = (stripNumber * 10) + 1;
								
	}else{
		
		acctNumber =(stripNumber * 10) + 2;
	}
		return acctNumber;
}
	
}