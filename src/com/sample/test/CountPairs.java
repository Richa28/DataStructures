package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CountPairs {
	
	static int binarySearch(int arr[], int low, int high, int x)
	{
			if (high >= low) 
			{
				int mid = low + (high - low) / 2;
				if (x == arr[mid])
					return mid;
				if (x > arr[mid])
					return binarySearch(arr, (mid + 1),high, x);
				else
					return binarySearch(arr, low, (mid - 1), x);
			}
			return -1;
	}

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
    	int count = 0, i;
        
        // Sort array elements
        Arrays.sort(arr);
 
        // code to remove duplicates from arr[] 
 
        // Pick a first element point
        for (i = 0; i < arr.length - 1; i++)
            if (binarySearch(arr, i + 1, arr.length - 1,
                             arr[i] + k) != -1)
                count++;
 
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
