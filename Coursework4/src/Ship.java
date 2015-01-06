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
//    	TODO refactor loops
        if(horizontal) {
            for(int j = column-1; j < this.length+1; j++) {
            	// checks overlap with any other ship & surrounding space
                if (ocean.isOccupied(row, j) || ocean.isOccupied(row-1, j) || ocean.isOccupied(row+1, j)) {
                    ok = false;
                }
	            // checks whether ship goes off board - vertically
	            if (row < 0 || row > ocean.getShipArray()[column].length) {
	            	ok = false;
	            }
	            // checks whether ship goes off board - horizontally
	            // accounts for space at bow and stern
	            if (j < -1 || j > ocean.getShipArray().length+1) {
	            	ok = false;
	            }
            }
        } else {
        	for(int i = row-1; i < this.length+1; i++) {
        		// checks overlap with any other ship & surrounding space
	            if (ocean.isOccupied(i, column) || ocean.isOccupied(i, column-1) || ocean.isOccupied(i, column+1))  {
	                ok = false;
	            }
	            // checks whether ship goes off board - vertically
	            // accounts for space at bow and stern
	            if (i < -1 || i > ocean.getShipArray()[column].length+1) {
	            	ok = false;
	            }
	            // checks whether ship goes off board - horizontally
	            if (column < 0 || column > ocean.getShipArray().length) {
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
	            	ocean.ships[row][column+i] = this;
	            } else ocean.ships[row+i][column] = this;
	        }
        }
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
