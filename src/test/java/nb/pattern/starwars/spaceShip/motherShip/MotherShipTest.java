package nb.pattern.starwars.spaceShip.motherShip;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import nb.pattern.starwars.constant.BroadcastTypeConstant;
import nb.pattern.starwars.constant.MessageOptionConstant;
import nb.pattern.starwars.message.Message;
import nb.pattern.starwars.message.Notice;
import nb.pattern.starwars.message.Order;
import nb.pattern.starwars.spaceShip.fighter.type.B_Wing;
import nb.pattern.starwars.spaceShip.fighter.type.MillenniumFalcon;
import nb.pattern.starwars.spaceShip.fighter.type.StarFighter;
import nb.pattern.starwars.spaceShip.fighter.type.X_Wing;
import nb.pattern.starwars.spaceShip.fighter.type.Y_Wing;

public class MotherShipTest {

	private Message message;
	private MessageOptionConstant option;
	private BroadcastTypeConstant broadcast;

	private MotherShip motherShip = new MotherShip();;
	private X_Wing xWing = new X_Wing();
	private Y_Wing yWing = new Y_Wing();
	private B_Wing bWing = new B_Wing();
	private StarFighter starFighter = new StarFighter();
	private MillenniumFalcon millenniumFalcon = new MillenniumFalcon();
	
	@Before
	public void setup() {
		motherShip.setxWing(xWing);
		motherShip.setyWing(yWing);
		
		motherShip.addObserver(xWing);
		motherShip.addObserver(yWing);
		motherShip.addObserver(bWing);
		motherShip.addObserver(starFighter);
		motherShip.addObserver(millenniumFalcon);
	}

	@Test
	public void motherShip_생성자() {
		assertNotNull(motherShip);
	}

	@Test
	public void motherShip_출격명령() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, option.SORTIE, "Sortie to 306 disctict.");

		// act
		boolean response = motherShip.order(message);

		// assert
		assertThat(response, is(true));

	}

	@Test
	public void motherShip_귀환명령() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, option.RETURN, "Return to mothership.");

		// act
		boolean response = motherShip.order(message);

		// assert
		assertThat(response, is(true));
	}

	@Test
	public void motherShip_공지사항() {

		// arrange
		Message message = new Notice(broadcast.BROADCAST, option.NOTICE, "Engagement in the 306.");

		// act
		boolean response = motherShip.notice(message);

		// assert
		assertThat(response, is(true));
	}

	@Test
	public void motherShip_공격명령() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, option.ATTACK, "ATTACK 306.");

		// act
		boolean response = motherShip.order(message);

		// assert
		assertThat(response, is(true));

	}

	@Test
	public void motherShip_파이터_전체에게_공격중지방송() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, option.CEASE_FIRE, "Cease Fire.");

		// act
		boolean response = motherShip.order(message);

		// assert
		assertThat(response, is(true));
	}

	@Test
	public void messageType이_null일경우_IllegalArgumentException() {

		// arrange
		Message message = new Order(null, option.CEASE_FIRE, "Cease Fire.");

		try {
			// act
			boolean response = motherShip.order(message);

		} catch (IllegalArgumentException e) {
			// assert
			assertThat(e.getMessage(), is("BroadCastType is not defined."));
		}

	}

	@Test
	public void messageType이_빈문자열일경우_IllegalArgumentException() {

		// arrange
		Message message = new Order("", option.CEASE_FIRE, "Cease Fire.");

		try {
			// act
			boolean response = motherShip.order(message);

		} catch (IllegalArgumentException e) {
			// assert
			assertThat(e.getMessage(), is("BroadCastType is not defined."));
		}

	}

	@Test
	public void messageOption이_null일경우_IllegalArgumentException() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, null, "Cease Fire.");

		try {
			// act
			boolean response = motherShip.order(message);

		} catch (IllegalArgumentException e) {
			// assert
			assertThat(e.getMessage(), is("MessageOption is not defined."));
		}

	}

	@Test
	public void messageOption이_빈문자열일경우_IllegalArgumentException() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, null, "Cease Fire.");

		try {
			// act
			boolean response = motherShip.order(message);

		} catch (IllegalArgumentException e) {
			// assert
			assertThat(e.getMessage(), is("MessageOption is not defined."));
		}

	}

	@Test
	public void message가_null일경우_IllegalArgumentException() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, option.ATTACK, null);

		try {
			// act
			boolean response = motherShip.order(message);

		} catch (IllegalArgumentException e) {
			// assert
			assertThat(e.getMessage(), is("Message is not defined."));
		}

	}

	@Test
	public void message가_빈문자열일경우_IllegalArgumentException() {

		// arrange
		Message message = new Order(broadcast.BROADCAST, option.ATTACK, "");

		try {
			// act
			boolean response = motherShip.order(message);
			fail();
			
		} catch (IllegalArgumentException e) {
			// assert
			assertThat(e.getMessage(), is("Message is not defined."));
		}

	}

	@Test
	public void motherShip_특정_파이터와_통신() {

		// arrange
		Message message = new Order(broadcast.INDIVIDUAL, option.ATTACK, "X_Wing", "Attack 306.");

		// act
		boolean response = motherShip.order(message);
		
		// assert
	}

}