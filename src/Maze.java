
import java.util.Random;

public class Maze {

    private Cell[][] maze;
    private Random randNum;
    private Wall[] walls;

    public Maze(Random generator, int rows, int cols) {

        /* This is equivalent to 4 * AREA - PERIMETER. */
        int numWalls = 2 * rows * cols - rows - cols;

        this.maze = new Cell[rows][cols];
        this.walls = new Wall[numWalls];
        this.randNum = generator;

        int num = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.maze[i][j] = new Cell();
                if (i < rows - 1) {
                    this.walls[num++] = new Wall(i, j, 'h');
                }
                if (j < cols - 1) {
                    this.walls[num++] = new Wall(i, j, 'v');
                }
            }
        }

    }

    public void generateMaze() {

        int rows = this.getNumRows();
        int cols = this.getNumCols();

        /* Sets a starting point and ending point in the maze. */
        this.maze[0][0].setWest(false);
        this.maze[rows - 1][cols - 1].setEast(false);

        /* The number of cells in the maze. */
        int numCells = rows * cols;

        FindMerge allMerges = new FindMerge(numCells);

        /* While there are more than two subsets in the maze, remove walls. */
        while (allMerges.getNoSubsets() > 1) {

            /* Find a random wall in the array of walls. */
            Wall randWall = this.walls[this.randNum.nextInt(this.walls.length)];

            int row = randWall.getRow();
            int col = randWall.getCol();
            int aCell = row * cols + col;

            /* orientation is horizontal. */
            if (randWall.getOrientation() == 'h') {

                int bCell = (row + 1) * cols + col;

                /* If there is no path between the cells, knock down a wall. */
                if (allMerges.find(aCell) != allMerges.find(bCell)) {
                    this.maze[row][col].setSouth(false);
                    this.maze[row + 1][col].setNorth(false);
                    allMerges.merge(aCell, bCell);
                }

            } else /* orientation is vertical */ {

                int bCell = row * cols + col + 1;

                /* If there is no path between the cells, knock down a wall. */
                if (allMerges.find(aCell) != allMerges.find(bCell)) {
                    this.maze[row][col].setEast(false);
                    this.maze[row][col + 1].setWest(false);
                    allMerges.merge(aCell, bCell);
                }

            }
        }
    }
    
    public Cell getCellAt(int r, int c) {
        return this.maze[r][c];
    }

    public void setCellAt(int r, int c, Cell cell) {
        this.maze[r][c] = cell;
    }

    public int getNumRows() {
        return this.maze.length;
    }

    public int getNumCols() {
        return this.maze[0].length;
    }

}
