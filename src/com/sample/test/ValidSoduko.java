package com.sample.test;

public class ValidSoduko {
	
	boolean notInRow(char arr[][], int row, int val) 
	{ 
		for (int i = 0; i < 9; i++) { 

			if (arr[row][i] == val) 
				return false; 
		} 
		return true; 
	} 

	// Checks whether there is any duplicate 
	// in current column or not. 
	boolean notInCol(char arr[][], int col, int val) 
	{ 
		for (int i = 0; i < 9; i++) { 

			if (arr[i][col] == val) 
				return false; 

		} 
		return true; 
	} 

	// Checks whether there is any duplicate 
	// in current 3x3 box or not. 
	boolean notInBox(char arr[][], int startRow, int startCol, int val) 
	{ 

		for (int row = 0; row < 3; row++) { 
			for (int col = 0; col < 3; col++) { 
				char curr = arr[row + startRow][col + startCol]; 

				// If already encountered before, return false 
				if (curr == val) 
					return false; 

			} 
		} 
		return true; 
	} 

	// Checks whether current row and current column and 
	// current 3x3 box is valid or not 
	boolean isValid(char arr[][], int row, int col) 
	{ 
		return notInRow(arr, row, arr[row][col]) && notInCol(arr, col, arr[row][col]) && 
			notInBox(arr, row - row % 3, col - col % 3, arr[row][col]); 
	} 

	boolean isValidConfig(char arr[][], int n) 
	{ 
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 

				// If current row or current column or 
				// current 3x3 box is not valid, return false 
				if (!isValid(arr, i, j)) 
					return false; 
			} 
		} 
		return true; 
	} 
	
	public static void main(String[] args) {
		char board[][] = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } }; 

		ValidSoduko obj = new ValidSoduko();
		System.out.println(obj.isValidConfig(board, 9) ? "YES\n" : "NO\n"); 
	}

}
