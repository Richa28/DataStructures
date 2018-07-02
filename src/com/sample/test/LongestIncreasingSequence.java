package com.sample.test;

import java.util.Arrays;

public class LongestIncreasingSequence {
	
	public static int logestSequence(int arr[]) {
		int dp[] = new int[arr.length];
		
		Arrays.fill(dp, 1);
		
		for(int i=1;i<arr.length;i++) {
			for(int j=0;j<=i;j++) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
				}
			}
		}
		
		int max = 1;
		for(int i=0;i<arr.length;i++) {
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		int arr[] = {10, 21, 9, 33, 50, 40, 61};
		System.out.println(logestSequence(arr));
	}

}
