import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for(int[] res : merge(intervals))
            System.out.print(Arrays.toString((res)));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)  return new int[0][0];
        List<int[]> res = new ArrayList<>();
        Comparator<int[]> mycomp = new Comparator<int[]>(){
            public int compare(int[] t1, int[] t2){
                return t1[0] - t2[0];
            }
        };
        // Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);   //slower than Override method
        Arrays.sort(intervals, mycomp);
        int start = intervals[0][0];
        int max = intervals[0][1];
        for (int[] interval : intervals) {
            if (max < interval[0]) {
                res.add(new int[]{start, max});
                start = interval[0];
                max = interval[1];
            } else
                max = Math.max(max, interval[1]);
        }
        res.add(new int[]{start, max});
        return res.toArray(new int[0][0]);
    }
}
