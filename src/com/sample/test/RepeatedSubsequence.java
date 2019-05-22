package com.sample.test;

public class RepeatedSubsequence {

	public static void main(String[] args) {
		RepeatedSubsequence obj = new RepeatedSubsequence();
		String str = "ABBB";
		System.out.println(obj.containsRepeatedSubsequence(str));
	}
	
	public boolean containsRepeatedSubsequence (String input) {
		int n = input.length();
		int[] charFrequency = new int[256];
		
		for(int i = 0; i<n; i++) {
			charFrequency[input.charAt(i)]++;
			if(charFrequency[input.charAt(i)] > 2) {
				return true;
			}
		}
		
		String stringWithoutNonRepeatingChars = removeNonRepeatingChars(input, charFrequency);
		int k = stringWithoutNonRepeatingChars.length();
		
		if(isPalindrome(stringWithoutNonRepeatingChars)) {
			if(k % 2 == 1 && stringWithoutNonRepeatingChars.charAt(k/2) == stringWithoutNonRepeatingChars.charAt(k/2 - 1)) {
					return true;
			}
			return false;
		}
		return true;
	}
	
	private boolean isPalindrome (String str) {
		int l = 0;
		int r = str.length() - 1;
		
		while (l < r) {
			if(str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		
		return true;
	}
	
	private String removeNonRepeatingChars (String input, int[] charFrequency) {
		int n = input.length();
		int k = 0;
		char inputArray[] = input.toCharArray();
		for (int i=0; i<n; i++) {
			if(charFrequency[inputArray[i]] > 1) {
				inputArray[k] = inputArray[i];
				k++;
			}
		}
		
		input = String.valueOf(inputArray);
		return input.substring(0,k);
	}

}
