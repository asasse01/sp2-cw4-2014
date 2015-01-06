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

		Ocean ocean = new Ocean();
		int emptySeaCount = (ocean.ships.length)*(ocean.ships[0].length); 
		
		// tests number of empty sea units in a 10 x 10 board
		assertEquals(100, emptySeaCount);
		
		ocean.placeAllShipsRandomly();
		for(int i = 0; i < ocean.ships.length; i++) {
			for(int j = 0; j < ocean.ships.length; j++) {
				if (ocean.ships[i][j] != e) {
					emptySeaCount--;
				}
			}
		}
		
		// tests number once fleet discounted
		assertEquals(80, emptySeaCount);
		
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
