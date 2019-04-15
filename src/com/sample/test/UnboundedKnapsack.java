package com.sample.test;

import java.util.Arrays;

public class UnboundedKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int W = 8; 
        int val[] = {10, 40, 50, 70}; 
        int wt[] = {1, 3, 4, 5}; 
        
        UnboundedKnapsack obj = new UnboundedKnapsack();
        System.out.println(obj.getUnboundedKnapsack(wt, val, W)); 
	}
	
	private int getUnboundedKnapsack(int wt[], int val[], int W) {
		if(wt == null || val == null) {
			return -1;
		}
		
		int n = wt.length;
		if(n != val.length) {
			return -1;
		}
		
		int []dp = new int[W+1];
		Arrays.fill(dp, 0);
		
		for(int i=0; i<=W; i++) {
			for(int j=0; j<n; j++) {
				if(i >= wt[j])
					dp[i] = Math.max(dp[i], dp[i-wt[j]] + val[j]);
			}
		}
		
		return dp[W];
	}

}
