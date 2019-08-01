package com.sample.test;

import java.util.ArrayList;

public class DutchNationalFlag {

	public static void main(String[] args) {
		DutchNationalFlag obj = new DutchNationalFlag();
		int arr[] = {0, 1, 2, 0, 1, 2};
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			list.add(arr[i]);
		}
		obj.sortColors(list);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i));
		}
	}
	
	public void sortColors(ArrayList<Integer> a) {
        
        int n = a.size();
        int low = 0, mid = 0, high = n-1;
        
        while(mid <= high) {
            if(a.get(mid) == 1){
                mid++;
            }else if(a.get(mid) == 0){
                int temp = a.get(low);
                a.set(low, a.get(mid));
                a.set(mid, temp);
                mid++;
                low++;
            }else{
                int temp = a.get(high);
                a.set(high, a.get(mid));
                a.set(mid, temp);
                high--;
            }
        }
        
    }

}
