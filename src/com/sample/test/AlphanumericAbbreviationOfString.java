package com.sample.test;

import java.util.Deque;
import java.util.LinkedList;

public class AlphanumericAbbreviationOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlphanumericAbbreviationOfString obj = new AlphanumericAbbreviationOfString();
		obj.printAlphanumericAbbreviation("ABCD");
	}

	public void printAlphanumericAbbreviation(String str) {
		Deque<Character> st = new LinkedList<>();
		printAlphanumericAbbreviationUtil(str, 0, str.length(), st);
	}
	
	private void printAlphanumericAbbreviationUtil(String str, int index, int max_length, Deque<Character> st) {
		if(index == max_length) {
			for(Character c : st) {
				System.out.print(c);
			}
			System.out.println();
			return;
		}
		
		st.addLast(str.charAt(index));
		printAlphanumericAbbreviationUtil(str, index+1, max_length, st);
		st.removeLast();
		
		int count = 1;
		
		if(!st.isEmpty()) {
			if(Character.isDigit(st.peekLast())) {
				count = count + (int)(st.removeLast() - '0');
			}
		}
		
		st.addLast((char)(count + '0'));
		printAlphanumericAbbreviationUtil(str, index+1, max_length, st);
	}
	
}
