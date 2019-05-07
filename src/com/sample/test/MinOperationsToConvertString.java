package com.sample.test;

public class MinOperationsToConvertString {
	
	public static void main(String[] args) {
		MinOperationsToConvertString obj = new MinOperationsToConvertString();
		System.out.println(obj.minOperations("EACBD", "EABCD"));
	}
	
	private int minOperations(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return -1;
		}
		
		if(!countChars(str1, str2)) {
			return -1;
		}
		
		int i=str1.length()-1;
		int j = i;
		int res = 0;
		
		while(i>=0) {
			if(str1.charAt(i) != str2.charAt(j)) {
				res++;
			}else {
				j--;
			}
			i--;
		}
		
		return res;
	}
	
	private boolean countChars(String str1, String str2) {
		int[] count = new int[256];
		
		for(int i=0; i<str1.length(); i++) {
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}
		
		for(int i=0; i<256; i++) {
			if(count[i] != 0) {
				return false;
			}
		}
		
		return true;
	}

}
