/**
 * Created by abby on 22/12/14.
 */
public class Submarine extends Ship {

    public Submarine() {
        length = 1;
        hit = new boolean[]{false};
    }

    public @Override String getShipType() {
        return "submarine";
    }

    public @Override String toString() {
        // TODO write method
    }
}