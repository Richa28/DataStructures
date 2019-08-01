package com.sample.test;

import java.util.HashMap;
import java.util.Map;

public class RepeatingFraction {

	public static void main(String[] args) {
		RepeatingFraction obj = new RepeatingFraction();
		int numerator = 50;
		int denominator = 22;
		System.out.println(obj.printRepeatingFraction(numerator, denominator));
		System.out.println(obj.printRepeatingFraction(1, 6));
		System.out.println(obj.printRepeatingFraction(11, 2));
	}

	public String printRepeatingFraction(int numerator, int denominator) {
		String res = "";
		if(denominator == 0 || numerator == denominator) {
			return res;
		}
		
		int result = numerator / denominator;
		String decoratedOuptut = String.valueOf(result) + ".";
		
		int remainder = numerator % denominator;
		Map<Integer, Integer> map = new HashMap<>();
		
		while( remainder != 0 && !map.containsKey(remainder)) {
			map.put(remainder, res.length());
			
			remainder = remainder * 10;
			int temp = remainder / denominator;
			res = res + temp;
			remainder = remainder % denominator;
		}
		decoratedOuptut = decorateOuput(decoratedOuptut, remainder, res, map);
		
		return decoratedOuptut;
	}
	
	private String decorateOuput(String decoratedOutput, int remainder, String res, Map<Integer, Integer> map) {
		if(remainder == 0) {
			decoratedOutput += "0";
		}else {
			decoratedOutput += res.substring(0, map.get(remainder));
			decoratedOutput += "[";
			decoratedOutput += res.substring(map.get(remainder));
			decoratedOutput += "]";
		}
		
		return decoratedOutput;
	}
	
}
