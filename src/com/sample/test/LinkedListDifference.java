package com.sample.test;

public class LinkedListDifference {

	public static void main(String[] args) {
		LinkedListNode node1 = new LinkedListNode(1);
		node1.next = new LinkedListNode(0);
		node1.next.next = new LinkedListNode(0);
		//node1.next.next.next = new LinkedListNode(5);
		
		LinkedListNode node2 = new LinkedListNode(1);
		node2.next = new LinkedListNode(1);
		//node2.next.next = new LinkedListNode(1);
		//node2.next.next.next = new LinkedListNode(4);
		
		LinkedListDifference obj = new LinkedListDifference();
		obj.output = null;
		obj.findDifference(node1, node2);
		
		while(obj.output!=null) {
			System.out.print(obj.output.val+"  ");
			obj.output = obj.output.next;
		}
	}
	
	boolean borrowUsed = false;
	LinkedListNode output = null;
	public void findDifferenceUtil (LinkedListNode node1, LinkedListNode node2) {
		
		if(node1 == null && node2 == null) {
			return;
		}
		
		findDifferenceUtil(node1.next, node2.next);
		
			int diff = 0;
			if(borrowUsed) {
				node1.val = node1.val - 1;
			}
			if(node1.val < node2.val) {
				diff = (10 + node1.val) - node2.val;
				borrowUsed = true;
			}else {
				diff = node1.val - node2.val;
				borrowUsed = false;
			}
			
			if(output == null) {
				output = new LinkedListNode(diff);
			}else {
				LinkedListNode temp = new LinkedListNode(diff);
				temp.next = output;
				output = temp;
			}	
	}
	
	public LinkedListNode findDifference (LinkedListNode node1, LinkedListNode node2) {
		int n1=0, n2=0;
		
		LinkedListNode curr1 = node1;
		LinkedListNode curr2 = node2;
		
		while(curr1 != null) {
			curr1 = curr1.next;
			n1++;
		}
		
		while(curr2!=null) {
			curr2 = curr2.next;
			n2++;
		}
		
		curr1 = node1;
		curr2 = node2;
		
		if(n1 == n2) {
			 findDifferenceUtil(curr1, curr2);
		}else {
			int diff = 0;
			if(n1 > n2) {
				diff =  n1 - n2;
				
				while(diff > 0) {
					LinkedListNode zeroNode = new LinkedListNode(0);
					zeroNode.next = curr2;
					curr2 = zeroNode;
					diff--;
				}
				findDifferenceUtil(curr1, curr2);
			}else {
				diff = n2 - n1;
				while(diff > 0) {
					LinkedListNode zeroNode = new LinkedListNode(0);
					zeroNode.next = curr1;
					curr1 = zeroNode;
					diff--;
				}
				findDifferenceUtil(curr1, curr2);
			}
			
			
		}
		return output;
	}

}

class LinkedListNode{
	int val;
	LinkedListNode next;
	public LinkedListNode(int val) {
		this.val = val;
	}
}