/**
 * Created by abby on 22/12/14.
 */
public class Ship {

    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal = true;
    String shipType;
    boolean[] hit;

    private boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        // TODO write method
        boolean ok = false;
        return ok;
    }

    private void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        // TODO write method
    }

    public boolean shootAt(int row, int column) {
        // TODO write method
        boolean shot = false;
        return shot;
    }

    public boolean isSunk() {
        // TODO write method
        boolean sunk = false;
        return sunk;
    }

    public int getBowRow() {
        return bowRow;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public int getLength() {
        return length;
    }

    public String getShipType() {
        return "ship";
    }
}
