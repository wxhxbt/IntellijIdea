import java.util.*;
public class Main {
    public static void main(String[] args){
        String S = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(S));
    }

    public static List<Integer> partitionLabels(String S){
        int[] lastPositon = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<S.length(); i++)
            lastPositon[S.charAt(i) - 'a'] = i;
        int start = 0, end = 0;
        for(int i=0; i<S.length(); i++){
            end = Math.max(end, lastPositon[S.charAt(i) - 'a']);
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
