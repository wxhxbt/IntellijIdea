package com.company;

import java.awt.*;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// build the maze with dimension dim and probability p;
        Maze maze = new Maze(20, 0.2);
        maze.buildmaze();
        maze.show();
        Solution sol = new Solution(maze.getMaze(),maze.getDim());
        Set<Point> solution = sol.DFS();
        if(solution != null){
            maze.showsolution(solution);
            for(Point i:solution){
                System.out.printf("x: %d, y: %d\n",(int)i.getX(),(int)i.getY());
            }
        }else
            System.out.println("There is no solution.");

    }
}
