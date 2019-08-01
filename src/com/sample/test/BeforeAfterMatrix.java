package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class BeforeAfterMatrix {
	
	public static void main(String[] args) {
		List<List<Integer>> after = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(33);
		temp.add(94);
		temp.add(56);
		temp.add(34);
		temp.add(77);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(89);
		temp.add(27);
		temp.add(55);
		temp.add(74);
		temp.add(3);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(38);
		temp.add(20);
		temp.add(90);
		temp.add(45);
		temp.add(60);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(98);
		temp.add(65);
		temp.add(58);
		temp.add(18);
		temp.add(14);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(2);
		temp.add(64);
		temp.add(11);
		temp.add(1);
		temp.add(79);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(4);
		temp.add(67);
		temp.add(78);
		temp.add(13);
		temp.add(53);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(98);
		temp.add(68);
		temp.add(90);
		temp.add(2);
		temp.add(62);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(13);
		temp.add(1);
		temp.add(34);
		temp.add(75);
		temp.add(95);
		after.add(temp);
		temp = new ArrayList<>();
		temp.add(23);
		temp.add(16);
		temp.add(39);
		temp.add(95);
		temp.add(42);
		after.add(temp);
		findMatrix(after);
	}
	
	public static List<List<Integer>> findMatrix(List<List<Integer>> after) {
        int n = after.size();
        int m = after.get(0).size();

        List<List<Integer>> before = new ArrayList<>();
        
        for(int i=0; i<n; i++){
        	
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<m; j++){
                if( i == 0 && j == 0){
                    temp.add(j,after.get(i).get(j));
                }else{
                    int val = after.get(i).get(j);
                    int x = i;
                    while(x>0) {
                    	val -= before.get(x-1).get(j);
                    	x--;
                    }
                    int y = j;
                    while(y>0) {
                    	val -= temp.get(y-1);
                    	y--;
                    }
                    
                    x = i;
                    y = j;
                    while(x>0) {
                    	while(y>0) {
                    		val -= before.get(x-1).get(y-1); 
                    		y--;
                    	}
                    	x--;
                    }
                    
                    temp.add(j, val);
                }
            }
            before.add(i, temp);
        }
        return before;
    }


}
