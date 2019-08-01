package com.sample.test;

public class FindTwoMissingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {1,1,3,3,4,4,6,6,7,2};
		FindTwoMissingNumbers obj = new FindTwoMissingNumbers();
		obj.findTwoMissingNumbers(arr);
	}
	
	public void findTwoMissingNumbers(int []arr) {
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
		
		System.out.println("x: " + x + " y: "+y);
	}

}
