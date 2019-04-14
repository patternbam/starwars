package nb.pattern.starwars.message;

public class Message {

	private String broadcastType;
	private String option;
	private String fighter;
	private String message;
	
	public Message(String broadcastType, String option, String message) {
		super();
		this.broadcastType = broadcastType;
		this.option = option;
		this.message = message;
	}

	public Message(String broadcastType, String option, String fighter, String message) {
		super();
		this.broadcastType = broadcastType;
		this.option = option;
		this.fighter = fighter;
		this.message = message;
	}
	
	public String getBroadCastType() {
		return broadcastType;
	}	
	
	public String getOption() {
		return option;
	}

	public String getFighter() {
		return fighter;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Message [broadcastType=" + broadcastType + ", option=" + option + ", message=" + message + "]";
	}
}