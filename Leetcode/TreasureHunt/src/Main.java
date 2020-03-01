import java.util.*;

// https://leetcode.com/discuss/interview-question/347457
public class Main {
    public static void main(String[] args) {
        char[][] t_map = {{'O', 'O', 'O', 'O'},
                          {'D', 'O', 'D', 'O'},
                          {'O', 'O', 'D', 'O'},
                          {'O', 'D', 'X', 'O'}};
        System.out.println(treasureHunt(t_map));
    }

    public static int treasureHunt(char[][] t_map){
        if(t_map.length == 0)   return -1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        LinkedList<int[]> fringe = new LinkedList<>();
        // Set<int[]>
        fringe.add(new int[]{0, 0, 0});
        while(!fringe.isEmpty()){
            int[] cur = fringe.poll();
            if(t_map[cur[0]][cur[1]] == 'X')
                return cur[2];
            t_map[cur[0]][cur[1]] = 'D';
            for(int[] dir : dirs){
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if(i>=0 && i<t_map.length && j>=0 && j<t_map[0].length && t_map[i][j]!='D'){
                    fringe.add(new int[]{i, j, cur[2]+1});
                }
            }
        }
        return -1;
    }
}