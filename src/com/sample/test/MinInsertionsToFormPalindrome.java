package com.sample.test;

public class MinInsertionsToFormPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinInsertionsToFormPalindrome obj = new MinInsertionsToFormPalindrome();
		System.out.println(obj.minInsertions("ab"));
		System.out.println(obj.minInsertions("aa"));
		System.out.println(obj.minInsertions("abcd"));
		System.out.println(obj.minInsertions("abcda"));
		System.out.println(obj.minInsertions("abcde"));
	}
	
	private int minInsertions(String str) {
		int n = str.length();
		int dp[][] = new int[n][n];
		
		for(int i=1; i<n; i++) {
			for(int l=0, h=i; h<n; l++,h++) {
				dp[l][h] = (str.charAt(l) == str.charAt(h)) ? dp[l+1][h-1] : Math.min(dp[l+1][h], dp[l][h-1]) + 1;
			}
		}
		
		return dp[0][n-1];
	}

}
