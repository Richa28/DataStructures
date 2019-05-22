package com.sample.test;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
		System.out.println(obj.longestPalindromicSubsequence("geeksforgeeks"));
		System.out.println(obj.longestPalindromicSubsequence("abcba"));
		System.out.println(obj.longestPalindromicSubsequence("abcd"));
		System.out.println(obj.longestPalindromicSubsequence("abcdba"));
	}
	
	public int longestPalindromicSubsequence (String input) {
		if(input == null || input.isEmpty()) {
			return 0;
		}
		int n = input.length();
		int lps[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			lps[i][i] = 1;
		}
		
		for(int cl=2; cl<=n; cl++) {
			for(int i=0; i<n-cl+1; i++) {
				int j = i+cl-1;
				boolean areEqual = input.charAt(i) == input.charAt(j);
				if( cl == 2 && areEqual) {
					lps[i][j] = 2;
				}else if(areEqual) {
					lps[i][j] = lps[i+1][j-1] + 2;
				}else {
					lps[i][j] = Math.max(lps[i+1][j], lps[i][j-1]);
				}
			}
		}
		
		return lps[0][n-1];
	}

}
