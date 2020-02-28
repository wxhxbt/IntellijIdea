import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] products = {"abc", "bcd", "fgh", "bcde", "bcf", "bcdz", "bcfgh"};
        String searchWord = "bcfg";
        for(List<String> item : suggestedProducts(products, searchWord))
            System.out.print(item);
        // TreeMap<String, Integer> map = new TreeMap<>();
        // Arrays.sort(products);
        // for (int i = 0; i < products.length; i++) {
        //       map.put(products[i], i);
        //   }
        // System.out.print(map.ceilingKey("c")+" "+map.floorKey("c"+'~'));
        // List<Object> productsl = Arrays.asList(products);
        // System.out.println(productsl.subList(3,3));
    }

    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        for(int i=0; i<products.length; i++)
            map.put(products[i], i);
        String pre = "";
        for (char c : searchWord.toCharArray()){
            pre += c;
            String ceiling = map.ceilingKey(pre);
            String floor = map.floorKey(pre+'~');
            if(ceiling == null || floor == null) break;
            res.add((Arrays.asList(products)).subList(map.get(ceiling), Math.min(map.get(ceiling)+3, map.get(floor)+1)));
        }
        while(res.size() < searchWord.length()) res.add(new ArrayList<String>());
        return res;
    }
}