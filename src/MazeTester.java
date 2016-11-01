
import java.util.Random;
import java.util.Scanner;

public final class MazeTester {

    private MazeTester() { }

    public static void main(String[] args) {
    	int rows = 0;
        int cols = 0;
        
    	Scanner kb = new Scanner(System.in);
    	
    	System.out.println("Enter number of rows");
    	if (kb.hasNextInt()) {
    		rows = kb.nextInt();
    		//Clear space from buffer
    		kb.nextLine();
    	}
    	else
    		System.out.println("Must be of type INT");
    	
    	System.out.println("Enter number of columns");
    	if (kb.hasNextInt()) {
    		cols = kb.nextInt();
    		//Clear space from buffer
    		kb.nextLine();
    	}
    	else
    		System.out.println("Must be of type INT");
    	kb.close();
    	

        
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Both arguments must be positive.");
        }
        
        /* Create new Maze. */
        Maze maze = new Maze(new Random(), rows, cols);
        
        /* Generate the maze. */
        maze.generateMaze();

        /* Display the generated maze in a separate window. */
        MazeRenderer renderer = new MazeRenderer(maze);
        renderer.createAndDisplayMaze();
    }

}