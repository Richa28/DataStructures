package com.sample.test;

public class SortedRotatedArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedRotatedArraySearch obj = new SortedRotatedArraySearch();
		int arr[] = {1,2,3,4,5,6};
		int ele = 5;
		System.out.println(obj.pivotedBinarySearch(arr, ele));
	}
	
	private int findPivot(int[] arr, int low, int high) {
		if (low > high)
			return -1;
		
		int mid = low + ((high - low)/2);
		if(mid < high && arr[mid] > arr[mid+1]) {
			return mid;
		}
		if(mid > low && arr[mid-1] > arr[mid]) {
			return mid-1;
		}
		if(arr[low] > arr[mid]) {
			return findPivot(arr, low, mid-1);
		}
		return findPivot(arr, mid+1, high);
	}
	
	private int pivotedBinarySearch(int arr[], int ele) {
		if(arr == null) {
			return -1;
		}
		
		int n = arr.length;
		if(n == 1 && arr[0] != ele) {
			return -1;
		}
		
		int pivot = findPivot(arr, 0, n-1);
		if(pivot == -1) {
			return binarySearch(arr, ele, 0, n-1);
		}
		
		if(arr[pivot] == ele) {
			return pivot;
		}
		if(arr[0] <= ele) {
			return binarySearch(arr, ele, 0, pivot-1);
		}
		return binarySearch(arr, ele, pivot, n);
	}
	
	private int binarySearch(int arr[], int ele, int low, int high) {
		if (low > high)
			return -1;
		
		int mid = low + ((high - low)/2);
		
		if(arr[mid] == ele)
			return mid;
		if(arr[mid] < ele)
			return binarySearch(arr, ele, mid+1, high);
		return binarySearch(arr, ele, low, mid-1);
	}

}
