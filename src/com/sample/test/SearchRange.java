package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class SearchRange {

	public static void main(String[] args){
		int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		
		//int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
		ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<arr.length;i++) {
        	a.add(arr[i]);
        }
        res.add(getStart(a, 10, 0, a.size()));
        res.add(getEnd(a, 10, 0, a.size()));
        System.out.println(res.get(0) + "  " + res.get(1));
    }
    
    private static int getStart(List<Integer> a, int b, int low, int high){
    	if(high >= low) 
        { 
            int mid = low + (high - low)/2; 
            if( ( mid == 0 || b > a.get(mid-1)) && a.get(mid) == b) 
                return mid; 
             else if(b > a.get(mid)) 
                return getStart(a, b, (mid + 1), high); 
            else
                return getStart(a, b, low, (mid -1)); 
        } 
    return -1; 
    }
    
    private static int getEnd(List<Integer>a, int b, int low, int high){
        int n = a.size();
        if(high>=low){
            int mid = low + (high - low)/2;
            if((mid == n-1 || b < a.get(mid+1)) && a.get(mid) == b){
                return mid;
            }else if(b < a.get(mid)) 
                return getEnd(a, b, low, (mid - 1)); 
            else
                return getEnd(a, b, (mid +1), high); 
            
        }
        return -1;
    }
	
}
