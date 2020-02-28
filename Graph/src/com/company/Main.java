package com.company;

public class Main {

    public static void main(String[] args) {
	    int[][] a = new int[1][2];
	    a[0][0] = 1;
	    a[0][1] = 0;
	    boolean result = Solution.canFinish(2, a);
	    System.out.println(result);
    }
}

class Solution {
    public static int count = 0;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] marks = new boolean[numCourses];
        for(int i=0; i<numCourses; i++){
            marks[i] = false;
        }
        int[] pre = new int[numCourses];
        int[] post = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!marks[i])
                DFS(prerequisites, marks, i, pre, post);
        }
        for(int[] i:prerequisites){
            if(post[i[0]] >= post[i[1]])
                return false;
        }
        return true;
    }

    public static void DFS(int[][] prerequisites, boolean[] marks, int node, int[] pre, int[] post){
        marks[node] = true;
        count += 1;
        pre[node] = count;
        for(int[] i:prerequisites){
            if(i[1] == node){
                if(!marks[i[0]])
                    DFS(prerequisites, marks, i[0], pre, post);
            }
        }
        count += 1;
        post[node] = count;
    }
}