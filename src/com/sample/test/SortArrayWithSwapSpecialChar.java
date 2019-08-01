package com.sample.test;

public class SortArrayWithSwapSpecialChar {

	public static void main(String[] args) {
		SortArrayWithSwapSpecialChar obj = new SortArrayWithSwapSpecialChar();
		int[] arr = {1, 5, 4, 3, 2, 8, 7, 999, 6};
		obj.sortArrayWithSwappingOnlySpecialCharacter(arr);
	}
	
	public void sortArrayWithSwappingOnlySpecialCharacter(int[] arr) {
		int n = arr.length;
		int specialCharIndex = getIndex(arr, 999);
		if(specialCharIndex == -1) {
			System.out.println("Invalid input");
			return;
		}
	
		swap(arr, specialCharIndex, n-1);
		quickSort(arr, 0, n-1);
		swap(arr, 0, n-1);
		for(int i=0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	int partition(int arr[], int low, int high) 
    { 
		int n = arr.length;
        int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                int temp = arr[n-1];
                arr[n-1] = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } 
        } 
  
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    void quickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
             int pi = partition(arr, low, high); 
  
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
    } 
	
	private void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	private int getIndex(int[] arr, int specialChar) {
		int index = -1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == specialChar) {
				index = i;
				break;
			}
		}
		return index;
	}
	
}
