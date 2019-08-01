package com.sample.test;

public class FlipZerosToFormConsecutiveOnes {

	public static void main(String[] args) {
		FlipZerosToFormConsecutiveOnes obj = new FlipZerosToFormConsecutiveOnes();
		int arr[] = {0, 0, 0, 1};
		int maxFlipAllowed = 4;
		obj.longestWindowToFlipZeros(arr, maxFlipAllowed);
	}
	
	public void longestWindowToFlipZeros(int[] binaryArr, int maxFlipAllowed) {
		int n = binaryArr.length;
		if(n == 0 || maxFlipAllowed == 0) {
			System.out.println("Empty array");
			return;
		}
		
		if(n == 1) {
			if(maxFlipAllowed < 1) {
				System.out.println("Not possible");
			}else if(binaryArr[0] == 0){
				System.out.println("Longest window: 1");	
			}
			return;
		}
		
		int wL = 0, wR = 0;
		int max_window = 0, best_start = 0;
		int zeroCount = 0;
		
		while (wR < n) {
			if(zeroCount <= maxFlipAllowed) {
				if(binaryArr[wR] == 0) {
					zeroCount++;
				}
				wR++;
			}
			if(zeroCount > maxFlipAllowed) {
				if(binaryArr[wL] == 0) {
					zeroCount--;
				}
				wL++;
			}
			
			if(wR - wL > max_window && zeroCount <= maxFlipAllowed) {
				max_window = wR - wL;
				best_start = wL;
			}
		}
		
		for(int i=0; i<max_window; i++) {
			if(binaryArr[best_start+i] == 0) {
				System.out.print((best_start+i) + " ");
			}
		}
	}
	
}
