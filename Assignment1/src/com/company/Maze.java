package com.company;
import java.util.Arrays;
import java.lang.Math;
import java.awt.*;
import java.util.Set;
import javax.swing.*;

public class Maze {
    //maze is a matrix of integer
    private int[][] maze = null;
    private int dim;
    private double p;

    public Maze(int dim, double p){
        this.dim = dim;
        this.p = p;
        this.maze = new int[dim][dim];
        for(int i=0; i<dim; i++)
            Arrays.fill(maze[i], -1);
    }

    void buildmaze(){
        for(int i=0; i<dim; i++){
            for(int j=0;j<dim; j++){
                double roll = Math.random();
                if(roll < p)
                    maze[i][j] = 1;
                else
                    maze[i][j] = 0;
            }
        }
        maze[0][0] = 0;
        maze[dim-1][dim-1] = 0;
    }

    void show(){
        for(int i=0; i<dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.printf("%d ", maze[i][j]);
            }
            System.out.println();
        }
    }

    void showsolution(final Set<Point> solution){
        MyGrid myGrid = new MyGrid(dim, maze,solution);
        myGrid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int[][] getMaze(){
        return this.maze;
    }

    public int getDim(){
        return this.dim;
    }

}

class MyGrid extends JFrame {
    int dim;
    int[][] matrix = null;
    Set<Point> solution = null;

    public MyGrid(int dim,  final int[][] maze, final Set<Point> solution)    {
        this.matrix = maze;
        this.dim = dim;
        this.solution = solution;
        setSize( 100+dim*30, 100+dim*30 );
        setVisible(true);
    }
    public void paint( Graphics g )
    {
        g.setColor(Color.red);
        for(Point i:solution){
            int x = (int)i.getX();
            int y = (int)i.getY();
            g.fillRect(30+y*30,60+x*30, 30, 30);
        }

        for( int i=0; i<dim; i++)
            for(int j=0; j<dim; j++){
                if(matrix[i][j] == 1){
                    g.setColor(Color.black);
                    g.fillRect(30+j*30,60+i*30, 30, 30);
                }
                g.setColor(Color.black);
                g.drawRect(30+i*30,60+j*30, 30, 30);
            }

    }

}