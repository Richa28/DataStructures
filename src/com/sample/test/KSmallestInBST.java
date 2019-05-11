package com.sample.test;

public class KSmallestInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSmallestInBST obj = new KSmallestInBST();
		
		Node root = null; 
		root = obj.insert(root, 50); 
		obj.insert(root, 30); 
		obj.insert(root, 20); 
		obj.insert(root, 40); 
		obj.insert(root, 70); 
		obj.insert(root, 60); 
		obj.insert(root, 80);
		
		System.out.println(obj.getKSmallest(root, 5));
	}
	
	public int getKSmallest(Node node, int k) {
		int kSmallest = -1;
		
		if(node == null)
			return kSmallest;
		
		int count = 0;
		Node current = node;
		
		while(current != null) {
			if(current.left == null) {
				count ++;
				if(count == k) {
					kSmallest = current.val;
				}
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
					count++;
					if(count == k) {
						kSmallest = current.val;
					}
					current = current.right;
				}
			}
		}
		
		return kSmallest;
	}
	
	Node newNode(int item) 
	{ 
		Node temp = new Node(); 
		temp.val = item; 
		temp.left = null; 
		temp.right = null; 
		return temp; 
	} 

	Node insert(Node node, int key) 
	{ 
		if (node == null) return newNode(key); 

		if (key < node.val) 
			node.left = insert(node.left, key); 
		else if (key > node.val) 
			node.right = insert(node.right, key); 
		return node;
}
	
	class Node{
		int val;
		Node left;
		Node right;
	}
}
