package com.sample.test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInRowColSortedMatrix {

	public static void main(String[] args) {
		KthSmallestInRowColSortedMatrix obj = new KthSmallestInRowColSortedMatrix();
		int [][] matrix = { {10, 20, 30, 40}, 
                {15, 25, 35, 45}, 
                {25, 29, 37, 48}, 
                {32, 33, 39, 50}, 
              };
		
		int k = 3;
		System.out.println(obj.findKthSmallestElement(matrix, k));
	}
	
	public int findKthSmallestElement(int[][] matrix, int k) {
		int n = matrix.length;
		if(n == 0 || k > n*n) {
			return Integer.MAX_VALUE;
		}
		
		PriorityQueue<MinHeapElement> pq = new PriorityQueue<>(n, new Comparator<MinHeapElement>() {

			@Override
			public int compare(MinHeapElement o1, MinHeapElement o2) {
				return o1.val - o2.val;
			}
		});
		
		for(int i=0; i<n; i++) {
			MinHeapElement obj = new MinHeapElement(matrix[0][i], 0, i);
			pq.add(obj);
		}
		
		int count = 0;
		while(count < k-1) {
			MinHeapElement obj1 = pq.poll();
			int row = obj1.row;
			int col = obj1.col;
			MinHeapElement obj2 = null;
			if(row < n-1) {
				obj2 = new MinHeapElement(matrix[row+1][col], row+1, col);
			}else if(col < n-1) {
				obj2 = new MinHeapElement(matrix[row][col+1], row, col+1);
			}
			pq.add(obj2);
			count++;
		}
		
		return pq.poll().val;
		
	}
	
	class MinHeapElement {
		int val;
		int row;
		int col;
		public MinHeapElement(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}

}
