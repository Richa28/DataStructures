package com.sample.test;

import java.util.ArrayList;

public class AddInterval {

	public static void main(String[] args) {
		AddInterval obj = new AddInterval();
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(obj.new Interval(3, 5));
		intervals.add(obj.new Interval(8, 10));
		intervals.add(obj.new Interval(21, 23));
		
		ArrayList<Interval> output = obj.insert(intervals, obj.new Interval(18, 25));
		
		for(Interval interval : output) {
			System.out.println(interval.start + "  " + interval.end);
		}

	}
	
public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        int n = intervals.size();
        Interval curr = newInterval;
        int i=0;
        
        while(i<n){
            Interval in = intervals.get(i);
            if(curr.start >= in.end){
                i++;
            }else if(curr.end <= in.start){
                intervals.add(i, curr);
                break;
            }else{
                curr.start = Math.min(in.start, curr.start);
                curr.end = Math.max(in.end, curr.end);
                intervals.remove(i);
                n = intervals.size();
            }
        }
        
        if(i == n){
            intervals.add(curr);
        }
        
        return intervals;
    }

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
}
