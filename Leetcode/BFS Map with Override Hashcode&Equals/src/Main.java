import java.util.*;

// https://leetcode.com/problems/number-of-islands/
public class Main {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','0','1'},
                         {'1','1','0','1','1'},
                         {'1','0','0','0','0'},
                         {'0','1','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        HashMap<Mycor, Boolean> ones = new HashMap<>();
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++ )
                if(grid[i][j] == '1')
                    ones.put(new Mycor(i, j), false);
        if(ones.isEmpty()) return 0;
        LinkedList<Mycor> que = new LinkedList<>();
        int islands = 0;
        for(Mycor cor : ones.keySet()){
            // System.out.println(cor.i+" "+cor.j);
            if(!ones.containsValue(false))
                return islands;
            if(ones.get(cor))  continue;
            que.add(cor);
            int k=0;
            while(!que.isEmpty()){
                Mycor pos = que.poll();
                ones.put(pos, true);
                for(int[] dir : dirs){
                    int i = pos.i+dir[0], j = pos.j+dir[1];
                    if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == '1' ){
                        Mycor newpos = new Mycor(i, j);
                        if(!ones.get(newpos))
                            que.add(newpos);
                    }
                }
            }
            islands += 1;
        }
        return islands;
    }
}

class Mycor {
    int i;
    int j;
    Mycor(int i, int j){
        this.i = i;
        this.j = j;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || obj.getClass()!= this.getClass())
            return false;
        Mycor cor = (Mycor) obj;
        return (this.i==cor.i && this.j==cor.j);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }


}