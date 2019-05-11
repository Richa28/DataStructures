package com.sample.test;

import java.util.Set;

public class WordBreakProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean wordBreak(String str, Set<String> dictionary) {
		int size = str.length();
		if(size == 0) {
			return true;
		}
		
		for(int i = 0; i<size; i++) {
			if(dictionary.contains(str.substring(0, i)) && wordBreak(str.substring(i, size-i), dictionary))
				return true;
		}
		
		return false;
	}

}
