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

    void placeAllShipsRandomly() {
        // TODO write method
    }

    boolean isOccupied(int row, int column) {
        // TODO write method
    }

    boolean shootAt(int row, int column) {
        // TODO write method
    }

    void print() {
        // TODO write method
    }

    boolean isGameOver() {
        return (shipsSunk == 10);
    }

    int getShotsFired() {
        return shotsFired;
    }

    int getHitCount() {
        return hitCount;
    }

    int getShipsSunk() {
        return shipsSunk;
    }

    Ship[][] getShipArray() {
        return ships;
    }


}
