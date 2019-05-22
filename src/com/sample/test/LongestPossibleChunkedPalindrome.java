package com.sample.test;

public class LongestPossibleChunkedPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPossibleChunkedPalindrome obj = new LongestPossibleChunkedPalindrome();
		String str = "ghiabcdefhelloadamhelloabcdefghi";
		System.out.println(obj.longestPossibleChunkedPalindrome(0, str));
	}
	
	public int longestPossibleChunkedPalindrome(int palindromeCount, String curr_string) {
		if(curr_string == null || curr_string.isEmpty()) {
			return 0;
		}
		
		int stringLength = curr_string.length();
		for(int i = 0; i<stringLength/2; i++) {
			if(curr_string.substring(0, i+1).equals(curr_string.substring(stringLength-1-i,stringLength))) {
				return longestPossibleChunkedPalindrome(palindromeCount+2, curr_string.substring(i+1,stringLength-1-i));
			}
		}
		
		return palindromeCount + 1;
	}
}
