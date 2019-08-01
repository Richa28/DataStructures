package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class RodCuttingMinimizeLength {

	private int[][] parent;
	private int cuts[];
	private List<Integer> result;
	
	public static void main(String[] args) {
		RodCuttingMinimizeLength obj = new RodCuttingMinimizeLength();
		int rodLength = 6;
		int costs[] = { 1, 2, 5 };
		obj.rodCuttingToMinimizeLength(rodLength, costs);
		
		for(Integer i : obj.result) {
			System.out.println(i);
		}
	}
	
	private List<Integer> rodCuttingToMinimizeLength(int rodLength, int[] costs){
		int n = costs.length + 2;
		int [][]dp = new int[n][n];
		cuts = new int[n];
		parent = new int[n][n];
		
		cuts[0] = 0;
		for(int i=0; i<costs.length; i++) {
			cuts[i+1] = costs[i];
		}
		cuts[n-1] = rodLength;
		
		for(int len = 1; len<=rodLength; len++) {
			for(int start=0; start<n-len; start++) {
				int end = start+len;
				for(int k=start+1; k<n; k++) {
					int cost = cuts[end] - cuts[start] + dp[start][k] + dp[k][end];
					if(dp[start][end] == 0 || cost < dp[start][end]) {
						dp[start][end] = cost;
						parent[start][end] = k;
					}
				}
			}
		}
		
		result = new ArrayList<>();
		backTrack(0, n-1);
		return result;
	}
	
	private void backTrack(int start, int end) {
		if(start+1 >= end) {
			return;
		}
		
		result.add(cuts[parent[start][end]]);
		backTrack(start, parent[start][end]);
		backTrack(parent[start][end], end);
	}

}
