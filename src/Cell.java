
public class Cell {

    private boolean north; 
    private boolean east; 
    private boolean south; 
    private boolean west; 

    public Cell() {
        this.north = true;
	this.east = true;
        this.south = true;
        this.west = true;
        
    }
    
    /*
     n is true if north end of the tile has a wall
     s is true if south end of the tile has a wall
     (...)
    */
    public Cell(boolean n,boolean e, boolean s, boolean w) {
        this.north = n;
	this.east = e;
        this.south = s;
        this.west = w;
    }
    
//Getters
    
    //Returns true if the north wall exists
    public boolean hasNorth() {
        return this.north;
    }

    public boolean hasEast() {
        return this.east;
    }

    public boolean hasSouth() {
        return this.south;
    }

    public boolean hasWest() {
        return this.west;
    }

   
//Setters

    public void setNorth(boolean northVal) {
        this.north = northVal;
    }

    public void setSouth(boolean southVal) {
        this.south = southVal;
    }

    public void setWest(boolean westVal) {
        this.west = westVal;
    }

    public void setEast(boolean eastVal) {
        this.east = eastVal;
    }
}
