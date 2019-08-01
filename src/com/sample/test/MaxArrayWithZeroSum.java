package com.sample.test;

import java.util.HashMap;

public class MaxArrayWithZeroSum {
	
	static int maxLenWithZeroSum(int arr[]) 
	{ 
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 

		int sum = 0; 
		int max_len = 0; 

		for (int i = 0; i < arr.length; i++) 
		{
			sum += arr[i]; 

			if (sum == 0) 
				max_len = i+1; 

			Integer temp = map.get(sum); 

			if (temp != null) 
				max_len = Math.max(max_len, i-temp); 
			else 
				map.put(sum, i); 
		} 

		return max_len; 
	} 
	
	static int maxLenWithKSum(int[] arr, int k) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int sum = 0; 
		int max_len = 0; 

		for (int i = 0; i < arr.length; i++) 
		{
			sum += arr[i]; 

			if (sum == k) 
				max_len = i+1; 

			Integer temp = map.get(sum-k); 

			if (temp != null) 
				max_len = Math.max(max_len, i-temp); 
			else 
				map.put(sum, i);
		} 

		return max_len; 
	}

	public static void main(String arg[]) 
	{ 
		int arr[] = {3,1,-1}; 
		System.out.println("Length of the longest 0 sum subarray is "
						+ maxLenWithZeroSum(arr));
		int []arr1 = {5,10,3,6,2,1};
		System.out.println(maxLenWithKSum(arr1, 27));
	} 

}
