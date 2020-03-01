import java.util.*;

// https://leetcode.com/discuss/interview-question/383669/
public class Main {
    public static void main(String[] args) {
        int[][] map = {{10, 7, 3},
                {12, 11, 7},
                {1, 2, 8}};
        System.out.println("BFS: "+MaxOfMinAltitudes(map));
        System.out.println("DP: "+DPsolution(map));
    }

    public static int MaxOfMinAltitudes(int[][] map){
        int[][] dirs = {{0, 1}, {1, 0}};
        int max = Integer.MIN_VALUE;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, Integer.MAX_VALUE});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            if(cur[0] == map.length - 1 && cur[1] == map[0].length - 1)
                max = Math.max(max, cur[2]);
            for(int[] dir :dirs){
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if(i>=0 && i<map.length && j>=0 && j<map[0].length)
                    if(i == map.length - 1 && j == map[0].length - 1)
                        que.add(new int[]{i, j, cur[2]});
                    else
                        que.add(new int[]{i, j, Math.min(cur[2], map[i][j])});
            }
        }
        return max;
    }

    public static int DPsolution(int[][] map){
        int[][] dp = new int[map.length][map[0].length];
        dp[0][0] = Integer.MAX_VALUE;
        for(int i=1; i<dp.length; i++)
            dp[i][0] = Math.min(map[i][0], dp[i-1][0]);
        for(int i=1; i<dp[0].length; i++)
            dp[0][i] = Math.min(map[0][i], dp[0][i-1]);
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(i == dp.length - 1 && j == dp[0].length - 1)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                else
                    dp[i][j] = Math.max(Math.min(dp[i-1][j], map[i][j]), Math.min(dp[i][j-1], map[i][j]));
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}