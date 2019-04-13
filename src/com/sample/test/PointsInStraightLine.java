package com.sample.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsInStraightLine {
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(0);
		a.add(0);
		a.add(1);
		
		List<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(-1);
		b.add(-1);
		
		int points = maxPoints(a, b);
		System.out.println(points);
	}

	public static int maxPoints(List<Integer> a, List<Integer> b) {
        int n1 = a.size();
        int n2 = b.size();
        
        if(n1!=n2){
            return 0;
        }
        
        Map<Double, Integer> map = new HashMap<>(); 
        for(int i=0; i<n1-1; i++){
            int x1 = a.get(i);
            int x2 = a.get(i+1);
            int y1 = b.get(i);
            int y2 = b.get(i+1);
            
            double slope = getSlope(x1,x2,y1,y2);
            int val = 0;
            if(map.containsKey(slope)){
                val = map.get(slope);
            }
            
            map.put(slope, val+1);
        }
        
        int res = 1;
        for(double d: map.keySet()){
            int val = map.get(d);
            res = Math.max(res, val);
        }
        
        return res;
    }
    
    private static double getSlope(int x1, int x2, int y1, int y2){
        double slope = (double)(y2-y1)/(x2-x1);
        return slope;
    }
	
}
