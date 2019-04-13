package com.sample.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpingNumbers obj = new JumpingNumbers();
		obj.getJumpingNumber(105);
	}
	
	public List<Integer> getJumpingNumber(int n){
		if(n < 0) {
			return Collections.emptyList();
		}
		List<Integer> list = new ArrayList<>();
		
		list.add(0);
		for(int i=1; i<n && i<=9; i++) {
			jumpingNumberUtil(n, i, list);
		}
		
		return list;
	}
	
	private void jumpingNumberUtil(int val, int x, List<Integer> list) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		
		while(!queue.isEmpty()) {
			int num = queue.poll();
			if(num <= val) {
				list.add(num);
				int x1 = num % 10;
				
				if(x1 == 0) {
					queue.add((num * 10) + x1 + 1);
				}else if(x1 == 9) {
					queue.add((num * 10) + x1 - 1);
				}else {
					queue.add((num * 10) + x1 - 1);
					queue.add((num * 10) + x1 + 1);
				}
			}
			
		}
		
	}

}
