package nb.pattern.starwars.spaceShip.motherShip;

import nb.pattern.starwars.constant.BroadcastTypeConstant;
import nb.pattern.starwars.constant.MessageOptionConstant;
import nb.pattern.starwars.message.Message;
import nb.pattern.starwars.spaceShip.fighter.type.X_Wing;
import nb.pattern.starwars.spaceShip.fighter.type.Y_Wing;

public class MotherShip {

	private MessageOptionConstant option;
	private BroadcastTypeConstant broadcast;

	private X_Wing xWing;
	private Y_Wing yWing;
	
	public boolean order(Message order) {
		
		messageValidation(order); 
		
		if(isBroadCast(order)) {
			sendOrderToAllFighters(order);
			
		} else if(isIndividual(order)) {
			if("X_Wing".equals(order.getFighter())) {
				xWing.receiveOrder(order);
				
			} else if("Y_Wing".equals(order.getFighter())) {
				yWing.receiveOrder(order);
				
			} else {
				throw new IllegalArgumentException("Unkwon fighter type.");
			}
			
		} else {
			
		}
		
		return true;
	}
	
	public boolean notice(Message message) {

		return true;
	}
	
	private void sendOrderToAllFighters(Message order) {
		xWing.receiveOrder(order);
		yWing.receiveOrder(order);
	}

	private boolean isIndividual(Message order) {
		return broadcast.INDIVIDUAL.equals(order.getBroadCastType());
	}

	private boolean isBroadCast(Message order) {
		return broadcast.BROADCAST.equals(order.getBroadCastType());
	}

	private void messageValidation(Message order) {
		if(null == order.getBroadCastType() || "".equals(order.getBroadCastType())) {
			throw new IllegalArgumentException("BroadCastType is not defined.");
		} else if (null == order.getOption() || "".equals(order.getOption())) {
			throw new IllegalArgumentException("MessageOption is not defined.");
		} else if (null == order.getMessage() || "".equals(order.getMessage())) {
			throw new IllegalArgumentException("Message is not defined.");
		}
	}
	
	public void setxWing(X_Wing xWing) {
		this.xWing = xWing;
	}

	public void setyWing(Y_Wing yWing) {
		this.yWing = yWing;
	}
}
