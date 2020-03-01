import java.util.*;

// https://leetcode.com/discuss/interview-question/506287/
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 2, 2, 1, 1, 2};
//         int[] arr = new int[]{1, 1, 1, 1, 1, 1};
        //  int[] arr = new int[20000];
        // for(int i=0; i<10000; i++){
        //     arr[2*i] = 1;
        //     arr[2*i+1] = 2;
        // }
        System.out.println(splitThreeSubarray(arr));
    }

    public static boolean splitThreeSubarray(int[] arr){
        if(arr.length < 5)  return false;
        int i = 0, j = arr.length - 1;
        int left = 0, right = 0, middle = 0;
        for(int k = i+1; k<j; k++)
            middle += arr[k];
        while(i < j - 1){
            if(left < middle && right < middle)
                if(left < right){
                    left += arr[i++];
                    middle -= arr[i];
                }
                else if(left > right){
                    right += arr[j--];
                    middle -= arr[j];
                }
                else{
                    left += arr[i++];
                    right += arr[j--];
                    middle -= (arr[i] + arr[j]);
                }
            else if(left == middle && middle == right)
                return true;
            else
                return false;
        }
        return false;
    }
}
