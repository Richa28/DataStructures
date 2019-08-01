package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("i");
		list.add("like");
		list.add("sam");
		list.add("sung");
		list.add("samsung");
		list.add("mobile");
		
		String word = "ilikesamsungmobile";
		WordBreak obj = new WordBreak();
		obj.wordBreak(word, list);
	}
	
	private void wordBreak(String word, List<String> dictionary) {
		wordBreakUtil(word, dictionary, "");
	}
	
	private void wordBreakUtil(String word, List<String> dictionary, String result) {
		if(word.isEmpty()) {
			System.out.println(result);
			return;
		}
		
		for(int i=1; i<=word.length(); i++) {
			String prefix = word.substring(0, i);
			
			if(dictionary.contains(prefix)) {
				wordBreakUtil(word.substring(i), dictionary, result + prefix + " ");
			}
		}
	}

}
