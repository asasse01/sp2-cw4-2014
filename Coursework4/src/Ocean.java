import java.util.Random;

/**
 * Created by abby on 22/12/14.
 */


public class Ocean {
	private static final int BOARDLENGTH = 10; // ocean length. Assumes board is square
	Ship[][] ships = new Ship[BOARDLENGTH][BOARDLENGTH];
    int shotsFired;
    int hitCount;
    int shipsSunk = 0;
    Random rand = new Random();


    public Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        ships = fillWithEmptySea(ships);

    }
    
    Ship[][] fillWithEmptySea(Ship[][] ships) {
        EmptySea e = new EmptySea();

        for(int i = 0; i < BOARDLENGTH; i++) {
            for(int j = 0; j < BOARDLENGTH; j++) {
                ships[i][j] = e;
            }
        }
        
        return ships;
    	
    }

    void placeAllShipsRandomly() {
		int row;
		int column;
		boolean horizontal;

		Ship[] fleet = new Ship[10];
		fleet = createFleet(fleet);

    	for(Ship ship : fleet) {
    		horizontal = rand.nextBoolean();
    		// generates random horizontal value
    		
    		do {
    			row = rand.nextInt(BOARDLENGTH);
    			column = rand.nextInt(BOARDLENGTH);
        		// generates random coordinate values
    			
    		} while (!(ship.okToPlaceShipAt(row, column, horizontal, this)));
    		
    		ship.placeShipAt(row, column, horizontal, this);
    	}
    }
    
    Ship[] createFleet(Ship[] fleet) {
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
    	return fleet;
    }

    boolean isOccupied(int row, int column) {
    	boolean occupied = false;
    	if (!(row < 0 || column < 0 || row >= BOARDLENGTH || column >= BOARDLENGTH)) {
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
    	System.out.println("  0 1 2 3 4 5 6 7 8 9");
    	// prints column numbers
    	for(int i = 0; i < BOARDLENGTH; i++) {
    		System.out.print(i);
    		// prints row numbers
			for(int j = 0; j < BOARDLENGTH; j++) {
				System.out.print( " " + ships[i][j].toString());
				// prints ship string
			}
			System.out.println();
		}
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
    
    Ship getShipAt(int x, int y) {
        return ships[x][y];
    }


}
