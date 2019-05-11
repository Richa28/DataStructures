package com.sample.test;

public class TwoNonRepeatingElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoNonRepeatingElementsInArray obj = new TwoNonRepeatingElementsInArray();
		int arr[] = {1,2,3,4,1,2,3,4,5,6};
		obj.findTwoNonRepeating(arr);
	}
	
	public void findTwoNonRepeating(int[] arr) {
		int n = arr.length;
		int xor = 0;
		for(int i=0; i<n; i++) {
			xor = xor ^ arr[i];
		}
		
		int set_bit = xor & ~(xor-1);
		
		int x=0, y=0;
		for(int i=0; i<n; i++) {
			if((arr[i] & set_bit) == 0) {
				x = x ^ arr[i];
			}else {
				y = y ^ arr[i];
			}
		}
		
		System.out.println(x + " "+ y);
	}

}
