package com.sample.test;

import java.util.ArrayList;

public class CombinationalSum {

	public static void main(String[] args) {
		CombinationalSum obj = new CombinationalSum();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(6);
		list.add(7);
		
		ArrayList<ArrayList<Integer>> result = obj.combinationSum(list, 7);
		for(ArrayList<Integer> list1 : result) {
			for ( Integer i : list1 ) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        computeSum(A, B, result, new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void computeSum(ArrayList<Integer> A, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int i){
        if ( sum < 0 ){
            return;
        }
        if ( sum == 0 ){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        while ( i < A.size() && sum - A.get(i) >= 0 ) {
            temp.add(A.get(i));
            computeSum(A, sum - A.get(i), result, temp, i);
            i++;
            temp.remove(temp.size() - 1);
        }
    }
	
}
