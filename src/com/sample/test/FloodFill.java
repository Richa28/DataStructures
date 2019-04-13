package com.sample.test;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1}, 
	                      {1, 1, 1, 1, 1, 1, 0, 0}, 
	                      {1, 0, 0, 1, 1, 0, 1, 1}, 
	                      {1, 2, 2, 2, 2, 0, 1, 0}, 
	                      {1, 1, 1, 2, 2, 0, 1, 0}, 
	                      {1, 1, 1, 2, 2, 2, 2, 0}, 
	                      {1, 1, 1, 1, 1, 2, 1, 1}, 
	                      {1, 1, 1, 1, 1, 2, 2, 1}, 
	                     };
	    FloodFill obj = new FloodFill();
	    int x = 4, y = 4, newC = 3; 
	    obj.floodFill(screen, x, y, newC); 
	}
	
	public void floodFill(int [][] arr, int x, int y, int newC) {
		int prevC = arr[x][y];
		floodFillUtil(arr, x, y, prevC, newC);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	private void floodFillUtil(int[][] arr, int x, int y, int prevC, int newC){
		if(!isValid(arr, x, y)) {
			return;
		}
		
		if(arr[x][y] != prevC) {
			return;
		}
		
		arr[x][y] = newC;
		
		floodFillUtil(arr, x-1, y, prevC, newC);
		floodFillUtil(arr, x+1, y, prevC, newC);
		floodFillUtil(arr, x, y-1, prevC, newC);
		floodFillUtil(arr, x, y+1, prevC, newC);
	}
	
	private boolean isValid(int[][] arr, int x, int y) {
		if(x<0 || x>=arr.length || y<0 || y>=arr.length) {
			return false;
		}
		return true;
	}

}
