package com.sample.test;

import java.util.Scanner;

public class FindPercentage {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {

float zeros = 0, positive =0, negative=0;
        float countZero = 0, countPositive =0, countNegative=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                countZero++;
            }else if(arr[i]>0){
                countPositive++;
            }else{
                countNegative++;
            }
        }
        zeros = countZero/arr.length;
        positive = countPositive/arr.length;
        negative = countNegative/arr.length;
        
        System.out.println(positive);
        System.out.println(negative);
        System.out.println(zeros);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
*/
    	int []arr = {-4,6,-9,0,4,1};
        plusMinus(arr);

        scanner.close();
    }
}
