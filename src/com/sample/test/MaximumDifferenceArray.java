package com.sample.test;

public class MaximumDifferenceArray implements I1, I2{
	
	public static void main(String[] args) {
		
		int a[] = {10, 8, 7, 6, 5};
		int result = maxDifference(a);
		System.out.println(result);
		
    }
	
	
	static int maxDifference(int[] a) {
        int n = a.length;
        int maxDiff = -1;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = a[0];
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(a[i], LMin[i - 1]);

        RMax[n - 1] = a[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(a[j], RMax[j + 1]);

        i = 0;
        j = 0;
        while (j < n && i < n) {
            if (LMin[i] < RMax[j]) {
                maxDiff = Math.max(maxDiff, a[j] - a[i]);
                j = j + 1;
            } else
                i = i + 1;
        }

        return maxDiff;

    }


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}


interface I1{
	void run();
}

interface I2{
	void run();
}
