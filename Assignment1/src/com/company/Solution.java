package com.company;
import java.awt.Point;
import java.util.*;

public class Solution {
    int[][] maze = null;
    int dim;

    public Solution(final int[][] maze, int dim){
        this.maze = maze;
        this.dim = dim;
    }

    public Set<Point> DFS(){
        Point curPos = new Point(0,0);
        Point goal = new Point(dim-1,dim-1);
        Stack<Point> fringe = new Stack<Point>();
        Set<Point> closet = new HashSet<Point>();
        Map<Point,Point> solution = new HashMap<Point,Point>();
        Set<Point> final_sol = new HashSet<Point>();
        fringe.push(curPos);
        solution.put(curPos,null);

        while (!fringe.empty()){
            curPos = fringe.pop();
            if(!closet.contains(curPos)){
                if(curPos.equals(goal)){
                    final_sol.add(curPos);
                    Point parent = solution.get(curPos);
                    while (parent!= null){
                        final_sol.add(parent);
                        parent = solution.get(parent);
                    }
                    return final_sol;
                }
                Point down = new Point(curPos);
                down.translate(1,0);
                if(!isInRestrictedStates(down) && !closet.contains(down)){
                    fringe.push(down);
                    solution.put(down,curPos);
                }
                Point up = new Point(curPos);
                up.translate(-1,0);
                if(!isInRestrictedStates(up) && !closet.contains(up)){
                    fringe.push(up);
                    solution.put(up,curPos);
                }
                Point right = new Point(curPos);
                right.translate(0,1);
                if(!isInRestrictedStates(right) && !closet.contains(right)){
                    fringe.push(right);
                    solution.put(right,curPos);
                }
                Point left = new Point(curPos);
                left.translate(0,-1);
                if(!isInRestrictedStates(left) && !closet.contains(left)){
                    fringe.push(left);
                    solution.put(left,curPos);
                }
                closet.add(curPos);
            }
        }
        //System.out.printf("x: %d, y: %d",(int)curPos.getX(),(int)curPos.getY());
        return null;
    }

    boolean isInRestrictedStates(final Point curPos){
        int x = (int)curPos.getX();
        int y = (int)curPos.getY();
        if(x < 0 || x >= dim || y < 0 || y >= dim){
            return true;
        }else{
            if(maze[x][y] == 1) return true;
            else return false;
        }
    }
}
