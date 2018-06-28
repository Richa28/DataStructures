package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeInWords {

	static String timeInWords(int h, int m) {
		String time = null;
		String nums[] = { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine",
              };

		if (m == 0)
			time = nums[h] + " o' clock";

		else if (m == 1)
			time = "one minute past "+nums[h];
		
		else if (m == 59)
			time = "one minute to "+nums[(h%12)+1];

		else if (m == 15)
			time = "quarter past "+nums[h];

		else if (m == 30)
			time = "half past "+nums[h];

		else if (m == 45)
			time = "quarter to "+nums[(h%12)+1];

		else if (m <= 30)
			time = nums[m] +" minutes past "+nums[h];

		else if (m > 30)
			time = nums[60-m] + " minutes to "+nums[(h%12)+1];
		
		return time;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
	
}
