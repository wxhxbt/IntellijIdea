import java.util.*;

//https://leetcode.com/discuss/interview-question/370157
public class Main {
    public static void main(String[] args){
        int[] arr = {1,2,1,2,3};
        int K = 2;
        System.out.println(subarraysWithKDistinct(arr, K));
    }
    //maintain a queue of size n, where n=K, K+1, ..., A.length   Inefficient!
    // public int subarraysWithKDistinct(int[] A, int K) {
    //     int res = 0;
    //     for(int size = K; size <= A.length; size++){
    //         Queue<Integer> que = new LinkedList<>();
    //         for(int i=0; i < A.length; i++){
    //             que.add(A[i]);
    //             if(que.size() > size)
    //                 que.poll();
    //             if(que.size() == size){
    //                 Set<Integer> set = new HashSet<>(que);
    //                 if(set.size() == K)
    //                     res++;
    //             }
    //         }
    //         que.clear();
    //     }
    //     return res;
    // }

    //sliding window with prefix number
    //if the unique value of the sliding window is K, then there are (prefix + 1) solutions
    //but if unique > k, prefix need to be clear. TIME: O(n) SPACE: O(n)
    public static int subarraysWithKDistinct(int[] A, int K) {
        int res = 0;
        int i = 0, j = 0, prefix = 0, unique = 0;
        int[] map = new int[A.length + 1];
        for(i = 0; i < A.length; i++){
            //first add a new element in the window. If it is new, the unique
            //numbers of the window add 1
            map[A[i]]++;
            if(map[A[i]] == 1)
                unique++;
            //second if the unique > K, we move j ahead in order to keep unique == K
            //and set prefix to 0 because the interruption of the new value.
            if(unique > K){
                map[A[j]]--;
                j++;
                unique--;
                prefix = 0;
            }
            //third keep A[j] to be unique in the window by move j ahead if map[A[j]] > 1
            //meanwhile increase prefix number
            while(map[A[j]] > 1){
                map[A[j]]--;
                j++;
                prefix++;
            }
            //Fourth check if unique values of the window is K and update the result
            if(unique == K)
                res += 1 + prefix;
        }
        return res;
    }
}
