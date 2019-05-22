package com.sample.test;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr[] = {"aaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
		//String[] arr = {"abcd", "aze"};
		
		LongestCommonPrefix obj = new LongestCommonPrefix();
		System.out.println(obj.longestCommonPrefix(arr));
	}
	
	public String longestCommonPrefix(String[] words) {
		int minLength = getMinLength(words);
		
		int low = 0, high = minLength;
		String prefix = "";
		
		while(low<=high) {
			int mid = low + (high - low)/2;
			if(areAllContainPrefix(words, words[0], low, mid)) {
				if(mid+1 < words[0].length()) {
					prefix = prefix + words[0].substring(low, mid+1);	
				}			
				low = mid + 1;
			}else {
				high = mid - 1;
			}
		}
		
		return prefix;
	}
	
	private boolean areAllContainPrefix(String[] words, String word, int low, int high) {
		for(int i= 0; i<words.length; i++) {
			for(int j = low; j<=high && j<words[i].length() && j<word.length(); j++) {
				if(words[i].charAt(j) != word.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private int getMinLength(String[] words) {
		int min = Integer.MAX_VALUE, n = words.length;
		
		for(int i=0; i<n; i++) {
			min = Math.min(words[i].length(), min);
		}
		
		return min;
	}

}
