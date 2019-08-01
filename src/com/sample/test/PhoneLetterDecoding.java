package com.sample.test;

import java.util.ArrayList;

public class PhoneLetterDecoding {

	String hashTable[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
	public static void main(String[] args) {
		PhoneLetterDecoding obj = new PhoneLetterDecoding();
		ArrayList<String> res = obj.letterCombinations("2");
		for(String s : res) {
			System.out.println(s);
		}
	}

	public ArrayList<String> letterCombinations(String A) {
		int n = A.length();
		ArrayList<String> result = new ArrayList<>();
		printWordsUtil(A, 0, result, n);
		return result;
	}

	void printWordsUtil(String number, int curr_digit, ArrayList<String> output, int n) {
		int i;
		if (curr_digit == n) {
			return;
		}

		for (i = 0; i < hashTable[Integer.parseInt(number.charAt(curr_digit) + "")].length(); i++) {
			output.add(hashTable[Integer.parseInt(number.charAt(curr_digit) + "")].charAt(i) + "");
			printWordsUtil(number, curr_digit + 1, output, n);
			if (number.charAt(curr_digit) == 0 || number.charAt(curr_digit) == 1)
				return;
		}
	}

}
