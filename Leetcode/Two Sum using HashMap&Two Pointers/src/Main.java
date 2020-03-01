import java.util.*;

// https://leetcode.com/discuss/interview-question/356960
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 10, 25, 35, 60};
        int target1 = 90;
        System.out.println(Arrays.toString(Find2Sum2(nums1, target1)));
        int[] nums2 = {20, 50, 40, 25, 30, 10};
        int target2 = 90;
        System.out.println(Arrays.toString(Find2Sum2(nums2, target2)));
        int[] nums3 = {50, 20, 10, 40, 25, 30};
        int target3 = 90;
        System.out.println(Arrays.toString(Find2Sum2(nums3, target3)));
        int[] nums4 = {1, 2};
        int target4 = 90;
        System.out.println(Arrays.toString(Find2Sum2(nums4, target4)));

        int[] nums5 = {1, 4, 2, 3, 3, 5, 2};
        int target5 = 6;
        System.out.println(numOfUniquePairs(nums5, target5));
    }

    //Hashtable
    public static int[] Find2Sum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] res = new int[]{-1, -1};
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-30-nums[i]) && (max < nums[i] || max < target-30-nums[i])){
                max = Math.max(nums[i], target-30-nums[i]);
                res[0] = map.get(target-30-nums[i]);
                res[1] = i;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    //two pointers
    public static int[] Find2Sum2(int[] nums, int target){
        //add index to the nums2d
        int[][] nums2d = new int[nums.length][2];
        for(int i=0; i<nums.length; i++)
            nums2d[i] = new int[]{nums[i], i};
        Arrays.sort(nums2d, (t1, t2) -> t1[0]-t2[0]);
        int[] res = new int[]{-1, -1};
        int max = Integer.MIN_VALUE;
        int i = 0, j = nums.length - 1;
        while(i < j){
            int sum = nums2d[i][0] + nums2d[j][0];
            if(sum < target - 30)
                i++;
            else if(sum > target - 30)
                j--;
            else{
                if(max < nums2d[i][0] || max < nums2d[j][0]){
                    max = Math.max(nums2d[i][0], nums2d[j][0]);
                    res[0] = Math.min(nums2d[i][1], nums2d[j][1]);
                    res[1] = Math.max(nums2d[i][1], nums2d[j][1]);;
                }
                i++;
            }
        }
        return res;
    }

    private static int numOfUniquePairs(int[] arr, int target){
        Set<Integer> set = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        int nums = 0;
        for(int num : arr){
            if(set.contains(target - num) && !used.contains(num) && !used.contains(target - num)){
                nums++;
                used.add(num);
            }
            set.add(num);
        }
        return nums;
    }
}