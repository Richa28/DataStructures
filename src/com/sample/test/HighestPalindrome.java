package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HighestPalindrome {

	static String highestValuePalindrome(String s, int n, int k) {
		String palin = s;
		 
	    // Iinitialize l and r by leftmost and
	    // rightmost ends
	    int l = 0;
	    int r = s.length() - 1;
	 
	    //  first try to make string palindrome
	    while (l < r)
	    {
	        // Replace left and right character by
	        // maximum of both
	        if (s.charAt(l) != s.charAt(r))
	        {
	        	char temp = s.charAt(r);
	        	if(s.charAt(l)>s.charAt(r)) {
	        		temp = s.charAt(l);
	        	}
	        	palin.replace(palin.charAt(r), temp);
	        	palin.replace(palin.charAt(r), temp);
	        	k--;
	        }
	        l++;
	        r--;
	    }
	 
	    // If k is negative then we can't make
	    // string palindrome
	    if (k < 0)
	        return "Not possible";
	 
	    l = 0;
	    r = s.length() - 1;
	 
	    while (l <= r)
	    {
	        // At mid character, if K>0 then change
	        // it to 9
	        if (l == r)
	        {
	            if (k > 0)
	            	palin.replace(palin.charAt(l), '9');
	        }
	 
	        // If character at lth (same as rth) is
	        // less than 9
	        if (palin.charAt(l) < '9')
	        {
	            /* If none of them is changed in the
	               previous loop then subtract 2 from K
	               and convert both to 9 */
	            if (k >= 2 && palin.charAt(l) == s.charAt(l) &&
	                palin.charAt(r) == s.charAt(r))
	            {
	                k -= 2;
	                palin.replace(palin.charAt(l), '9');
	                palin.replace(palin.charAt(r), '9');
	            }
	 
	            /*  If one of them is changed in the previous
	                loop then subtract 1 from K (1 more is
	                subtracted already) and make them 9  */
	            else if (k >= 1 && (palin.charAt(l) != s.charAt(l) ||
	                                palin.charAt(r) != s.charAt(r)))
	            {
	                k--;
	                palin.replace(palin.charAt(l), '9');
	                palin.replace(palin.charAt(r), '9');
	            }
	        }
	        l++;
	        r--;
	    }
	 
	    return palin;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
	
}
