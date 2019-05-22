package com.sample.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PrintAllPalindromicPartitions {

	public static void main(String[] args) {
		PrintAllPalindromicPartitions obj = new PrintAllPalindromicPartitions();
		String str = "nitin";
		obj.printAllPartitions(str);
	}
	
	public void printAllPartitions(String input) {
		int n = input.length();
		List<List<String>> output = new ArrayList<>();
		Deque<String> deque = new LinkedList<>();
		printAllPartitionsUtil(input, output, deque, 0, n);
		
		for (int i = 0; i < output.size(); i++)  
        { 
            for (int j = 0; j < output.get(i).size(); j++) 
            { 
                System.out.print(output.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } 
	}
	
	private void printAllPartitionsUtil(String input, List<List<String>> allParts, Deque<String> currPart, int start, int n) {
		if(start >= n) {
			allParts.add(new ArrayList<>(currPart));
			return;
		}
		for(int i=start; i<n; i++) {
			if(isPalindrome(input.substring(start, i+1))) {
				currPart.addLast(input.substring(start, i+1));
				printAllPartitionsUtil(input, allParts, currPart, i+1, n);
				currPart.removeLast();
			}
		}
	}
	
	private boolean isPalindrome (String str) {
		int n = str.length();
		int i = 0, j = n-1;
		while(i<=j) {
			if(str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

}
