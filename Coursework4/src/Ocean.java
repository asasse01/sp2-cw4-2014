/**
 * Created by abby on 22/12/14.
 */
public class Ocean {
    Ship[][] ships = new Ship[10][10];
    int shotsFired;
    int hitCount;
    int shipsSunk;

    public Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        EmptySea e = new EmptySea();

        for(int i = 0; i < ships.length; i++) {
            for(int j = 0; j < ships.length; j++) {
                ships[i][j] = e;
            }
        }

    }

    private void placeAllShipsRandomly() {
        // TODO write method
    }

    private boolean isOccupied(int row, int column) {
        // TODO write method
    }

    private boolean shootAt(int row, int column) {
        // TODO write method
    }

    private void print() {
        // TODO write method
    }

    public boolean isGameOver() {
        return (shipsSunk == 10);
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    public Ship[][] getShipArray() {
        return ships;
    }


}
