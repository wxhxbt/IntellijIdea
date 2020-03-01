import java.util.*;

// https://leetcode.com/discuss/interview-question/411357/
public class Main {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 0, 1 },
                           { 0, 1, 0, 1, 0 },
                           { 0, 0, 0, 0, 1 },
                           { 0, 1, 0, 0, 0 } };
        System.out.println(solution(matrix));
    }

    private static int solution(int[][] matrix){
        //use dirs to simplify the code for the movement.
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int zomb = 0, target = matrix.length * matrix[0].length;
        //use LinkedList as a Queue to run BFS
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<matrix.length; i++)
            for(int j=0; j<matrix[0].length; j++)
                if(matrix[i][j] == 1){
                    q.add(new int[]{i, j});
                    zomb++;
                }
        if(q.isEmpty())
            return -1;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            // "if" can not be in the for loop, since it will return in the middle of the second loop while time is still 1.
            if(zomb == target)
                return time;
            for(int i=0; i<size; i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni>=0 && ni<matrix.length && nj>=0 && nj<matrix[0].length && matrix[ni][nj] == 0){
                        q.add(new int[]{ni, nj});
                        matrix[ni][nj] = 1;
                        zomb++;
                    }
                }
            }
            time++;
        }
        return -1;

    }
}