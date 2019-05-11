package com.sample.test;

public class MinimumInsertionsToFormPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aba";
		MinimumInsertionsToFormPalindrome obj = new MinimumInsertionsToFormPalindrome();
		System.out.println(obj.minInsertions(str));
	}
	
	public int minInsertions(String str) {
		int n = str.length();
		int dp[][] = new int[n][n];
		
		for(int gap = 1; gap<n; gap++) {
			for(int l=0, h=gap; h<n; l++,h++) {
				dp[l][h] = str.charAt(l) == str.charAt(h) ? dp[l+1][h-1] : Math.min(dp[l+1][h], dp[l][h-1]) + 1;
			}
		}
		
		return dp[0][n-1];
	}

}
