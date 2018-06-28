package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
       
    	String changedTime = s;
    	
    	String[] time = s.split(":");
    	int hour = Integer.parseInt(time[0]);
    	boolean isPM = false;
    	String ampm = s.substring(s.length()-2);
    	
    	if(ampm.equals("PM")) {
    		isPM = true;
    	}
    	
    	if(isPM) {
    		hour = hour+12;
    		changedTime = hour+":"+time[1]+":"+time[2];
    	}else {
    		if(hour == 12) {
    			changedTime = "00:"+time[1]+":"+time[2];
    		}
    	}
    	
    	changedTime = changedTime.replaceAll("AM|PM", "");
    	
    	return changedTime;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}

