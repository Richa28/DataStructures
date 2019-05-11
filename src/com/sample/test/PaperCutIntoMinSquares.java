package com.sample.test;

public class PaperCutIntoMinSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaperCutIntoMinSquares obj = new PaperCutIntoMinSquares();
		int m = 4, n = 5; 
        System.out.println(obj.getMinSquares(n, m)); 
	}
	
	public int getMinSquares(int n, int m) {
		int[][] dp = new int[n+1][m+1];
		return getMinSquaresUtil(n, m, dp);
	}
	
	private int getMinSquaresUtil(int n, int m, int[][]dp) {
		if(n == m) {
			return 1;
		}
		
		if(dp[n][m] != 0)
			return dp[n][m];
		
		int vertical_min = Integer.MAX_VALUE;
		int horizontal_min = Integer.MAX_VALUE;
		
		for(int i=1; i<=n/2; i++) {
			vertical_min = Math.min(getMinSquaresUtil(i,m, dp) + getMinSquaresUtil(n-i, m, dp), vertical_min);
		}
		
		for(int i=1; i<=m/2; i++) {
			horizontal_min = Math.min(getMinSquaresUtil(n, i, dp) + getMinSquaresUtil(n, m-i, dp), horizontal_min);
		}
		
		dp[n][m] = Math.min(vertical_min, horizontal_min);
		
		return dp[n][m];
	}

}
