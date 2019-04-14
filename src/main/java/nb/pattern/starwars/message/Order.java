package nb.pattern.starwars.message;

public class Order extends Message {

	public Order(String type, String option, String title) {
		super(type, option, title);
	}
	
	public Order(String type, String option, String fighter, String title) {
		super(type, option, fighter, title);
	}
}
