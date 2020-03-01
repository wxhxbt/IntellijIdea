import java.util.*;

//https://leetcode.com/discuss/interview-question/370112
public class Main {
    public static void main(String[] args) {
        String s = "abcdefe";
        int K = 3;
        System.out.println(KuniqueSubstring(s, K));
    }

    public static List<String> KuniqueSubstring(String s, int K){
        if(s.length() < K || s == null) return null;
        int i = 0, j = 0, unique = 0;
        Set<String> set = new HashSet<>();
        int[] freq = new int[26];
        for(i = 0; i<s.length(); i++){
            if(freq[s.charAt(i)-'a']++ == 0)
                unique++;
            if(i-j+1 == K){
                if(unique == K)
                    set.add(s.substring(j, i+1));
                if(freq[s.charAt(j++)-'a']-- == 1)
                    unique--;
            }
        }
        return new ArrayList<>(set);
    }
}