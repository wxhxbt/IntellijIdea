package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    int[] nums1 = new int[]{5};
	    int[] nums2 = new int[]{5};
	    ListNode h1 = ListNode.buildList(nums1);
        ListNode h2 = ListNode.buildList(nums2);

        ListNode sol = Solution.addTwoNumbers(h1,h2);
        while(sol != null){
            System.out.println(sol.val);
            sol = sol.next;
        }
    }
}

class Solution{
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode pre = new ListNode(0);
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()) sum += s1.pop();
            if(!s2.empty()) sum += s2.pop();
            pre.val = sum % 10;
            ListNode cur = new ListNode(sum / 10);
            cur.next = pre;
            pre = cur;
            sum /= 10;
        }
        return (pre.val == 0)?pre.next:pre;
    }
}