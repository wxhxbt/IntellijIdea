package com.company;

public class Test{

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        ListNode temp = new ListNode(0);
        temp = temp.buildList(nums);
        temp = Solution.reverseList_2(temp);

        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class Solution{
    static ListNode reverseList_1(ListNode head){
        //头插法
        ListNode cur = head;
        ListNode newhead = null;
        while (cur != null){
            cur = cur.next;
            head.next = newhead;
            newhead = head;
            head = cur;
        }
        return newhead;
    }

    static ListNode reverseList_2(ListNode head){
        //递归 recursively
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newhead = reverseList_2(next);
        next.next = head;
        head.next = null;
        return newhead;
    }
}