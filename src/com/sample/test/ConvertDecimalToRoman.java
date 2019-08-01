package com.sample.test;

public class ConvertDecimalToRoman {

	public static void main(String[] args) {
		ConvertDecimalToRoman obj = new ConvertDecimalToRoman();
		System.out.println(obj.decimalToRoman(3549));
	}
	
	public String decimalToRoman(int num) {
		String[] thousands = {"","M", "MM", "MMM"};
		String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX" , "LXXX", "XC"};
		String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		
		String result = "";
		
		result += thousands[num/1000];
		result += hundreds[(num%1000) / 100];
		result += tens[(num%100) / 10];
		result += ones[num%10];
		
		return result;
	}
	
}
