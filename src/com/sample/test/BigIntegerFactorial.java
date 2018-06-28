package com.sample.test;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerFactorial {

	static void extraLongFactorials(int n) {
		BigInteger f = new BigInteger("1"); // Or BigInteger.ONE
		 
        for (int i = 2; i <= n; i++)
            f = f.multiply(BigInteger.valueOf(i));
        
        System.out.print(f);
    }
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
	
}
