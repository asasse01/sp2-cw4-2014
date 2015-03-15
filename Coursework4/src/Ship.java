/**
 * @author Abby Sassel
 * @since 22/12/14
 * 
 * SP2 Coursework 4
 * - Single player battleship game
 * - The computer places the ships, and the human attempts to sink them.
 */

public class Ship {

    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal = true;
    boolean[] hit;

    /**
     * returns true if it is okay to put a ship of this length with its bow in this location
     * @param row stern row
     * @param column stern column
     * @param horizontal ship orientation
     * @ocean ocean to check
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        boolean ok = true;
        int[] limits;
        
        // sets perimeter limits to avoid duplication of loops
        if(horizontal) {
        	limits = new int[]{0, (this.length-1), 3, (this.length+1)};
        } else limits = new int[]{(this.length-1), 0, (this.length+1), 3};
        
    	// checks whether ship goes off board top/bottom 
        if (row < 0 || row+limits[0] >= ocean.getMax())
        	ok = false;
        
        // checks whether ship goes off board sides
        if (column < 0 || column+limits[1] >= ocean.getMax())
        	ok = false;
        
        // checks overlap & perimeter
        for(int i = row-1; i < row+limits[2]; i++) {
        	for(int j = column-1; j < column+limits[3]; j++) {
        		if(ocean.isOccupied(i, j)) {
        			ok = false; 
        		}
        	}
        }
        
        return ok;
    }

    /**
     * Puts the ship in the ocean. 
     * @param row game board y coordinate
     * @param column game board x coordinate
     * @param horizontal ship orientation
     * @ocean ocean to place ship in
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        setBowRow(row);
        setBowColumn(column);
        setHorizontal(horizontal);

        if (okToPlaceShipAt(row, column, horizontal, ocean)) {
	        
            for(int i = 0; i < this.length; i++) {
            	if(this.isHorizontal()) {
	            	ocean.getShipArray()[row][column+i] = this;
	            } else ocean.getShipArray()[row+i][column] = this;
	        }
        }
    }

    /**
     * marks part of the ship as hit, and returns true, otherwise false
     * @param row game board y coordinate
     * @param column game board x coordinate
     * @return
     */
    public boolean shootAt(int row, int column) {
        boolean shot = false;
        
        if (!this.isSunk()) {
        	//checks for collinearity
        	if (this.bowRow == row || this.bowColumn == column) {
				//checks length of ship for a hit, depending on orientation
        		for (int i = 0; i < this.length; i++) {
        			if ((this.isHorizontal() && this.bowColumn+i == column) || this.bowRow+i == row) {
        				this.hit[i] = true;
        				shot = true;
        			} 
        		}
        	}
        }
        return shot;
    }

    /**
     * return true if every part of the ship has been hit, false otherwise
     * @return sunk ship status
     */
    public boolean isSunk() {
        boolean sunk = true;
        for (int i = 0; i < this.length; i++) {
        	if(!(this.hit[i])) {
        		sunk = false;
        	}
        }
        return sunk;
    }
    
    /**
     * returns a single-character String to use in the Ocean’s print method
     * @return string
     */
    public @Override String toString() {
    	/* nb: "Use ’S’ to indicate a location fired upon and hit a ship" functionality
    	 * not included, as the requested implementation of ship hit status means that
    	 * the toString method would reveal the whole ship if any part of it is hit. 
    	 */
    	
    	String string;
    	
    	if (this.isSunk()) {
			string = "x";
		} else string = ".";
    	
    	return string;
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

    public String getShipType() {
        return "ship";
    }
}
