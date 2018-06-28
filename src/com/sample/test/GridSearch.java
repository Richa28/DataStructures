package com.sample.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GridSearch {

	private static String[][] subMatrix(String[][] mat, int startR, int endR, int startC, int endC)
	{
		String[][] sub = new String[endR - startR][endC - startC];
		
		for (int subI = 0, matI = startR; matI < endR; ++subI, ++matI)
		{
			for (int subJ = 0, matJ = startC; matJ < endC; ++subJ, ++matJ)
			{
				String tmp = mat[matI][matJ];
				sub[subI][subJ] = tmp;
			}
		}
		
		return sub;
	}

	 static String gridSearch(String[][] grid, String[][] pattern)
	{
		int r = pattern.length;
		int c= pattern[0].length;
		String  containsPattern = "NO";
		String[][] tmp= new String[r][c];
		
		loop:
			for (int i = 0; i + r < grid.length; ++i)
			{
				for (int j = 0; j + c< grid[i].length; ++j)
				{
					tmp = subMatrix(grid, i, i + r, j, j + c);
					if (Arrays.deepEquals(pattern, tmp))
					{
						containsPattern = "YES";
						break loop;
					}
				}
			}
		
		return containsPattern;
	}

	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

          //  String result = gridSearch(G, P);

        //    bufferedWriter.write(result);
          //  bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
	
}
