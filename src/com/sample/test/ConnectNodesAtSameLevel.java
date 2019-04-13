package com.sample.test;

public class ConnectNodesAtSameLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public void connectNodesRecur(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.nextRight == null) {
			connectNodesRecur(node.nextRight);
		}
		
		if(node.left != null) {
			if(node.right != null) {
				node.left.nextRight = node.right;
				node.right = getNextRight(node);
			}else {
				node.left.nextRight = getNextRight(node);
			}
			connectNodesRecur(node.left);
		}else if(node.right != null) {
			node.right.nextRight = getNextRight(node);
			connectNodesRecur(node.right);
		}else {
			connectNodesRecur(getNextRight(node));
		}
	}
	
	private Node getNextRight(Node node) {
		Node temp = node.nextRight;
		while(temp!=null) {
			if(temp.left != null) {
				return temp.left;
			}else if(temp.right != null) {
				return temp.right;
			}
			temp = temp.nextRight;
		}
		return null;
	}
	
	class Node  
	{ 
	    int data; 
	    Node left, right, nextRight; 
	   
	    Node(int item)  
	    { 
	        data = item; 
	        left = right = nextRight = null; 
	    } 
	}

}
