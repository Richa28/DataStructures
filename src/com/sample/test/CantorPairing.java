package com.sample.test;

public class CantorPairing {

	public static void main(String[] args) {
		CantorPairing obj = new CantorPairing();
		
		long z = obj.pair(15,18);
		System.out.println("F(x,y): "+z);
		obj.dePair(z);
	}
	
	private long pair(long a, long b) {
		long result = (long)(0.5 * ( a + b ) * ( a + b + 1 ) + b);
		return result;
	}
	
	private void dePair(long z) {
		long t = (long)(Math.floor((Math.sqrt(8*z+1) - 1) / 2 ));
		long x = t * (t+3)/2 -z;
		long y = z - t * (t+1)/2;
		
		System.out.println("x: "+x+"  y: "+y);
	}

}
