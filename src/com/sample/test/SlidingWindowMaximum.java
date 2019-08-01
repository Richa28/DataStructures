package com.sample.test;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		SlidingWindowMaximum obj = new SlidingWindowMaximum();
		int []arr = {1, 3, 5, -1, 2, -3, 8, 2, 6};
		int k = 3;
		obj.findMaximumInWindowK(arr, k);
	}

	public void findMaximumInWindowK(int[] arr, int k) {
		int n = arr.length;
		if (n == 0) {
			return;
		}
		
		Deque<Integer> deque = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			if(!deque.isEmpty() && deque.peekFirst() == i - k) {
				deque.removeFirst();
			}
			
			while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
				deque.removeLast();
			}
			
			deque.addLast(i);
			
			if(i >= k-1) {
				System.out.println("Maximum in window k: "+arr[deque.peekFirst()]);
			}
		}
	}
	
}
