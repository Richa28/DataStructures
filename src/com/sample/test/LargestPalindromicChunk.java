package com.sample.test;

public class LargestPalindromicChunk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestPalindromicChunk obj = new LargestPalindromicChunk();
		String str = "ghiabcdefhelloadamheabcdefghi";
		System.out.println(obj.getLargestChunk(str, 0, 0, str));
		
		str = "geekforgeek";
		System.out.println(obj.getLargestChunk(str, 0, 0, str));
	}
	
	private int getLargestChunk(String curr, int count, int len, String str) {
		
		if(curr == null || curr.isEmpty()) {
			return 0;
		}
		
		if(curr.length() <= 1) {
			if(count !=0 || str.length() - len <= 1) {
				return count+1;
			}else {
				return 1;
			}
		}
		
		int n = curr.length();
		for(int i=0; i<n/2; i++) {
			if(curr.substring(0, i+1).equals(curr.substring(n-1-i, n))) {
				return getLargestChunk(curr.substring(i+1, n-i-1), count+2, len + (i+1)*2, str);
			}
		}
		
		
		return count + 1;
	}

}
