package com.sample.test;

import java.util.Arrays;

/**
 * Given two strings string1 and string2, 
 * the task is to find the smallest substring in string1 
 * containing all characters of string2 efficiently.
 * 
 * Input: string = “this is a test string”, pattern = “tist”
 * Output: Minimum window is “t stri”
 * Explanation: “t stri” contains all the characters of pattern.
 * 
 * @author Richa
 *
 */
public class FindSmallesWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindSmallesWindow obj= new FindSmallesWindow();
		System.out.println(obj.smallestWindow("this is a test string", "tist"));
		System.out.println(obj.smallestWindow("geeksforgeeks", "ork"));
		System.out.println(obj.smallestWindow("", "ork"));
		System.out.println(obj.smallestWindow("geeksforgeeks", "geeksforgeeksafd"));
		System.out.println(obj.smallestWindow("geeksforgeeks", "geeksforgeeks"));
	}
	
	private int smallestWindow(String str, String pat) {
		if(str == null) {
			return -1;
		}
		if(pat == null || pat.isEmpty()) {
			return -1;
		}
		
		int n = str.length();
		int m = pat.length();
		if(n<m) {
			return -1;
		}
		
		int[] hash_pat = getHashPattern(pat);
		int[] hash_str = new int[256];
		Arrays.fill(hash_str, 0);
		
		int max_len = Integer.MAX_VALUE, start = 0, startIndex = -1, count = 0;
		
		for(int i=0; i<n; i++) {
			char c = str.charAt(i);
			hash_str[c]++;
			if(hash_str[c] <= hash_pat[c] && hash_pat[c] != 0) {
				count++;
			}
			
			if(count == m) {
				while(hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]
						|| hash_pat[str.charAt(start)] == 0) {
					hash_str[str.charAt(start)]--;
					start++;
				}
				
				int len = i-start+1;
				if(len<max_len) {
					max_len = len;
					startIndex = start;
				}
			}
		}
		
		String res = str.substring(startIndex, startIndex+max_len);
		System.out.println(res);
		
		return max_len;
	}
	
	private int[] getHashPattern(String pat) {
		int[] hash_pat = new int[256];
		Arrays.fill(hash_pat, 0);
		
		for(int i=0; i<pat.length(); i++) {
			hash_pat[pat.charAt(i)]++;
		}
		
		return hash_pat;
	}

}
