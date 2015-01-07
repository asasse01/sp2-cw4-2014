/**
 * Created by abby on 22/12/14.
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

}