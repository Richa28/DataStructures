package com.sample.test;

public class ModularArithmetic {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModularArithmetic obj = new ModularArithmetic();
		System.out.println(obj.getModularArithmetic(2, 5, 13));
	}
	
	public int getModularArithmetic(int x, int y, int p) {
		int res = 1;
		x = x % p;
		
		while(y>0) {
			if(y%2 == 1) {
				res = (res * x) % p;
			}
			y = y/2;
			x = (x*x) % p;
		}
		return res;
	}

}
