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

    public boolean shootAt(int row, int column) {
        boolean shot = false;
        if (!this.isSunk()) {
        	if ((this.isHorizontal() && this.bowRow == row) || this.bowColumn == column) {
        		//checks for collinearity
        		for (int i = 0; i < this.length; i++) {
        			if ((this.isHorizontal() && this.bowColumn+i == column) || this.bowRow+i == row) {
        				//checks length of ship
        				this.hit[i] = true;
        				shot = true;
        			} 
        		}
        	}
        }
        return shot;
    }

    public boolean isSunk() {
        boolean sunk = true;
        for (int i = 0; i < this.length; i++) {
        	if(!(this.hit[i])) {
        		sunk = false;
        	}
        }
        return sunk;
    }
    
    public @Override String toString() {
    	String string = ".";
    	if (this.isSunk()) {
			string = "x";
		} else for(int i = 0; i < this.length; i++) {
    		 if (this.hit[i]) {
    			string = "S";
    		}
    	}
    	
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

    public int getLength() {
        return length;
    }

    public String getShipType() {
        return "ship";
    }
}
