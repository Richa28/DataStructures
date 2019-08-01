package com.sample.test;

public class ArrayRotation {

	public static void main(String[] args) {
		ArrayRotation obj = new ArrayRotation();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		obj.leftRotate(arr, 2, arr.length);
		for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " "); 
	}
	
	void leftRotate(int arr[], int d, int n) 
    { 
        int i, j, k, temp; 
        int g_c_d = gcd(d, n); 
        for (i = 0; i < g_c_d; i++) { 
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
            } 
            arr[j] = temp; 
        } 
    } 
	
	int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 

}
