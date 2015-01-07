/**
 * Created by abby on 22/12/14.
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