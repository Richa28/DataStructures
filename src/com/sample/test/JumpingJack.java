package com.sample.test;

import java.util.Arrays;

public class JumpingJack {

	public static void main(String[] args) {
		System.out.println(maxStep(2, 2));
	}

	static int maxStep(int n, int k) {
		int result = 0;
		if (n == 0) {
			return result;
		}
		int dp[][] = new int[1000][1000];
		for (int i = 0; i < 1000; i++) {
			Arrays.fill(dp[0], -1);
		}
		return maxStepHelper(n, 0, k, result, dp);
	}

	static int maxStepHelper(int n, int i, int k, int result, int dp[][]) {

		if (i == n + 1) {
			return result;
		}

		if (dp[i][result] != -1) {
			return dp[i][result];
		}
		int nextStep = i + result;
		if (nextStep == k) {
			dp[i][result] = maxStepHelper(n, i + 1, k, result, dp);
			return dp[i][result];
		}
		dp[i][result] = Math.max(maxStepHelper(n, i + 1, k, result, dp), maxStepHelper(n, i + 1, k, result + i, dp));
		return dp[i][result];
	}

}
