package com.sample.test;

public class PainterPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PainterPartition obj = new PainterPartition();
		int boards[] = {10, 20, 30, 40};
		int numOfPainters = 2;
		System.out.println(obj.getMinTimeForPainting(boards, numOfPainters));
	}
	
	public int getMinTimeForPainting(int[] boards, int numOfPainters) {
		int minTime = getMaxInArr(boards);
		int maxTime = getSumOfArr(boards);
		int res = Integer.MAX_VALUE;
		
		while(minTime <= maxTime) {
			int mid = minTime + (maxTime - minTime)/2;
			if(ArePaintersPossible(boards, numOfPainters, mid)) {
				res = Math.min(res, mid);
				maxTime = mid - 1;
			}else {
				minTime = mid + 1;
			}
		}
		return res;
	}
	
	private boolean ArePaintersPossible(int[] boards, int numOfPainters, int curr_min) {
		int n = boards.length;
		int curr_sum = 0, curr_num_of_painters = 1;
		
		for(int i=0; i<n; i++) {
			if(boards[i] > curr_min) {
				return false;
			}
			if(boards[i] + curr_sum > curr_min) {
				curr_sum = boards[i];
				curr_num_of_painters++;
				if(curr_num_of_painters > numOfPainters) {
					return false;
				}
			}else {
				curr_sum += boards[i];
			}
		}
		return true;
	}
	
	private int getSumOfArr(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	private int getMaxInArr(int[] arr) {
		int max = arr[0];
		for(int i=1; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

}
