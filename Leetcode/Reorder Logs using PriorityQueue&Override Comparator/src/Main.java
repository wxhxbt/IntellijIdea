import java.util.*;

// https://leetcode.com/problems/reorder-data-in-log-files/
public class Main {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        // System.out.println(Arrays.asList(reorderLogFiles(logs)));
        System.out.println(Arrays.asList(reorderLogFiles2(logs)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        if(logs.length == 0) return logs;
        List<String> digit = new ArrayList<>();
        String[] res = new String[logs.length];
        // List<List<String>> letter = new ArrayList<>();
        PriorityQueue<List<String>> pq = new PriorityQueue<>((t1, t2) -> {
            int result = t1.get(1).compareTo(t2.get(1));
            if(result != 0)
                return result;
            else
                return t1.get(0).compareTo(t2.get(0));
        });
        for(int i=0; i<logs.length; i++){
            List<String> log = Arrays.asList(logs[i].split(" ",2));
            // System.out.println(log.get(1).charAt(0));
            if(log.get(1).charAt(0) >= 'a')
                pq.add(log);
            else
                digit.add(logs[i]);
        }
        int i = 0;
        for(i=0; !pq.isEmpty(); i++){
            List<String> temp = pq.poll();
            res[i] = temp.get(0) + ' ' + temp.get(1);
        }
        for(int j=0; j<digit.size(); j++){
            res[j+i] = digit.get(j);
        }
        return res;
    }
    //Override the comparator directly
    public static String[] reorderLogFiles2(String[] logs) {
        Comparator<String> mycomp = new Comparator<String>(){

            @Override
            public int compare(String s1, String s2){
                int firstSpace1 = s1.indexOf(' ');
                int firstSpace2 = s2.indexOf(' ');
                // System.out.println(s1.charAt(firstSpace1+1)+" "+s2.charAt(firstSpace2+1));
                char c1 = s1.charAt(firstSpace1+1);
                char c2 = s2.charAt(firstSpace2+1);
                if(c1 <= '9'){
                    if(c2 <= '9')   return 0;
                    else    return 1;
                }
                if(c2 <= '9')   return -1;
                int result = s1.substring(firstSpace1+1).compareTo(s2.substring(firstSpace2+1));
                if(result!=0)   return result;
                else
                    return s1.substring(0, firstSpace1).compareTo(s2.substring(0, firstSpace2));
            }
        };
        Arrays.sort(logs, mycomp);
        return logs;
    }
}
