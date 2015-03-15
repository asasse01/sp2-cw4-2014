/**
 * @author Abby Sassel
 * @since 22/12/14
 * 
 * SP2 Coursework 4
 * - Single player battleship game
 * - The computer places the ships, and the human attempts to sink them.
 */

public class Cruiser extends Ship {

    public Cruiser() {
        length = 3;
        hit = new boolean[]{false, false, false};
    }

    public @Override String getShipType() {
        return "cruiser";
    }

}