import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

// https://leetcode.com/discuss/interview-question/357310
public class Test {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 4}, {4, 5}, {2, 3}, {1, 2}, {1, 3}, {1, 6}, {5, 6}};
        int[][] edgesToRepair = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        System.out.println(minCostToConnect(n, edges, edgesToRepair));
    }

    public static int minCostToConnect(int n, int[][] edges, int[][] edgesToRepair){
        int cost = 0;
        UF uf = new UF(n + 1);
        //Trick : In order to hashset the edges, convert int[] to String
        Set<String> set = new HashSet<>();
        for(int[] edge : edgesToRepair){
            String s = edge[0] + "-" + edge[1];
            set.add(s);
        }
        for(int[] edge : edges){
            if(!set.contains(edge[0] + "-" + edge[1])){
                uf.union(edge[0], edge[1]);
            }
        }
        Queue<int[]> pq = new PriorityQueue<>((t1, t2) -> t1[2] - t2[2]);
        pq.addAll(Arrays.asList(edgesToRepair));
        while(!pq.isEmpty() && uf.numOfSets != 2){
            int[] cur = pq.poll();
            if(uf.find(cur[0]) != uf.find(cur[1])){
                uf.union(cur[0], cur[1]);
                cost += cur[2];
            }
        }
        return cost;
    }
}

