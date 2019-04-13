package com.sample.test;

import java.util.Stack;

public class LongestValidSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestValidSubstring obj = new LongestValidSubstring();
		System.out.println(obj.longestValidSubstring("()"));
		System.out.println(obj.longestValidSubstring("((()"));
		System.out.println(obj.longestValidSubstring(")()())"));
		System.out.println(obj.longestValidSubstring("()(()))))"));
	}
	
	private int longestValidSubstring(String str) {
		int n = str.length();
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		stack.push(-1);
		
		for(int i = 0; i<n; i++) {
			if(str.charAt(i) == '(') {
				stack.push(i);
			}else {
				stack.pop();
			
				if(!stack.isEmpty()) {
					res = Math.max(res, i - stack.peek());
				}else {
					stack.push(i);
				}
			}
		}
		
		return res;
	}
	
}
