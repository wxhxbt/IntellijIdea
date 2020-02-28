import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        List<Integer> ropes = Arrays.asList(new Integer[]{2, 2, 3, 3});
        System.out.println(minCost(ropes));
    }

    public static int minCost(List<Integer> ropes) {
        if(ropes.size() == 0) return 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(ropes);
        Integer sum = 0;
        while(que.size() > 1){
            Integer r1 = que.poll();
            Integer r2 = que.poll();
            sum += (r1 + r2);
            que.add(r1 + r2);
        }
        return sum;
    }
}