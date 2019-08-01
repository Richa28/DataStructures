package com.sample.test;

public class PrintBalancedParanthesis {

	public static void main(String[] args) {
		PrintBalancedParanthesis obj = new PrintBalancedParanthesis();
		obj.printValidParanthesis(3);
	}
	
	public void printValidParanthesis(int n) {
		char str[] = new char[2 * n];
		printValidParanthesisUtil(str, 0, 0, 0, n);
	}
	
	private void printValidParanthesisUtil (char[] str, int index, int open, int close, int n) {
		if ( close == n ) {
			for ( int i = 0; i < str.length; i++ ) {
				System.out.print(str[i]);
			}
			System.out.println();
			return;
		}else {
			if ( close < open ) {
				str[index] = ')';
				printValidParanthesisUtil(str, index + 1, open, close + 1, n);
			}
			if ( open < n ) {
				str[index] = '(';
				printValidParanthesisUtil(str, index + 1, open + 1, close, n);
			}
		}
	}

}
