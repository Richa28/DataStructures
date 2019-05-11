package com.sample.test;

import java.util.Arrays;

public class MinJumpsToReachEnd {
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 6, 1, 0, 9};
		MinJumpsToReachEnd obj = new MinJumpsToReachEnd();
		System.out.println(obj.minJumps(arr));
	}
	
	public int minJumps(int[] arr) {
		int n = arr.length;
		
		if(n == 0 || arr[0] == 0) {
			return Integer.MAX_VALUE;
		}
		
		int[]jumps = new int[n];
		Arrays.fill(jumps, Integer.MAX_VALUE);
		
		jumps[n-1] = 0;
		
		for(int i = n-2; i>=0; i--) {
			if(arr[i] == 0) {
				jumps[i] = Integer.MAX_VALUE;
			}else if (arr[i] >= n-i-1) {
				jumps[i] = 1;
			}else {
				int min = Integer.MAX_VALUE;
				for(int j=i+1; j<n && j<=arr[i]+i; j++) {
					min = Math.min(min, jumps[j]);
				}
				
				if(min != Integer.MAX_VALUE) {
					jumps[i] = min + 1;
				}else {
					jumps[i] = min;
				}
			}
		}
		
		return jumps[0];
	}

}
