package com.sample.test;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
		int B = -3;
		int[] res = twoSum(A, B);
		System.out.println(res[0]+" "+res[1]);
	}
	
	public static int[] twoSum(final int[] A, int B) {
	        
		int n = A.length;
	    int res[] = new int[2];
	    
	    if(n == 0 || n == 1){
	        return res;    
	    }
	    
	    int[] tempArr = Arrays.copyOf(A, n);
	    Arrays.sort(A);
	    
	    int i=0, j=n-1;
	    int first = -1, second = -1;
	    
	    while(i<j){
	        int temp = A[i] + A[j];
	        if(temp == B){
	            first = A[i];
	            second = A[j];
	            break;
	        }else if(temp < B){
	            i++;
	        }else{
	            j--;
	        }
	    }
	    
	    res = getIndexes(first, second, tempArr);
	    return res;
	}
	
	private static int[] getIndexes(int a, int b, int[] arr) {
		int[] res = new int[2];
		boolean res1=false, res2 = false;
		for(int i=0; i<arr.length; i++) {
			if(!res1 || !res2) {
				if(a==arr[i]) {
					res[0] = i;
					res1=true;
				}else if(b==arr[i]) {
					res[1] = i;
					res2=true;
				}	
			}
		}
		return res;
	}

}
