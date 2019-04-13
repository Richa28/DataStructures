package com.sample.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals obj = new MergeIntervals();
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(obj.new Interval(30,63));
		intervals.add(obj.new Interval(66, 94));
		intervals.add(obj.new Interval(36, 87));
		intervals.add(obj.new Interval(16, 86));
		intervals.add(obj.new Interval(26, 85));
		intervals.add(obj.new Interval(24, 50));
		intervals.add(obj.new Interval(17, 84));
		intervals.add(obj.new Interval(5, 25));
		intervals.add(obj.new Interval(67, 81));
		intervals.add(obj.new Interval(23, 54));
		intervals.add(obj.new Interval(84, 99));
		intervals.add(obj.new Interval(48, 85));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(3, 86));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(23, 28));
		intervals.add(obj.new Interval(23, 28));
		
		obj.merge(intervals);
	}
	
public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<>();
        
        if(n == 0){
            return result;    
        }
        
        if(n ==1){
            return intervals;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start > o2.start ? 1 : 0;
            }
            
        });
        
        Stack<Interval> stack = new Stack<>();
        
        for(int i=0; i<n; i++){
            if(stack.isEmpty()){
                stack.push(intervals.get(i));
            }else{
                Interval prev = stack.peek();
                Interval curr = intervals.get(i);
                
                if(prev.end > curr.start){
                    stack.pop();
                    Interval newInterval = new Interval(Math.min(prev.start, curr.start), Math.max(prev.end, curr.end));
                    stack.push(newInterval);
                }else{
                    stack.push(curr);
                }
            }
        }
        
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }

        return result;
    }

	class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }

}
