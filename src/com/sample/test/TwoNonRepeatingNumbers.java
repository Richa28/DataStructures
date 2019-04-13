package com.sample.test;

public class TwoNonRepeatingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2, 3, 7, 9, 11, 2, 3, 11};
		TwoNonRepeatingNumbers obj = new TwoNonRepeatingNumbers();
		obj.get2NonRepeatingNos(arr);
	}
	
	void get2NonRepeatingNos(int arr[]) {
		int n = arr.length;
		if(n < 2)
			return;
		int xor = getAllElementsXor(arr);
		int x=0, y=0;
		int setBit = xor & ~(xor-1);
		
		for(int i=0; i<n; i++) {
			if((arr[i] & setBit) == 0) {
				x = x ^ arr[i];
			}else {
				y = y ^ arr[i];
			}
		}
		
		System.out.println(x + " " + y);
	}
	
	int getAllElementsXor(int[] arr) {
		int n = arr.length;
		int xor = arr[0];
		
		for(int i=1; i<n; i++) {
			xor = xor ^ arr[i];
		}
		
		return xor;
	}

}
