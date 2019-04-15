package com.sample.test;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "GEEKSGEEKSFOR";
		LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
		System.out.println(obj.longestSubstring(str));
	}
	
	private int longestSubstring(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		
		int n = str.length();
		if(n == 1) {
			return 1;
		}
		
		int maxLength = 1, currLen = 1;
		int []visited = new int[256];
		Arrays.fill(visited, -1);
		visited[str.charAt(0)] = 0;
		
		for(int i=1; i<n; i++) {
			int prevIndex = visited[str.charAt(i)];
			if(prevIndex == -1 || i - prevIndex > currLen)
				currLen++;
			else {
				currLen = i - prevIndex;
				maxLength = Math.max(currLen, maxLength);
			}
			visited[str.charAt(i)] = i;
		}
		
		maxLength = Math.max(maxLength, currLen);
		return maxLength;
	}
	
}
