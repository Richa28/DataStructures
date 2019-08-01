package com.sample.test;

public class ReverseListInRange {

	public static void main(String[] args) {
		ReverseListInRange obj = new ReverseListInRange();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ListNode res = obj.reverseListInRange(head, 2, 3);
		while(res != null) {
			System.out.print(res.val + " ");
		}
	}
	
	public ListNode reverseListInRange (ListNode node, int m, int n) {
		if ( node == null ) {
			return node;
		}
		
		ListNode prev = null;
		ListNode curr = node;
		ListNode next = null;
		int count = 0;
		
		while (curr != null) {
			count++;
			
			if(count == m + 1) {
				ListNode temp = prev;
				// Reverse list from m to n
				while ( count < n ) {
					next = curr.next;
					curr.next = prev;
					prev = curr;
					curr = next;
					count++ ;
				}
				temp.next = prev;
				return temp;
			}
			
			prev = curr;
			curr = curr.next;
		}
		
		return prev;
	}

}

class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}