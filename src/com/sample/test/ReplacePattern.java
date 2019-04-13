package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReplacePattern {
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String str = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String pattern = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
*/
        String res = replace("aaaaa", "aa");
        System.out.println(res);

      /*  bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
	
	// Function to in-place replace multiple 
	// occurrences of a pattern by character ‘X’ 
	static String replace(String str, String pattern) 
	{ 
		char[] strArray = str.toCharArray();
	    if (pattern == null) 
	        return null; 
	  
	    int len = pattern.length();
	    if (len == 0) 
	       return null; 
	  
	    int i = 0, j = 0; 
	    int count;
	    
	    while (j<str.length()) 
	    { 
	        count = 0; 
	  
	        while (j<str.length() && compare(str.substring(j), pattern)) 
	        { 
	            j = j + len; 
	            count++; 
	        } 
	        
	        if (count > 0) 
	            strArray[i++] = 'X';
	  
	        if(j<str.length())
	         strArray[i++] = strArray[j++];
	    } 
	    
	    str = String.valueOf(strArray);
	    str = str.substring(0, i+1);
	    return str;
	} 
	
	static boolean compare(String str, String pattern) 
	{ 
	    for (int i = 0; i<pattern.length() && i<str.length(); i++) 
	        if (str.charAt(i) != pattern.charAt(i)) 
	            return false; 
	    return true; 
	}

}
