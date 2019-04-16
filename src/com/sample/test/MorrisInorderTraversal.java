package com.sample.test;

public class MorrisInorderTraversal {

	class Node {
		int val;
		Node right;
		Node left;
	}
	
	public void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		Node current = node;
		
		while(current != null) {
			if(current.left == null) {
				System.out.println(current.val);
				current = current.right;
			}else {
				Node predecessor = current.left;
				while(predecessor.right != null && predecessor.right != current) {
					predecessor = predecessor.right;
				}
				
				if(predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				}else {
					predecessor.right = null;
					System.out.println(current.val);
					current = current.right;
				}
			}
		}
	}
	
}
