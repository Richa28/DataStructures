package com.sample.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HackerRankTest {

	public static void main(String args[]) {
		System.out.println("HEllo world");
		int[] arr = new int[] {1456,345671, 43218, 123};
		//HackerRankTest.findQualifiedNumbers(arr);
		HackerRankTest.findPossibleSmallestNumberMatchingPattern2("NON");
	}
	
	static String findQualifiedNumbers(int[] numberArray) {
		
		List<Integer> list = new LinkedList<>();
		String output = "";
		
		for(int i=0;i<numberArray.length; i++) {
			String stringNumber = numberArray[i] + "";
			boolean found1=false;
			boolean found2 = false;
			boolean found3=false;
			for(int j=0;j<stringNumber.length();j++) {
				if(stringNumber.charAt(j)=='1') {
					found1=true;
				}else if(stringNumber.charAt(j)=='2') {
					found2=true;
				}else if(stringNumber.charAt(j)=='3') {
					found3=true;
				}
			}
			if(found1 && found2 && found3) {
				list.add(numberArray[i]);
			}
		}
		
		Collections.sort(list);
		
		if(list.size() > 0) {
			for(int i=0;i<list.size()-1;i++) {
				output = output + list.get(i) + ",";
			}
			
			output = output + list.get(list.size()-1);	
		}else {
			output = "-1";
		}
		
		
		return output;

    }
	
	
	static int findPossibleSmallestNumberMatchingPattern(String pattern) {
		Map<Integer,Boolean> usedMap = new HashMap<>();
		usedMap.put(1, false);
		usedMap.put(2, false);
		usedMap.put(3, false);
		usedMap.put(4, false);
		usedMap.put(5, false);
		usedMap.put(6, false);
		usedMap.put(7, false);
		usedMap.put(8, false);
		usedMap.put(9, false);
		
		int lastChar = -1;
		String outputNumber = "";
		boolean noOutputPossible = false;
		
		for(int i=0;i<pattern.length();i++) {
			if(pattern.charAt(i)=='M') {
				if(lastChar == -1) {
					outputNumber = outputNumber+"21";
					usedMap.put(1, true);
					usedMap.put(2, true);
					lastChar = 1;
				}else {
					int tempNum = Integer.parseInt(outputNumber.charAt(lastChar)+"");
					for(Map.Entry<Integer, Boolean> entry:usedMap.entrySet()) {
						if(entry.getKey()<tempNum && entry.getValue()==false) {
							outputNumber+=entry.getKey();
							usedMap.put(entry.getKey(), true);
							lastChar++;
							break;
						}
					}
				}
			}else if(pattern.charAt(i)=='N') {
				if(lastChar == -1) {
					outputNumber = outputNumber+"12";
					usedMap.put(1, true);
					usedMap.put(2, true);
					lastChar = 1;
				}else {
					int tempNum = Integer.parseInt(outputNumber.charAt(lastChar)+"");
					for(Map.Entry<Integer, Boolean> entry:usedMap.entrySet()) {
						if(entry.getKey()>tempNum && entry.getValue()==false) {
							outputNumber+=entry.getKey();
							usedMap.put(entry.getKey(), true);
							lastChar++;
							break;
						}
					}
				}
			}else {
				noOutputPossible = true;
				break;
			}
		}
		
		if(noOutputPossible) {
			outputNumber = "-1";
		}
		
		int output = Integer.parseInt(outputNumber);
		
		return output;

    }
	
	static int findPossibleSmallestNumberMatchingPattern2(String pattern) {
		if(pattern.length()>8 || pattern==null || pattern.equals("") || pattern.indexOf(" ")!=-1) {
			return -1;
		}
		
		boolean noOutputPossible = false;
		
		int min = 1, posOfM = 0;
		List<Integer> list = new LinkedList<>();
		String ouptutNumber = "";
		if(pattern.charAt(0)=='N') {
			list.add(1);
			list.add(2);
			min=3;
			posOfM=1;
		}else if(pattern.charAt(0)=='M') {
			list.add(2);
			list.add(1);
			min = 3;
			posOfM = 0;
		}else {
			noOutputPossible = true;
		}
		
		for(int i=1;i<pattern.length() && noOutputPossible;i++) {
			if(pattern.charAt(i)=='N') {
					list.add(min);
					min++;
					posOfM=i+1;	
			}else if(pattern.charAt(i)=='M'){
				list.add(list.get(i));
				for(int j=posOfM;j<=i;j++) {
					int temp = list.get(j);
					list.remove(j);
					temp++;
					list.add(j, temp);
				}
				min++;
			}else {
				ouptutNumber = "-1";
				noOutputPossible = true;
				break;
			}
		}
		
		for(int i=0;i<list.size();i++) {
			int n = list.get(i);
			for(int j=0;j<list.size();j++) {
				if(n==list.get(j) && i!=j) {
					noOutputPossible = true;
					ouptutNumber = "-1";
					break;
				}
			}
			ouptutNumber = ouptutNumber+list.get(i);
		}
		
		if(noOutputPossible) {
			ouptutNumber = "-1";
		}
		
		return Integer.parseInt(ouptutNumber);
		
	}
	
	static int findPossibleSmallestNumberMatchingPattern1(String pattern) {
		int curr_max =0;
		int lastEntry = 0;
		String outputString = "";
		
		int j;
		for(int i=0;i<pattern.length();i++) {
			int nextM = 0;
			if(pattern.charAt(i)=='N') {
				j=i+1;
				while(pattern.charAt(i)=='M' && j<pattern.length()) {
					nextM++;
					j++;
				}
				if(i==0) {
					curr_max = nextM+2;
					outputString+=(++lastEntry)+curr_max;
					lastEntry = curr_max;
				}else {
					curr_max = curr_max + nextM + 1;
					lastEntry = curr_max;
					outputString = outputString+lastEntry;
				}
				
				for(int k=0;k<nextM;k++) {
					//--lastEntry;
					outputString = outputString+(--lastEntry); 
				}
			}else if(pattern.charAt(i)=='M') {
				if(i==0) {
					j=i+1;
					while(pattern.charAt(i)=='M' && j<pattern.length()) {
						nextM++;
						j++;
					}
					
					curr_max = nextM + 2;
					outputString = outputString+curr_max+(curr_max-1);
					lastEntry = curr_max -1;
				}else {
					outputString = outputString+(lastEntry-1);
					lastEntry--;
				}
			}else {
				//No ouptut possible
				outputString = "-1";
			}
		}
		return Integer.parseInt(outputString);
	}
	
	
}
