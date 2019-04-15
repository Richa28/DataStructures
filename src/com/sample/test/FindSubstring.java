package com.sample.test;

import java.util.Arrays;

public class FindSubstring {

	public static void main(String[] args) {
		FindSubstring obj = new FindSubstring();
		System.out.println(obj.findNumberOfRepetition("abcd", "bcdabcda"));
	}
	
	private int findNumberOfRepetition(String a, String b) {
		int n = a.length();
		int m = b.length();
		
		if(m<n) {
			return -1;
		}
		
		int res = -1;
		
		int[] count1 = new int[256];
		int[] count2 = new int[256];
		
		Arrays.fill(count1, 0);
		Arrays.fill(count2, 0);
		
		for(int i =0; i<a.length(); i++) {
			count1[a.charAt(i)]++;
		}
		
		for(int i=0; i<b.length(); i++) {
			if(count1[b.charAt(i)] == 0) {
				return -1;
			}
			count2[b.charAt(i)]++;
		}
		
		for(int i=0; i<256; i++) {
			if(count1[i] != 0) {
				res = Math.max(res, count2[i]/count1[i]);
			}
		}
		
		if(a.charAt(0) != b.charAt(0))
			res++;
		
		return res;
	}
	
}
