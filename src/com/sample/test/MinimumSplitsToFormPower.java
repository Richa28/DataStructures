package com.sample.test;

class MinimumSplitsToFormPo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "101101101";
		MinimumSplitsToFormPo obj = new MinimumSplitsToFormPo();
		System.out.println(obj.minSplitsNeeded(str));
	}
	
	public int minSplitsNeeded(String str) {
		int n = str.length();
		if (n == 0) {
			return -1;
		}
		
		int[] dp = new int[n];
		dp[n-1] = str.charAt(n-1) == '0' ? 0 : 1;
		
		for(int i=n-2; i>=0; i--) {
			dp[i] = Integer.MAX_VALUE;
			int val = 0;
			
			for(int j=i; j<n; j++) {
				
				val = (val * 2) + str.charAt(j) - '0';
				
				if(isPowerOf(val, 5)) {
					if(j == n-1) {
						dp[i] = 1;
					}else {
						if(dp[j+1] != -1) {
							dp[i] = Math.min(dp[i], dp[j+1]+1);
						}
					}
				}
			}
			if(dp[i] == Integer.MAX_VALUE) {
				dp[i] = -1;
			}
		}
		return dp[0];
	}
	
	private boolean isPowerOf(int num, int pow) {
		while(num > 0) {
			if(num % pow != 0) {
				return false;
			}
			num = num % pow;
		}
		return true;
	}

}
