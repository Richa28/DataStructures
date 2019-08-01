package com.sample.test;

public class AddBinaryNumbers {

	public static void main(String[] args) {
		AddBinaryNumbers obj = new AddBinaryNumbers();
		System.out.println(obj.addNumbers("1100", "100"));
	}

	public String addNumbers(String str1, String str2) {
		String result = "";
		
		int m = str1.length();
		int n = str2.length();
		
		int i = m-1;
		int j = n-1;
		
		int s = 0;
		
		while(i >= 0 || j >= 0 || s == 1) {

			s += i >= 0 ? Integer.parseInt(String.valueOf(str1.charAt(i))) : 0;
			s += j >= 0 ? Integer.parseInt(String.valueOf(str2.charAt(j))) : 0;
			
			result = (char)(s % 2 + '0') + result;
			
			s = s / 2;
			i--;
			j--;
		}
		
		return result;
	}
	
}
