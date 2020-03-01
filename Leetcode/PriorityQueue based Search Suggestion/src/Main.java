import java.util.*;

// https://leetcode.com/problems/search-suggestions-system/
public class Main {
    public static void main(String[] args) {
        String[] products = {"bags","bag","baggage"};
        String searchWord = "bags";
        System.out.println(suggestedProducts(products, searchWord));
    }
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) ->{
            return t2.compareTo(t1);
        });
        String pre = "";
        for(char c : searchWord.toCharArray()){
            List<String> line = new ArrayList<>();
            pre += c;
            pq.clear();
            for(String product : products){
                if(product.startsWith(pre)){
                    pq.add(product);
                }
                if(pq.size() > 3)
                    pq.poll();
            }
            while(!pq.isEmpty())
                line.add(pq.poll());
            Collections.reverse(line);
            res.add(line);
        }
        return res;
    }
}