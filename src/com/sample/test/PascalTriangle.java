package com.sample.test;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle obj = new PascalTriangle();
		obj.printPascalTriangle(5);
	}
	
	public void printPascalTriangle(int n) {
		for(int i=0; i<n; i++) {
			int C = 1;
			int line = i+1;
			for(int j = 1; j <= line; j++) {
				System.out.print(C);
				C = C * (line - j)/j;
			}
			System.out.println();
		}
	}

}
