package com.sample.test;

public class GasStationProblem {

	public static void main(String[] args) {
		GasStationProblem obj = new GasStationProblem();
		int gas[] = { 1, 2 };
		int cost[] = { 2, 1 };
		
		System.out.println(obj.canCompleteCircuit(gas, cost));
	}
	
	public int canCompleteCircuit(int[]gas, int[] cost) {
		int n = gas.length;
		if( cost.length != n) {
			return -1;
		}
		
		int start = 0, end = 1;
		int curr_petrol = gas[start] - cost[start];
		
		while(curr_petrol < 0 || start != end) {
			while(curr_petrol < 0 && start != end) {
				curr_petrol -= gas[start] - cost[start];
				start = (start + 1) % n;
				
				if( start == 0) {
					return -1;
				}
			}
			
			curr_petrol += gas[end] - cost[end];
			end = (end + 1) %n;
		}
		
		return start;
	}

}
