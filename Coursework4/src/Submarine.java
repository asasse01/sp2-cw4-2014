/**
 * @author Abby Sassel
 * @since 22/12/14.
 */
public class Submarine extends Ship {

    public Submarine() {
        length = 1;
        hit = new boolean[]{false};
    }

    public @Override String getShipType() {
        return "submarine";
    }

}