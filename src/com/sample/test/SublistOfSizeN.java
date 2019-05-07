package com.sample.test;

public class SublistOfSizeN {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		SublistOfSizeN obj = new SublistOfSizeN();
		obj.combination(arr, 3);
	}
	
	private void combination(int[] arr, int k) {
		int[] data = new int[k];
		combinationUtil(arr, k, 0, data, 0);
	}
	
	private void combinationUtil(int[] arr, int k, int index, int []data, int i) {
		if(index == k) {
			for(int j=0; j<data.length; j++) {
				System.out.print(data[j] + " ");
			}
			System.out.println("");
			return;
		}
		
		if(i>=arr.length) {
			return;
		}
		
		data[index] = arr[i];
		combinationUtil(arr, k, index+1, data, i+1);
		combinationUtil(arr, k, index, data, i+1);
	}

}
