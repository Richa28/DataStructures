package com.sample.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayDifference {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(-2);
		list.add(-1);
		list.add(-1);
		list.add(-5);
		System.out.println(splitArray(list));
		
	}
	
	static int splitArray(List<Integer> arr) {
		int n = arr.size();
		Collections.sort(arr);
        int minDiff = arr.get(n-1) - arr.get(0);
        for (int i = 0; i < n - 1; i++) {
            int tmpDiff = arr.get(i+1) - arr.get(i);
            if (tmpDiff < minDiff) {
                minDiff = tmpDiff;
            }
        }

        return minDiff;
    }
	
}
