package com.sample.test;

import java.io.IOException;
import java.util.Scanner;

public class TestClass {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
int diff = 0; int sum1=0; int sum2=0;
        for(int i=0;i<arr[0].length;i++){
            sum1+=arr[i][i];
        }
        int j=0;
        for(int i=arr[0].length-1;i>=0;i--){
        	for(;j<arr[0].length;)
        	{
        		sum2+=arr[j][i];
        		break;
        	}
        	j++;
            
        }
        
        diff = Math.abs(sum1-sum2);
        return diff;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
          //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        int result = diagonalDifference(arr);

        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
