package com.sample.test;

public class LexicographicallySmallestNLargestString {

	public static void main(String[] args) {
		LexicographicallySmallestNLargestString obj = new LexicographicallySmallestNLargestString();
		String str = "hello";
		int k = 2;
		obj.printLargestAndSmallestString(k, str);
	}
	
	public void printLargestAndSmallestString(int k, String str) {
		int n = str.length();
		if(n < k || (n==0 && k==0)) {
			return;
		}
		
		String currStr = str.substring(0, k);
		String lexMax = currStr;
		String lexMin = currStr;
		
		for (int i = k; i < str.length(); i++) { 
			currStr = currStr.substring(1, k) + str.charAt(i); 
			if (lexMax.compareTo(currStr) < 0)	 
				lexMax = currStr; 
			if (lexMin.compareTo(currStr) > 0) 
				lexMin = currStr;			 
		} 
		
		System.out.println("Maximum string: " + lexMax);
		System.out.println("Minimum string: " + lexMin);
	}

}
