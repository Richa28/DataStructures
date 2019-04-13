package com.sample.test;

public class MaximumWaysToPrintA {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumWaysToPrintA obj = new MaximumWaysToPrintA();
		System.out.println(obj.getMaximumKeys(3));
		System.out.println(obj.getMaximumKeys(7));
	}

	public int getMaximumKeys(int N){
	    if(N<=6){
	        return N;
	    }
	    
	    int []dp = new int[N];
	    
	    for(int i = 1; i <= 6; i++){
	        dp[i-1] = i;
	    }
	    
	    for(int n = 7; n<=N; n++){
	        dp[n-1] = 0;
	        for(int b = n-3; b>=1; b--){
	            int count = (n-b-1) * dp[b-1];
	            dp[n-1] = Math.max(dp[n-1], count);
	        }
	    }
	    
	    return dp[N-1];
	}
	
}
