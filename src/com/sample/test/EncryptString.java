package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptString {
	
	static String encryption(String s) {
		
		String encryptedString = null;
		StringBuffer buffer = new StringBuffer();
		
		s = s.replaceAll("\\s+","");
		int length = s.length();
		
		int rows = (int) Math.floor(Math.sqrt(length));
		int columns = (int) Math.ceil(Math.sqrt(length));
		
		String []strEncry = new String[rows];
		
		int index = 0;
		
		for(int i=0;i<rows;i++) {
			buffer = new StringBuffer();
			for(int j=0;j<columns && index <length;j++) {
				buffer.append(s.charAt(index));
				index++;
			}
			strEncry[i] = buffer.toString();
		}
		
		buffer = new StringBuffer();
		for(int i=0;i<columns;i++) {
			for(int j=0;j<rows && i<strEncry[j].length();j++) {
				buffer.append(strEncry[j].charAt(i));	
			}
			buffer.append(" ");
		}
		
		encryptedString = buffer.toString();
		
		return encryptedString;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

       /* bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }

}
