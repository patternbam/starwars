package nb.pattern.starwars.spaceShip.fighter;

import java.util.Observer;

import nb.pattern.starwars.message.Message;
import nb.pattern.starwars.spaceShip.SpaceShip;

public class Fighter implements SpaceShip {

	@Override
	public boolean fly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean landing() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean receiveOrder(Message message) {
		
		return false;
	}
}