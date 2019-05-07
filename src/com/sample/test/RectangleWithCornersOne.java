package com.sample.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RectangleWithCornersOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][]={ { 1, 0, 0, 1, 0 },  
                { 0, 0, 1, 0, 1 },  
                { 0, 0, 0, 1, 0 },  
                { 1, 0, 1, 0, 1 } };
		
		RectangleWithCornersOne obj = new RectangleWithCornersOne();
		System.out.println(obj.rectangleWithCorners1(mat));
	}
	
	public boolean rectangleWithCorners1(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		Map<Integer, List<Integer>> indexMap = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m-1; j++) {
				for(int k=j+1; k<m; k++) {
					if(matrix[i][j] == 1 && matrix[i][k] == 1) {
						if(indexMap.containsKey(j) && indexMap.get(j).contains(k)) {
							return true;
						}else if(indexMap.containsKey(k) && indexMap.get(k).contains(j)) {
							return true;
						}
						
						if(!indexMap.containsKey(j)) {
							List<Integer> indexList = new ArrayList<>();
							indexList.add(k);
							indexMap.put(j, indexList);
						}else {
							List<Integer> indexList = indexMap.get(j);
							indexList.add(k);
							indexMap.put(j, indexList);
						}
						
						if(!indexMap.containsKey(k)) {
							List<Integer> indexList = new ArrayList<>();
							indexList.add(j);
							indexMap.put(k, indexList);
						}else {
							List<Integer> indexList = indexMap.get(k);
							indexList.add(j);
							indexMap.put(k, indexList);
						}
					}
				}
			}
		}
		return false;
	}

}
