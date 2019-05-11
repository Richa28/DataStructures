package com.sample.test;

import java.util.Arrays;

public class TripletsWithZeroSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TripletsWithZeroSum obj = new TripletsWithZeroSum();
		int arr[] = {0, -1, 2, -3, 1}; 
		obj.findTriplets(arr);
	}
	
	public void findTriplets(int[] arr) {
		int n = arr.length;
		Arrays.sort(arr);
		
		for(int i=0; i<n-1; i++) {
			int x = arr[i];
			int l = i+1;
			int r = n-1;
			
			while(l<r) {
				int tempSum = x+arr[l]+arr[r];
				if(tempSum == 0) {
					System.out.println(x + " " + arr[l] + " " + arr[r]);
					l++;
					r--;
				}else if(tempSum < 0) {
					l++;
				}else {
					r--;
				}
			}
		}
	}

}
