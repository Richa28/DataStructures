package com.sample.test;

public class SampleTest {
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(11);
		TreeNode left = new TreeNode(7);
		TreeNode right = new TreeNode(3);
		head.left = left;
		head.right = right;
		left.left = new TreeNode(4);
		left.right = new TreeNode(6);
		right.left = new TreeNode(2);
		
		SampleTest obj = new SampleTest();
		System.out.println(obj.findRootToPathSum(head, 22));
		System.out.println(obj.findRootToPathSum(head, 50));
		System.out.println(obj.findRootToPathSum(head, 24));
		System.out.println(obj.findRootToPathSum(head, 0));
	}
	
	public boolean findRootToPathSum(TreeNode node, int k) {
		if(node == null) {
			if(k == 0) {
				return true;
			}
			return false;
		}
		
		int val = k - node.val;
		
		if(node.left == null && node.right == null && val == 0) {
			return true;
		}
		
		boolean left = findRootToPathSum(node.left, val);
		boolean right = findRootToPathSum(node.right, val);
		
		return left || right;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
