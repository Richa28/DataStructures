package com.sample.test;

public class ConvertRomanToDecimal {

	public static void main(String[] args) {
		ConvertRomanToDecimal obj = new ConvertRomanToDecimal();
		System.out.println(obj.convertRomanToDecimal("MMMDXLIX"));
	}
	
	public int convertRomanToDecimal(String roman) {
		int n = roman.length();
		int num = 0;
		
		for(int i=0; i<n; i++) {
			char ch = roman.charAt(i);
			int val1 = valueOf(ch);
			if(i<n-1) {
				char ch2 = roman.charAt(i+1);
				int val2 = valueOf(ch2);
				if(val2 > val1) {
					num += val2-val1;
					i++;
				}else {
					num += val1;
				}
			}else {
				num += val1;
			}
		}
		
		return num;
	}
	
	private int valueOf(char ch) {
		int val = 0;
		switch (ch) {
		case 'I' : val = 1;
			break;
		case 'V' : val = 5;
			break;
		case 'X' : val = 10;
			break;
		case 'L' : val = 50;
			break;
		case 'C' : val = 100;
			break;
		case 'D' : val = 500;
			break;
		case 'M' : val = 1000;
			break;
		}
		return val;
	}
	
}
