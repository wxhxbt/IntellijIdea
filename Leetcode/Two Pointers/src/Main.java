import java.util.*;

// https://leetcode.com/discuss/interview-question/373202
public class Main {
    public static void main(String[] args) {
        List<int[]> a = Arrays.asList(new int[][]{{1, 8}, {2, 15}, {3, 9}});
        List<int[]> b = Arrays.asList(new int[][]{{1, 8}, {2, 11}, {3, 12}});
        int target = 20;
        // System.out.println(Arrays.toString(a.get(1)));
        List<int[]> res = getPairs(a, b, target);
        for(int[] x : res)
            System.out.println(Arrays.toString(x));
        // System.out.println(res.size());
    }

    private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        List<int[]> res = new ArrayList<>();
        Collections.sort(a, (i,j) -> {return i[1] - j[1];});
        Collections.sort(b, (i,j) -> {return i[1] - j[1];});
        int i = 0, j = b.size() - 1;
        int max = Integer.MIN_VALUE;
        while(i < a.size() && j >= 0){
            int sum = a.get(i)[1] + b.get(j)[1];
            if(sum > target)
                j -= 1;
            else{
                if(sum >= max){
                    if(sum > max){
                        max = sum;
                        res.clear();
                    }
                    res.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j - 1;
                    while(index >=0 && b.get(index)[1] == b.get(index+1)[1])
                        res.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                }
                i++;
            }
        }
        return res;
    }
}