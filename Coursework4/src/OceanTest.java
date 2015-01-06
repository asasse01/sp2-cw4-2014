import static org.junit.Assert.*;

import org.junit.Test;


public class OceanTest {
	
    Battleship b = new Battleship();
    Cruiser c = new Cruiser();
    Destroyer d = new Destroyer();
    Submarine s = new Submarine();
    EmptySea e  = new EmptySea();

	@Test
	public void testPlaceAllShipsRandomly() {
		fail("Not yet implemented");

		
	}

	@Test
	public void testIsOccupied() {
		fail("Not yet implemented");

		Ocean ocean = new Ocean();
        assertEquals(false, ocean.isOccupied(0, 3));
		b.placeShipAt(0, 0, true, ocean);
        assertEquals(true, ocean.isOccupied(0, 3));
        
        assertEquals(false, ocean.isOccupied(7, 3));
        e.placeShipAt(7, 3, true, ocean);
        assertEquals(false, ocean.isOccupied(7, 3));

	}

	@Test
	public void testShootAt() {
		fail("Not yet implemented");
	}
	
	

}
