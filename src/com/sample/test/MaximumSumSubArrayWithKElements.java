package com.sample.test;

public class MaximumSumSubArrayWithKElements {

	public static void main(String[] args) throws Exception {
		MaximumSumSubArrayWithKElements obj = new MaximumSumSubArrayWithKElements();
		int arr[] = {1, 1, 1, 1, 1, 1}; 
        int k = 2;
        System.out.println(obj.maxSumSubArray(arr, k));
	}

	public int maxSumSubArray(int[] arr, int k) throws Exception {
		int n = arr.length;
		if(k>n) {
			throw new Exception("k is greater than array length");
		}
		
		int[] maxSum = new int[n];
		int curr_sum = 0;
		
		for(int i=0; i<n; i++) {
			curr_sum = Math.max(arr[i], curr_sum + arr[i]);
			maxSum[i] = curr_sum;
		}
		
		int sum = 0;
		for(int i=0; i<k; i++) {
			sum += arr[i];
		}
		
		int result = sum;
		
		for(int i=k; i<n; i++) {
			sum = sum + arr[i] - arr[i-k];
			result = Math.max(result, sum);
			result = Math.max(result, sum + maxSum[i-k]);
		}
		
		return result;
	}
	
}
