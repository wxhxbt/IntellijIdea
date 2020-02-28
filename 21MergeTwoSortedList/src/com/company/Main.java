package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] nums1 = new int[]{1,2,4};
	    int[] nums2 = new int[]{1,3,4};
	    ListNode h1 = ListNode.buildList(nums1);
	    ListNode h2 = ListNode.buildList(nums2);

	    ListNode sol = Solution.mergeTwoLists2(h1, h2);
	    while (sol!=null){
	        System.out.println(sol.val);
	        sol = sol.next;
        }
    }
}

class Solution{
	//我的方法---把l2的节点取下插入到l1中
	static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		ListNode pre = l1;
		ListNode cur = l1;
		ListNode next = l2;
		while (next != null){
			next = next.next;
			l2.next = null;
			while (cur != null){
				if(l2.val <= cur.val){
					l2.next = cur;
					if(cur == l1){
						l1 = l2;
						pre = l2;
					}else{
						pre.next = l2;
						pre = l2;
					}
					break;
				}else{
					if(cur != l1){
						pre = pre.next;
					}
					cur = cur.next;
					if(cur == null){
						pre.next = l2;
						l2.next = next;
						return l1;
					}
				}
			}
			l2 = next;
		}
		return l1;
	}

	//别人的迭代法 增加一个空结点作新链表头 对比两个旧链表头的大小
	static public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode dummy= new ListNode(0);
		ListNode cur = dummy;
		while (l1!=null && l2!=null){
			if(l1.val < l2.val){
				cur.next = l1;
				l1 = l1.next;
			}else{
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		cur.next = (l1 == null)? l2:l1;
		return dummy.next;
	}
	//迭代法 四行代码
	static public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists3(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists3(l1, l2.next);
			return l2;
		}
	}
}
