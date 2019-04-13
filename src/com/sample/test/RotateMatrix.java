package com.sample.test;

import java.util.ArrayList;

public class RotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> innerList = new ArrayList<>();
		innerList.add(1);
		innerList.add(2);
		
		list.add(innerList);
		
		innerList = new ArrayList<>();
		innerList.add(3);
		innerList.add(4);
		list.add(innerList);
		
		RotateMatrix obj = new RotateMatrix();
		obj.rotate(list);
		
	}

	public void rotate(ArrayList<ArrayList<Integer>> a) {
        a = transpose(a);
        reverseColumns(a);
    }
    
    ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> A){
        int n = A.size();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp = A.get(i).get(j);
                A.get(i).add(j,A.get(j).get(i));
                A.get(j).add(i, temp);
            }
        }
        return A;
    }
    
    void reverseColumns(ArrayList<ArrayList<Integer>> A){
        int n = A.size();
        for(int i=0; i<n; i++){
            int j = 0; int k = n-i-1;
            for(; j<n && k>=0; j++, k--){
                int temp = A.get(i).get(j);
                A.get(i).add(j,A.get(i).get(k));
                A.get(i).add(k, temp);
            }
        }
    }
}
