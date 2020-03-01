import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 4}, {4, 5}, {2, 3}};
        int[][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        System.out.println(minCost(n, edges, newEdges));
    }

    public static int minCost(int n, int[][] edges, int[][] newEdges) {
        int cost = 0;
        UF uf = new UF(n + 1);
        for(int[] edge : edges)
            uf.union(edge[0], edge[1]);
        Queue<int[]> pq = new PriorityQueue<>((t1, t2) -> t1[2] - t2[2]);
        pq.addAll(Arrays.asList(newEdges));
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

class UF {
    private int[] parent;
    private byte[] rank;
    public int numOfSets;

    public UF(int n) {
        if(n < 0)   throw new IllegalArgumentException();
        parent = new int[n];
        rank = new byte[n];
        for(int i=0; i<n ;i++)
            parent[i] = i;
        numOfSets = n;
    }

    public int find(int p) {
        // Original find
        // while(parent[p] != p)
        //     p = parent[p];
        // return p;

        //find with Path Compression
        if(parent[p] != p){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public void union(int p, int q) {
        int rp = find(p);
        int rq = find(q);
        if(rp != rq){
            numOfSets--;
            if(rank[rp] > rank[rq])
                parent[rq] = rp;
            else if(rank[rp] < rank[rq])
                parent[rp] = rq;
            else{
                parent[rp] = rq;
                rank[rq]++;
            }
        }
    }
}
