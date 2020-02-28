package com.company;

import java.util.Arrays;

public class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        this.val = x;
        this.next = null;
    }

    static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for(int i: Arrays.copyOfRange(nums, 1, nums.length)){
            ListNode newNode = new ListNode(i);
            current.next = newNode;
            current = newNode;
        }
        return head;
    }

    ListNode[] build_lists_inte(int[] nums1, int[] nums2, int[] common){
        ListNode[] lists = new ListNode[2];
        ListNode commen = this.buildList(common);
        lists[0] = this.buildList(nums1);
        ListNode cur1 = lists[0];
        lists[1] = this.buildList(nums2);
        ListNode cur2 = lists[1];
        while(true){
            if(cur1.next == null){
                cur1.next = commen;
                break;
            }
            cur1 = cur1.next;
        }
        while(true){
            if(cur2.next == null){
                cur2.next = commen;
                break;
            }
            cur2 = cur2.next;
        }
        return lists;
    }
}
