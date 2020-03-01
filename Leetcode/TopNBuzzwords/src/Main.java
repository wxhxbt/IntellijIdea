import java.util.*;

// https://leetcode.com/discuss/interview-question/460127/
public class Main {
    public static void main(String[] args) {
        System.out.println(
                topToys(6, 2, new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"}, 6,
                        new String[]{
                                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                                "The new Elmo dolls are super high quality",
                                "Expect the Elsa dolls to be very popular this year, Elsa!",
                                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                                "For parents of older kids, look into buying them a drone",
                                "Warcraft is slowly rising in popularity ahead of the holiday season"
                        }));
    }

    private static List<String> topToys(int numToys, int topToys, String[] toys, int numQuotes,
                                       String[] quotes) {
        Map<String, int[]> freq = new HashMap<>();
        for(String toy : toys){
            freq.put(toy, new int[]{0, 0});
        }
        for(String quote : quotes){
            Set<String> used = new HashSet<>();
            String[] words = quote.toLowerCase().split("\\W+");
            for(String word : words){
                if(!freq.containsKey(word)){
                    continue;
                }
                int[] num = freq.get(word);
                num[0]++;
                if(!used.contains(word))
                    num[1]++;
                used.add(word);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>((t1, t2) -> {
            if(freq.get(t1)[0] != freq.get(t2)[0])
                return freq.get(t1)[0] - freq.get(t2)[0];
            if(freq.get(t1)[1] != freq.get(t2)[1])
                return freq.get(t1)[1] - freq.get(t2)[1];
            return t2.compareTo(t1);
        });

        if(numToys < topToys){
            for(String toy : toys){
                if(freq.get(toy)[0] > 0)
                    pq.add(toy);
            }
        }
        else{
            for(String toy : toys){
                pq.add(toy);
                if(pq.size() > topToys)
                    pq.poll();
            }
        }
        List<String> output = new ArrayList<>();
        for(int i=0; i<topToys; i++){
            output.add(pq.poll());
        }
        Collections.reverse(output);
        return output;
    }
}
