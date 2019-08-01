package com.sample.test;

public class WordWrap {

	public static void main(String[] args) {
		WordWrap obj = new WordWrap();
		int arr[] = {3, 2, 2, 5};
		int k = 6;
		obj.wordWrap(arr, k);
	}

	public void wordWrap(int[] wordsLength, int k) {
		int n = wordsLength.length;
		
		int []dp = new int[n];
		int cost = 0;
		int ans[] = new int[n];
		
		dp[n-1] = 0;
		ans[n-1] = n-1;
		
		for(int i=n-2; i>=0; i--) {
			dp[i] = Integer.MAX_VALUE;
			int currLen = 0;
			for(int j=i; j<n; j++) {
				currLen += wordsLength[j] + 1;
				
				if(currLen > k)
					break;
				
				if(j == n-1) {
					cost = 0;
				}else {
					cost = (k-currLen) * (k-currLen) + dp[j+1];
				}
				
				if(cost < dp[i]) {
					dp[i] = cost;
					ans[i] = j;
				}
			}
		}
		
		int i = 0;
		while(i<n) {
			System.out.println((i+1) + "  " + (ans[i] + 1) + "  ");
			i = ans[i] + 1;
		}
	}
	
}
