package com.sample.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffK {

	public static void main(String[] args) {
		DiffK obj = new DiffK();
		int arr[] = {11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13};
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(obj.diffPossible(list, 60));
	}
	
	public int diffPossible(final List<Integer> A, int B) {
        
        int n = A.size();
        if( n == 0 || n == 1){
            return 0;
        }
        
        Set<Integer> map = new HashSet<>();
        
        for(int i=0; i<A.size(); i++) {
        	if(map.contains(B+A.get(i)) || map.contains(A.get(i) - B)) {
        		return 1;
        	}else {
        		map.add(A.get(i));
        	}
        }
        
        return 0;
    }

}

