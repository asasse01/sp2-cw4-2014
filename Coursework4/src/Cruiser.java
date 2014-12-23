/**
 * Created by abby on 22/12/14.
 */
public class Cruiser extends Ship {

    public Cruiser() {
        length = 3;
        hit = new boolean[]{false, false, false};
    }

    public @Override String getShipType() {
        return "cruiser";
    }

    public @Override String toString() {
        // TODO write method
    }
}