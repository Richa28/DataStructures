package com.sample.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		LevelOrderTraversal obj = new LevelOrderTraversal();
		Node head = new Node(1);
		Node left = new Node(2);
		Node right = new Node(3);
		head.left = left;
		head.right = right;
		left.left = new Node(4);
		left.right = new Node(5);
		right.left = new Node(6);
		right.right = new Node(7);
		System.out.println("Level order traversal: ");
		obj.levelOrderTraversal(head);
		System.out.println("Zig zag traversal: ");
		obj.levelOrderZigZagTraversal(head);
	}
	
	public void levelOrderTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(true) {
			int size = queue.size();
			if(size == 0) {
				break;
			}
			
			while(size > 0) {
				Node temp = queue.poll();
				System.out.print(temp.val+" ");
				if(temp.left != null) {
					queue.add(temp.left);
				}
				if(temp.right != null) {
					queue.add(temp.right);
				}
				size--;
			}
			System.out.println();
		}
	}
	
	public void levelOrderZigZagTraversal(Node node) {
		if(node == null) {
			return;
		}
		
		Stack<Node> current = new Stack<>();
		Stack<Node> backup = new Stack<>();
		
		current.add(node);
		boolean leftToRight = false;
		while(!current.isEmpty()) {
			Node temp = current.pop();
			System.out.print(temp.val+" ");
			
			if(leftToRight) {
				if(temp.left != null) {
					backup.push(temp.left);
				}
				if(temp.right != null) {
					backup.push(temp.right);
				}
			}
			else {
				if(temp.right != null) {
					backup.push(temp.right);
				}
				if(temp.left != null) {
					backup.push(temp.left);
				}
			}
			
			if(current.isEmpty()) {
				System.out.println();
				leftToRight = !leftToRight;
				Stack<Node> temporary = current;
				current = backup;
				backup = temporary;
			}
		}
		
	}

}
