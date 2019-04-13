package com.sample.test;

import java.util.ArrayList;
import java.util.TreeMap;

public class OrderStanding {
	
	public static void main(String[] args) {
		int heights[] = { 86, 92, 49, 21, 62, 27, 90, 59 };
		int infronts[] = {0, 1, 2, 0, 3, 2};
		
		orderStandingQueue(heights, infronts);
	}
	
	public static void orderStandingQueue(int[] heights, int[] infronts) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int i=0; i<heights.length; i++) {
            map.put(heights[i], infronts[i]);
        }

        while(!map.isEmpty()) {
            int height = map.lastKey();
            int taller = map.get(height);
            map.remove(height);


            if (result.isEmpty()){
                result.add(height);
            } else if (taller == 0) {
                result.add(0,height);
            } else {
                result.add(taller,height);
            }
        }
        System.out.println(result.toString());
    }

}
