package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FindSubset {

	static int nonDivisibleSubset(int k, int[] S) {
		int size = 0;
		
		int[] div = new int[k];
		Arrays.fill(div, 0);
		
		for(int i=0;i<S.length;i++) {
			div[S[i]%k]++;
		}
		
		if(k%2==0) {
			div[k/2] = Math.min(div[k/2], 1);
		}
		
		size = Math.min(div[0], 1);
		
		for(int i=1;i<=k/2;i++) {
			size+=Math.max(div[i], div[k-i]);
		}
		
		return size;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
       // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        System.out.println(result);
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
*/    }
	
}
