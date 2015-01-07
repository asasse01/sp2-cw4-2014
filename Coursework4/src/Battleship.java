/**
 * Created by abby on 22/12/14.
 */
public class Battleship extends Ship {

    public Battleship() {
        length = 4;
        hit = new boolean[]{false, false, false, false};
    }

    public @Override String getShipType() {
        return "battleship";
    }

}
