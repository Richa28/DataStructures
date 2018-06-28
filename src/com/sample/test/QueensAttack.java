package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class QueensAttack {

	// Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
    	int attacks = 0;
    	
    	r_q--;
    	c_q--;
    	int[][] chessboard=new int[n][n];
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			chessboard[i][j] = 0;
    		}
    	}
    	
    	for(int i=0;i<k;i++) {
    		int r = obstacles[i][0]-1;
    		int c = obstacles[i][1]-1;
    		
    		chessboard[r][c] = -1;
    	}
    	
    	int [][] coord = new int[8][2];
    	coord[0][0] = r_q - 1;
    	coord[0][1] = c_q ;
    	coord[1][0] = r_q - 1;
    	coord[1][1] = c_q - 1;
    	coord[2][0] = r_q + 1;
    	coord[2][1] = c_q - 1;
    	coord[3][0] = r_q;
    	coord[3][1] = c_q - 1;
    	coord[4][0] = r_q + 1;
    	coord[4][1] = c_q;
    	coord[5][0] = r_q + 1;
    	coord[5][1] = c_q + 1;
    	coord[6][0] = r_q + 1;
    	coord[6][1] = c_q - 1;
    	coord[7][0] = r_q;
    	coord[7][1] = c_q + 1;
    	
    	for(int cnt = 0;cnt<8;cnt++) {
    		int i = coord[cnt][0];
    		int j = coord[cnt][1];
    		
    		int incrementI = 0;
    		int incrementJ = 0;
    		
    		if(i>r_q) {
    			incrementI = 1;
    		}else if(i<r_q) {
    			incrementI = -1;
    		}
    		
    		if(j>c_q) {
    			incrementJ = 1;
    		}else if(j<c_q) {
    			incrementJ = -1;
    		}
    		
    		for(;i<n && j<n && i>=0 && j>=0;) {
    			if(chessboard[i][j]!=-1) {
    				attacks++;
    			}else {
    				break;
    			}
    			
    			if(incrementI == 1) {
    				i++;
    			}else if(incrementI == -1) {
    				i--;
    			}
    			
    			if(incrementJ == 1) {
    				j++;
    			}else if(incrementJ == -1) {
    				j--;
    			}
    		}
    	}
    	
    	return attacks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
          //  scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

      //  bufferedWriter.write(String.valueOf(result));
     //   bufferedWriter.newLine();

     //   bufferedWriter.close();

        scanner.close();
    }
	
}
