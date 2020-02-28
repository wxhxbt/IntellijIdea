import java.util.*;

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        char[][] map = {{'S', 'O', 'O', 'S', 'S'},
                       {'D', 'O', 'D', 'O', 'D'},
                       {'O', 'O', 'O', 'O', 'X'},
                       {'X', 'D', 'D', 'O', 'O'},
                       {'X', 'D', 'D', 'D', 'O'}};
        System.out.println(treasureHunt2(map));
    }

    public static int treasureHunt2(char[][] map){
        if(map.length == 0 || map == null) return -1;
        int min = Integer.MAX_VALUE;
        List<int[]> startPoints = new ArrayList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0; i<map.length; i++)
            for(int j=0; j<map[0].length; j++)
                if(map[i][j] == 'S')
                    startPoints.add(new int[]{i, j, -1});
        for(int[] start : startPoints){
            // System.out.println(Arrays.toString(start));
            LinkedList<int[]> fringe = new LinkedList<>();
            char[][] map2 = new char[map.length][map[0].length];
            for(int i=0; i<map2.length; i++)
                map2[i] = map[i].clone();
            fringe.add(new int[]{start[0], start[1], 0});
            while(!fringe.isEmpty()){
                int[] cur = fringe.poll();
                if(map2[cur[0]][cur[1]] == 'X'){
                    start[2] = cur[2];
                    break;
                }
                map2[cur[0]][cur[1]] = 'D';
                for(int[] dir : dirs){
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    if(i>=0 && i<map2.length && j>=0 && j<map2[0].length && map2[i][j]!='D')
                        fringe.add(new int[]{i ,j, cur[2]+1});
                }
            }
            if(min > start[2])
                min = start[2];
            // System.out.println(min);
        }
        return min;
    }
}