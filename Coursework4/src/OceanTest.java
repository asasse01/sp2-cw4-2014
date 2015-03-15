/**
 * @author Abby Sassel
 * @since 22/12/14.
 */
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

		Ocean ocean = new Ocean();
		int emptySeaCount = (ocean.getMax())*(ocean.getMax()); 
		
		// tests number of empty sea units in a 10 x 10 board
		assertEquals(100, emptySeaCount);
		
		ocean.placeAllShipsRandomly();
		for(int i = 0; i < ocean.getMax(); i++) {
			for(int j = 0; j < ocean.getMax(); j++) {
				if (!(ocean.ships[i][j] instanceof EmptySea)) {
					emptySeaCount--;
				}
			}
		}

		// tests number once fleet discounted
		assertEquals(80, emptySeaCount);
		
	}

	@Test
	public void testIsOccupied() {

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
		
		Ocean ocean = new Ocean();
		
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());

		d.placeShipAt(3, 2, false, ocean);
		ocean.shootAt(3, 2);
        assertEquals(1, ocean.getHitCount());
        
		ocean.shootAt(4, 2);
        assertEquals(2, ocean.getHitCount());
        assertEquals(1, ocean.getShipsSunk());

	}
	
	

}
