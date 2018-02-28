package ATMMashine;

public class Customer {

	private Card customersATMCard;

	public Customer(Card customersATMCard) {
		super();
		this.customersATMCard = customersATMCard;
	}

	public Card getCustomersATMCard() {
		return customersATMCard;
	}

	public void setCustomersATMCard(Card customersATMCard) {
		this.customersATMCard = customersATMCard;
	}
	
	
}
