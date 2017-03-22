# MazeGenerator
A simple maze generator using an implemetion of Kruskal's algoritm and a Union-Find data structure.

**This was an entry to the Redgate coding challenge. It received an honourable mention from the Redgate engineering team.** [Redgate Blog](http://www.red-gate.com/blog/building/biggest-challenges-coding-can-also-entertaining) 

*"Dean’s implementation of Kruskal’s algorithm in terms of merge-find sets was nicely explained and a good implementation. Dean’s solution also has nice rendering – he was the only person to have customisable tiles."*

## How to run
* Run MazeTester.java
* Enter number of rows
* Enter number of cols

## Sample Output
<img src="https://raw.githubusercontent.com/Dean-Coakley/MazeGenerator/master/Maze.png">

### How Does It Work?
1. Intialiazes a matrix of m * n size. Every wall in every cell exists at the beginning.
2. All of the cells are dumped into a Union-Find data structure. Cells are disjointed when there are no paths connecting them to one another.
3. Random walls are then processed. 
  * If there exists a path from the cell on one side of the wall to the cell on the other side of the wall.
    * Do nothing.
  * Otherwise, remove the wall between those two cells and merge the cells in the Union-Find data structure.
4. Repeat Step 3 until there are no disjointed sets in the Union-Find data structure. At that point, every cell will be reachable from any other cell in the maze.
