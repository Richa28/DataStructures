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
		int res = 0;
		Stack<Integer> bracketStack = new Stack<>();
		bracketStack.push(-1);
		
		for(int i=0; i<n; i++) {
			if(str.charAt(i) == '(') {
				bracketStack.push(i);
			}else {
				bracketStack.pop();
				
				if(!bracketStack.isEmpty()) {
					res = Math.max(res, i-bracketStack.peek());
				}else {
					bracketStack.push(i);
				}
			}
		}
		
		return res;
	}
	
}
