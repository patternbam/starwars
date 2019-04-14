package nb.pattern.starwars.spaceShip.fighter.type;

import java.util.Observable;
import java.util.Observer;

import nb.pattern.starwars.constant.BroadcastTypeConstant;
import nb.pattern.starwars.message.Message;
import nb.pattern.starwars.spaceShip.fighter.Fighter;

public class X_Wing extends Fighter implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		receiveOrder((Message)arg);
		
	}
	
	@Override
	public boolean receiveOrder(Message order) {
		
		messageCheck(order);
		
		return true;
	}

	private void messageCheck(Message order) {
		if(BroadcastTypeConstant.INDIVIDUAL.equals(order.getBroadCastType())) {
			System.out.println("X-Wing. " + order.getMessage() + " copy that.");
			
		} else {
			// nothing
		}
	}
}
