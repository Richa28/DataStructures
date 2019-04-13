package com.sample.test;

import java.util.Arrays;

public class InterleavingStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleave("B", "E", "BE"));
	}

	public static boolean isInterleave(String A, String B, String C) {
		int n = A.length();
		int m = B.length();
		
		if(n+m != C.length())
			return false;
		
		boolean dp[][] = new boolean[n+1][m+1];
		for (boolean[] row : dp) 
            Arrays.fill(row, false); 
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=m; j++) {
				if(i==0 && j==0) {
					dp[i][j] = true; 
				}
				else if(j>0 && i==0 && B.charAt(j-1) == C.charAt(j-1)) {
					dp[i][j] = dp[i][j-1];
				}
				else if(i>0 && j==0 && A.charAt(i-1) == C.charAt(i-1)) {
					dp[i][j] = dp[i-1][j];
				}else if((i>0 && A.charAt(i-1) == C.charAt(i+j-1)) && (j>0 && B.charAt(j-1) != C.charAt(i+j-1))) {
					dp[i][j] = dp[i-1][j];
				}else if((i>0 && A.charAt(i-1) != C.charAt(i+j-1)) && (j>0 && B.charAt(j-1) == C.charAt(i+j-1))) {
					dp[i][j] = dp[i][j-1];
				}else if((i>0 && A.charAt(i-1) == C.charAt(i+j-1)) && (j>0 && B.charAt(j-1) == C.charAt(i+j-1))) {
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				}
			}
		}
		
		return dp[n][m];
	}
}
