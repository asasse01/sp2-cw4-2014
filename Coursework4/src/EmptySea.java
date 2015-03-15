/**
 * @author Abby Sassel
 * @since 22/12/14
 * 
 * SP2 Coursework 4
 * - Single player battleship game
 * - The computer places the ships, and the human attempts to sink them.
 */

public class EmptySea extends Ship {

    public EmptySea() {
        length = 1;
        hit = new boolean[]{false};
    }

    public @Override boolean shootAt(int row, int column) {
        return false;
    }

    public @Override boolean isSunk() {
        return false;
    }
    
    public @Override String getShipType() {
        return "empty sea";
    }

}