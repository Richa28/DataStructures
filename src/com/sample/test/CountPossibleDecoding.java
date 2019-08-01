package com.sample.test;

public class CountPossibleDecoding {

	public static void main(String[] args) {
		CountPossibleDecoding obj = new CountPossibleDecoding();
		System.out.println(obj.countTotalDecoding("1234"));
	}

	public int countTotalDecoding(String str) {
		int n = str.length();
		int a = 1;
		int b = 1;
		int c = 0;
		
		for(int i=2; i<=n; i++) {
			
			if(str.charAt(i-1) >= '0') {
				c = b;
			}
			if(str.charAt(i-2) == '1' || (str.charAt(i-2) == '2' && str.charAt(i-1) < '7')) {
				c += a;
			}
			
			a = b;
			b = c;
		}
		
		return c;
		
	}
	
}
