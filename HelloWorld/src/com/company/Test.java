package com.company;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,9,1};
        int[] nums2 = new int[]{3};
        int[] nums3 = new int[]{2,4};
        ListNode[] lists = new ListNode[2];
        ListNode x = new ListNode(0);
        lists= x.build_lists_inte(nums1,nums2,nums3);

        x = Solution.getIntersectionNode(lists[0], lists[1]);
        if(x != null)
            System.out.println(x.val);
        else
            System.out.println("There is no intersectionNode.");

    }
}

class Solution {
    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int count = 0;
        while(cur1 != cur2){
            cur1 = (cur1 == null)? headB:cur1.next;
            cur2 = (cur2 == null)? headA:cur2.next;
        }
        return cur1;
    }
}