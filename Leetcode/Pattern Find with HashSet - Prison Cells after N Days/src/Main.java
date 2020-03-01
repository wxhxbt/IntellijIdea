import java.util.*;

//https://leetcode.com/problems/prison-cells-after-n-days/
public class Main {
    public static void main(String[] args){
        int[] Cells = {1,0,0,1,0,0,1,0};
        int N = 1000000000;
        System.out.println(Arrays.toString(prisonAfterNDays(Cells, N)));
    }

    //Intuition method will get RLE(Runtime Limit Exceeded) when N is big.
    //Try to find the pattern: next day is generated totally based on the current day.
    //So, if we have seen the generated state before, there is a loop. Just run (N % cycle) times to get the result.
    public static int[] prisonAfterNDays(int[] cells, int N) {
        int cycle = 0;
        boolean hasCycle = false;
        Set<String> set = new HashSet<>();
        int[] prev = cells.clone();
        for(int day=0; day<N; day++){
            int[] cur = next(prev);
            if(!set.contains(Arrays.toString(cur))){
                cycle++;
                set.add(Arrays.toString(cur));
            }
            else{
                hasCycle = true;
                break;
            }
            prev = cur;
        }
        if(hasCycle){
            for(int day=0; day < N % cycle; day++){
                prev = next(prev);
            }
        }
        return prev;
    }

    public static int[] next(int[] prev){
        int[] cur = new int[prev.length];
        for(int i=1; i<prev.length - 1; i++){
            cur[i] = prev[i-1] == prev[i+1]? 1:0;
        }
        return cur;
    }
}
