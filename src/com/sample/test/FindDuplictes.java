package com.sample.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplictes {

	public static void main(String[] args){
                List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(9);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
         int result = FindDuplictes.countDuplicates2(numbers);
System.out.println(result);
            }
	
	public static int countDuplicates2(List<Integer> numbers) {
        int repeatCount = 0;
        int size = numbers.size();
        Integer arr[] = numbers.toArray(new Integer[size]);
        Map<Integer,Integer> countMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
           if(countMap.containsKey(arr[i])) {
        	   int count = countMap.get(arr[i]);
        	   if(count == 1) {
        		   repeatCount++;
        		   count++;
            	   countMap.put(arr[i], count);
        	   }
           }else {
        	   countMap.put(arr[i], 1);
           }
        }

        return repeatCount;

    }
	
	public static int countDuplicates(List<Integer> numbers) {
        int repeatCount = 0;
        int size = numbers.size();
        Integer arr[] = numbers.toArray(new Integer[size*2]);

        for (int i = 0; i < size; i++) {
            if (arr[Math.abs(arr[i])] >= 0)
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            else
                repeatCount++;
        }

        return repeatCount;

    }

}
	
