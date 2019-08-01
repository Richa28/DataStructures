package com.sample.test;

public class KLongestPalindromicSequence {
	
	public static void main(String[] args) {
		KLongestPalindromicSequence obj = new KLongestPalindromicSequence();
		String str = "abcde";
		System.out.println(obj.isKLongestPalindromePossible(str, 0));
	}
	
	public boolean isKLongestPalindromePossible(String str, int k) {
		boolean res = false;
		
		StringBuilder input1 = new StringBuilder(); 
		input1.append(str);   
        input1 = input1.reverse(); 
		
        String reverse = input1.toString();
        
        int lcsLength = longestCommonSequence(str, reverse);
        
        if(str.length() - lcsLength <= k) {
        	return true;
        }
        
		return res;
	}
	
	private int longestCommonSequence(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[m][n];
	}

}
