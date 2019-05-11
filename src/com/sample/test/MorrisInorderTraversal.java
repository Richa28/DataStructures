package com.sample.test;

public class MorrisInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MorrisInorderTraversal obj = new MorrisInorderTraversal();
		
		Node root = null; 
		root = obj.insert(root, 50); 
		obj.insert(root, 30); 
		obj.insert(root, 20); 
		obj.insert(root, 40); 
		obj.insert(root, 70); 
		obj.insert(root, 60); 
		obj.insert(root, 80);
		
		System.out.println(obj.findMedian(root));
		
		System.out.println(obj.getKSmallest(root, 2));
		System.out.println(obj.getKSmallest(root, 3));
		System.out.println(obj.getKSmallest(root, 4));
		System.out.println(obj.getKSmallest(root, 5));
	}
	
	public int findMedian(Node root) {
		int median = 0;
		
		int totalNumberOfNodes = getNumberOfNodes(root);
		
		median = getMedian(root, totalNumberOfNodes);
		
		return median;
	}
	
	private int getMedian(Node root, int totalNumberOfNodes) {
		int median = -1;
		Node current = root;
		Node prev = null;
		int currentCount = 0;
		
		while(current != null) {
			if(current.left == null) {
				currentCount++;
				
				if(totalNumberOfNodes % 2 != 0 && currentCount == (totalNumberOfNodes+1)/2) {
					median = current.val;
					return median;
				}else if(totalNumberOfNodes % 2 == 0 && currentCount == (totalNumberOfNodes/2)+1) {
					median = (current.val + prev.val)/2;
					return median;
				}
				
				prev = current;
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
					currentCount++;
					prev = predecessor;
					if(totalNumberOfNodes % 2 != 0 && currentCount == (totalNumberOfNodes+1)/2) {
						median = current.val;
						return median;
					}else if(totalNumberOfNodes % 2 == 0 && currentCount == (totalNumberOfNodes/2)+1) {
						median = (current.val + prev.val)/2;
						return median;
					}
					prev = current;
					current = current.right;
				}
			}
		}
		
		return median;
	}
	
	private int getNumberOfNodes(Node root) {
		int totalCount = 0;
		Node current = root;
		
		while(current != null) {
			if(current.left == null) {
				totalCount++;
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
					totalCount++;
					current = current.right;
				}
				
			}
		}
		
		return totalCount;
	}
	
	public int getKSmallest(Node root, int k) {
		int kSmallest = 0;
		
		Node current = root;
		int count = 0;
		
		while(current != null) {
			if(current.left == null) {
				count++;
				if(count == k) {
					 return current.val;
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
					count ++ ;
					
					if(count == k) {
						 return current.val;
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
}

class Node{
    int val;
    Node left;
    Node right;
}
