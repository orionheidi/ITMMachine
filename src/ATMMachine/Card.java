package ATMMashine;

public class Card {
	
	private int pin;
	private int stripNumber;
	
	public int getPin() {
		return pin;
	}
	
	public Card(int stripNumber) {
		super();
		this.stripNumber = stripNumber;
	}


	public Card(int pin, int stripNumber) {
		super();
		this.pin = pin;
		this.stripNumber = stripNumber;
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
	
	
	

}
