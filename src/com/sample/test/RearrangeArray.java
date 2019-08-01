package com.sample.test;

import java.util.ArrayList;

public class RearrangeArray {

	public static void main(String[] args) {
		RearrangeArray obj = new RearrangeArray();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(0);
		list.add(2);
		list.add(1);
		list.add(3);
		obj.arrange(list);
		
		for(int i:list) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	public void arrange(ArrayList<Integer> a) {
        
        int n = a.size();
        for(int i=0; i<n; i++){
            if(a.get(i) != i){
                int temp = a.get(a.get(i));
                a.set(a.get(i), a.get(i));
                a.set(i, temp);
            }
        }
        
    }

}
