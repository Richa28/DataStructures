package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockString {

    // Complete the isValid function below.
    static String isValid(String s) {
    	String result = "NO";
    	Map<String,Integer> frequency = new HashMap<>();
    	Map<Integer,Integer> mostUsed = new HashMap<>();
    	for(int i=0;i<s.length();i++) {
    		int val = 0;
    		if(frequency.containsKey(s.charAt(i)+"")) {
    			val = frequency.get(s.charAt(i)+"");
    			val++;
    			frequency.put(s.charAt(i)+"", val);
    			
    		}else {
    			val=1;
    			frequency.put(s.charAt(i)+"", 1);
    		}
    		
    		if(mostUsed.containsKey(val)) {
    			int temp = mostUsed.get(val);
    			mostUsed.put(val, ++temp);
    		}else {
    			mostUsed.put(val,1);
    		}
    	}
    	
    	int frequencyToUse = 0;
    	
    	for(int i : mostUsed.keySet()) {
    		if(mostUsed.get(i)>frequencyToUse)
    			frequencyToUse = mostUsed.get(i);
    	}
    	
    	int count =0;
    	
    	for(String s1:frequency.keySet()) {
    		if(frequency.get(s1)!=frequencyToUse)
    			count++;
    	}
    	
    	if(count<=1) {
    		result = "YES";
    	}
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
