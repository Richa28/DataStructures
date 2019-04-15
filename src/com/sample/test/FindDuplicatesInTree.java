package com.sample.test;

import java.util.HashSet;

public class FindDuplicatesInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindDuplicatesInTree obj = new FindDuplicatesInTree();
		System.out.println(obj.checkDuplicates(null));
	}
	
	private boolean checkDuplicates(Node node) {
		boolean res = false;
		HashSet<String> set = new HashSet<>();
		String result = checkDuplicatesUtil(node, set);
		if(result.equals("")) {
			res = true;
		}
		return res;
	}
	
	private String checkDuplicatesUtil(Node node, HashSet<String> set) {
		String s = "";
		if(node == null) {
			return s+"$";
		}
		
		String left = checkDuplicatesUtil(node.left, set);
		if(left.equals(s)) {
			return s;
		}
		
		String right = checkDuplicatesUtil(node.right, set);
		if(right.equals(s)) {
			return s;
		}
		
		s = s + node.data + left + right;
		
		if(s.length() > 3 && set.contains(s)) {
			return "";
		}
		
		set.add(s);
		return s;
	}

	
	class Node {  
	    int data;  
	    Node left,right;  
	    Node(int data) 
	    { 
	        this.data=data; 
	    } 
	}; 
}
