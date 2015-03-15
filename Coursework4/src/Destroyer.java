/**
 * @author Abby Sassel
 * @since 22/12/14
 * 
 * SP2 Coursework 4
 * - Single player battleship game
 * - The computer places the ships, and the human attempts to sink them.
 */

public class Destroyer extends Ship {

    public Destroyer() {
        length = 2;
        hit = new boolean[]{false, false};
    }

    public @Override String getShipType() {
        return "destroyer";
    }

}