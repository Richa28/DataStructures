package com.sample.test;

import java.util.ArrayList;
import java.util.Collections;

public class UniquePermutations {

	public static void main(String[] args) {
		UniquePermutations obj = new UniquePermutations();
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(1);
		A.add(2);
		ArrayList<ArrayList<Integer>> list = obj.permute(A);
		for(ArrayList<Integer> list1 : list) {
			for(Integer i : list1) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        
        ArrayList<ArrayList<Integer>> permutations  = new ArrayList<ArrayList<Integer>>();
        
        if(A==null){
            return permutations;
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        boolean used[] = new boolean[A.size()];
        
        Collections.sort(A);
        compute(A, temp, permutations, used);
        
        return permutations;
        
    }
    
    private void compute(ArrayList<Integer> A, ArrayList<Integer> temp, 
    	ArrayList<ArrayList<Integer>> permutations,boolean[] used){
      
        if(temp.size() == A.size()){
            
            permutations.add(new ArrayList<>(temp));
            
            return;
        }
        
        
        for(int i= 0; i<A.size(); i++){
            
            if( (i>0  && A.get(i) == A.get(i-1) && used[i-1]) || used[i] ){
                continue;
            }
            
            used[i] = true;
            temp.add(A.get(i));
            compute(A,temp,permutations,used);
            temp.remove(temp.size()-1);
            used[i] = false;
        }
      
      return;
        
    }

}
