package com.sample.test;

public class PrintFrequencyOfArray {

	public static void main(String[] args) {
		PrintFrequencyOfArray obj =  new PrintFrequencyOfArray();
		int arr[] = {2, 3, 3, 2, 5};
		obj.printfrequency(arr, arr.length);
	}
	
	void printfrequency(int arr[], int n)  
    { 
        for (int j = 0; j < n; j++) 
            arr[j] = arr[j] - 1; 
  
        for (int i = 0; i < n; i++) 
            arr[arr[i] % n] = arr[arr[i] % n] + n; 
  
        for (int i = 0; i < n; i++) 
            System.out.println(i + 1 + "->" + arr[i] / n); 
    } 

}
