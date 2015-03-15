/**
 * @author Abby Sassel
 * @since 22/12/14
 * 
 * SP2 Coursework 4
 * - Single player battleship game
 * - The computer places the ships, and the human attempts to sink them.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {

    Battleship b = new Battleship();
    Cruiser c = new Cruiser();
    Destroyer d = new Destroyer();
    Submarine s = new Submarine();
    EmptySea e  = new EmptySea();

    @Test
    public void testOkToPlaceShipAt() {
        Ocean ocean = new Ocean();

        // method calls should return true
        assertEquals(true, b.okToPlaceShipAt(0, 3, true, ocean));
        assertEquals(true, c.okToPlaceShipAt(7, 8, false, ocean));
        e.placeShipAt(5, 5, true, ocean);
        assertEquals(true, s.okToPlaceShipAt(5, 5, false, ocean));

        // method calls should return false
        assertEquals(false, d.okToPlaceShipAt(3, 9, true, ocean));

        b.placeShipAt(3, 4, true, ocean);
        assertEquals(false, s.okToPlaceShipAt(3, 6, true, ocean));
        assertEquals(false, s.okToPlaceShipAt(3, 5, true, ocean));
        
        c.placeShipAt(0, 1, false, ocean);
        assertEquals(false, s.okToPlaceShipAt(1, 1, true, ocean));
        assertEquals(false, s.okToPlaceShipAt(1, 2, true, ocean));

    }

    @Test
    public void testPlaceShipAt() throws Exception {
        Ocean ocean = new Ocean();

        b.placeShipAt(2, 2, true, ocean);
        assertEquals(2, b.getBowRow());
        assertEquals(2, b.getBowColumn());

        c.placeShipAt(5, 4, false, ocean);
        assertEquals(5, c.getBowRow());
        assertEquals(4, c.getBowColumn());

        s.placeShipAt(9, 9, true, ocean);
        assertEquals(9, s.getBowRow());
        assertEquals(9, s.getBowColumn());
    }

    @Test
    public void testShootAt() throws Exception {
        Ocean ocean = new Ocean();

        b.placeShipAt(2, 2, true, ocean);
        assertEquals(false, b.shootAt(3, 3));
        c.placeShipAt(1, 5, false, ocean);
        assertEquals(true, c.shootAt(2, 5));
        s.placeShipAt(6, 4, true, ocean);
        assertEquals(true, s.shootAt(6, 4));
        assertEquals(false, s.shootAt(6, 4));



    }
}