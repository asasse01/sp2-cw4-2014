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
        
        if(horizontal) {
        	//TODO refactor 
        	
            // checks whether ship goes off board - vertically
            if (row < 0 || row >= ocean.getMax()) {
            	ok = false;
            }
            
            // checks whether ship goes off board - horizontally
            if (column < 0 || column+this.length-1 >= ocean.getMax()) {
            	ok = false;
            }
            
            // checks overlap & perimeter
            for(int i = row-1; i < row+3; i++) {
            	for(int j = column-1; j < column+this.length+1; j++) {
            		if(ocean.isOccupied(i, j)) {
            			ok = false; 
            		}
            	}
            }

        } else {
        	
            // checks whether ship goes off board - vertically
            if (row < 0 || row+this.length-1 >= ocean.getMax()) {
            	ok = false;
            }
            
            // checks whether ship goes off board - horizontally
            if (column < 0 || column >= ocean.getMax()) {
            	ok = false;
            }
            
            // checks overlap & perimeter
            for(int i = row-1; i < row+this.length+1; i++) {
            	for(int j = column-1; j < column+3; j++) {
            		if(ocean.isOccupied(i, j)) {
            			ok = false; 
            		}
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
        	for (int i = 0; i < this.length; i++) {
        		if (this.isHorizontal()) {
	        		if (this.bowRow == row) {
	            		if (this.bowColumn+i == column) {
	            			this.hit[i] = true;
	            			shot = true;
	            		}
	        		}
            	} else if (this.bowColumn == column) {
            		if (this.bowRow+i == row) {
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
