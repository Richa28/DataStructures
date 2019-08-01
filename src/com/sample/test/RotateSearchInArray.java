package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class RotateSearchInArray {

	public static void main(String[] args) {
		RotateSearchInArray obj = new RotateSearchInArray();
		int arr[] = {19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17 };
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<arr.length; i++) {
			list.add(arr[i]);
		}
		System.out.println(obj.search(list, 6));
	}
	
	public int search(final List<Integer> a, int b) {
        int n = a.size();
        int pivot = findPivot(a, 0, n-1);
        System.out.println("Pivot: "+pivot);
        int index = -1;
        if(pivot == -1){
            index = binarySearch(a,b,0,n-1);
        }
        else if(a.get(pivot) == b){
            index = pivot;
        }else if(a.get(0) <= b){
            index = binarySearch(a, b, 0, pivot-1);
        }else{
            index = binarySearch(a, b, pivot + 1, n-1);
        }
        return index;
    }
    
    private int binarySearch(List<Integer> a, int b, int low, int high){
        if(high < low){
            return -1;
        }
        
        int mid = low + (high - low)/2;
        if(a.get(mid) == b){
            return mid;
        }
        if(a.get(mid) > b){
            return binarySearch(a, b, low, mid-1);
        }
        return binarySearch(a, b, mid+1, high);
    }
    
    private int findPivot(List<Integer> a, int low, int high){
        if(high < low){
            return -1;
        }
        if(high == low)
        	return low;
        
        int mid = low + (high - low)/2;
        if(mid < high && a.get(mid) > a.get(mid + 1)){
            return mid;
        }
        if(mid > low && a.get(mid) < a.get(mid-1)){
            return mid-1;
        }
        if(a.get(mid) <= a.get(low)){
            return findPivot(a, low, mid-1);
        }
        return findPivot(a, mid+1, high);
    }

}
