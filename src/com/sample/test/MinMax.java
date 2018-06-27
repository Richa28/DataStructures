package com.sample.test;

import java.util.Scanner;

public class MinMax {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	long minVal =arr[0], maxVal=arr[0];
    	long sum = arr[0];
    	for(int i=1;i<arr.length;i++) {
    		sum+=arr[i];
    		if(minVal > arr[i]) {
    			minVal = arr[i];
    		}
    		
    		if(maxVal<arr[i]) {
    			maxVal = arr[i];
    		}
    	}
    	
    	long maxSum = sum - minVal;
    	long minSum = sum - maxVal;
    	
    	System.out.println(minSum+" "+maxSum);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
