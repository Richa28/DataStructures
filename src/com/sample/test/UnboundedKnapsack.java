package com.sample.test;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnboundedKnapsack obj = new UnboundedKnapsack();
		int[] wt = {1, 3, 4, 5};
		int[] val = {10, 40, 50, 70};
		
		int W = 8;
		System.out.println(obj.unboundedKnapSack(W, wt, val));
	}

	private int unboundedKnapSack(int W,int[]wt, int[]val) {
		int dp[] = new int[W+1];
		
		for(int i=0; i<=W; i++) {
			for(int j=0; j<val.length; j++) {
				if(wt[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i-wt[j]] + val[j]);
				}
			}
		}
		
		return dp[W];
	}
	
}
