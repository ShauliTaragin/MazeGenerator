<h3>Project review </h3>
<p>
Maze generator' is a simple program that (as suggested by its name) generates a random square maze in a pre-defined size.
</p>
  ***Authors : Shauli Taragin & Noam Vanunu***  
<hr>
<h4>Behind the scences</h4>
<p>
The project creates a Maze object which contains a 2D matrix of Graph nodes, each can connect to up to 4 of its neighbors (up, down, left, right), where 2 connected nodes means that there is
a path between them. <br>
We create a list containing all the legal edges in the graph, shuffle(to get a different maze each time) it and use our own modified version of Union-find to
union all of them until all the nodes are in the same set.<br>
This method insure that we have a path from the node that represents the entry to the one representing the exit
</p>



#### how to run the project

After you downloaded the code, compile and run the Maze class with 2 arguments - height and width, both integers.
For example, the command  <em>java Maze 25 25 </em> , will generate a 25 X 25 Maze.



#### UML digram

![alt text](https://github.com/noamv2/Directed-Graphs/blob/master/pics/cp.JPG)

#### Footage

<img src="https://github.com/noamv2/MazeGenerator/blob/main/pics/1010.jpg" width="300" height="300">
<img src="https://github.com/noamv2/MazeGenerator/blob/main/pics/1025.JPG" width="500" height="200">
<img src="https://github.com/noamv2/MazeGenerator/blob/main/pics/5050.jpg" width="400" height="400">


