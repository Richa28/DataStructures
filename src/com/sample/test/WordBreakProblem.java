package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class WordBreakProblem {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("i");
		list.add("like");
		list.add("sam");
		list.add("sung");
		list.add("samsung");
		list.add("mobile");
		
		String word = "ilikesamsungmobile";
		WordBreakProblem obj = new WordBreakProblem();
		System.out.println(obj.wordBreak(word, list));
	}
	
	public boolean wordBreak(String str, List<String> dictionary) {
		int size = str.length();
		if(size == 0) {
			return true;
		}
		
		for(int i = 1; i<=size; i++) {
			if(dictionary.contains(str.substring(0, i)) && wordBreak(str.substring(i), dictionary))
				return true;
		}
		
		return false;
	}

}
