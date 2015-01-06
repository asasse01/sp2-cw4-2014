import java.util.Random;

/**
 * Created by abby on 22/12/14.
 */
public class Ocean {
    Ship[][] ships = new Ship[10][10];
    int shotsFired;
    int hitCount;
    int shipsSunk = 0;
    final int MAX = ships.length; // ocean border. Assumes board is square
    Random rand = new Random();


    public Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        EmptySea e = new EmptySea();

        for(int i = 0; i < MAX; i++) {
            for(int j = 0; j < MAX; j++) {
                ships[i][j] = e;
            }
        }

    }

    void placeAllShipsRandomly() {
		int row;
		int column;
		boolean horizontal;

		
    	Ship[] fleet = new Ship[10];
    	fleet[0] = new Battleship();
    	fleet[1] = new Cruiser();
    	fleet[2] = new Cruiser();
    	fleet[3] = new Destroyer();
    	fleet[4] = new Destroyer();
    	fleet[5] = new Destroyer();
    	fleet[6] = new Submarine();
    	fleet[7] = new Submarine();
    	fleet[8] = new Submarine();
    	fleet[9] = new Submarine();

    	for(Ship ship : fleet) {
    		horizontal = rand.nextBoolean();
    		
    		do {
    			row = rand.nextInt(MAX + 1);
    			column = rand.nextInt(MAX + 1);
    			
    		} while (!(ship.okToPlaceShipAt(row, column, horizontal, this)));
    		
    		ship.placeShipAt(row, column, horizontal, this);
    	}
    }

    boolean isOccupied(int row, int column) {
    	boolean occupied = false;
    	if (!(row < 0 || column < 0 || row > MAX || column > MAX)) {
    		// if the area is not off the board - for checking ship perimeter in okToPlaceAt
	    	if (!(ships[row][column] instanceof EmptySea)) {
	    		occupied = true;
	    	}
    	}
    	
    	return occupied;
    }

    boolean shootAt(int row, int column) {
    	boolean shot = false;
    	Ship target;
    	shotsFired++;
        if (this.isOccupied(row, column) && !(this.ships[row][column].isSunk())) {
        	target = ships[row][column];
        	shot = target.shootAt(row, column);
        	hitCount++;
        	if(this.ships[row][column].isSunk()) {
            	shipsSunk++;
            }
        } 
        
        return shot;
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
