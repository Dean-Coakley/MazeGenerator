
//This class represents the walls inside each cell
public class Wall {

    private int row;
    private int col;

    //A char representing the orientation of the wall.
    private char orientation;

    //r= row, c= column
    public Wall(int r, int c, char orient) {
        this.row = r;
        this.col = c;
        this.orientation = orient;
    }

    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }

    public char getOrientation() {
        return this.orientation;
    }

}