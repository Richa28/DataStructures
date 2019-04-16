package com.sample.test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class WordBreakProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dictionary = new HashSet<>();
		dictionary.add("mobile");
		dictionary.add("samsung");
		dictionary.add("sam");
		dictionary.add("sung");
		dictionary.add("man");
		dictionary.add("mango");
		dictionary.add("icecream");
		dictionary.add("and");
		dictionary.add("go");
		dictionary.add("i");
		dictionary.add("love");
		dictionary.add("ice");
		dictionary.add("cream");
		
		WordBreakProblem obj = new WordBreakProblem();
		System.out.println(obj.wordBreak("iloveicecreamandmango", dictionary));
	}
	
	public boolean wordBreak(String str, Set<String> dictionary) {
		int size = str.length();
		if(size == 0) {
			return true;
		}
		
		for(int i = 1; i<=size; i++) {
			if(dictionary.contains(str.substring(0, i)) && wordBreak(str.substring(i, size), dictionary))
				return true;
		}
		
		return false;
	}

}
