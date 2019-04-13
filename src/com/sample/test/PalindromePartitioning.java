package com.sample.test;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning obj = new PalindromePartitioning();
		obj.minCut("ababb");
	}
	
	public int minCut(String A) {
        
        if(A == null || A.isEmpty())
            return 0;
        
        int n = A.length();
        boolean[][] part = new boolean[n][n];
        int[][] cost = new int[n][n];
        
        for(int i=0; i<n; i++){
            part[i][i] = true;
            cost[i][i] = 0;
        }
        
        for(int L=2; L<=n; L++){
            for(int i=0; i<n-L+1; i++){
                int j = i+L-1;
                boolean res = A.charAt(i) == A.charAt(j);
                if(L == 2 && res){
                    part[i][j] = true;
                }else if(res){
                    part[i][j] = res && part[i+1][j-1];
                }else{
                    part[i][j] = false;
                }
                
                if(part[i][j])
                    cost[i][j] = 0;
                else{
                    cost[i][j] = Integer.MAX_VALUE;
                    for(int k=i; k<j; k++){
                        cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k+1][j] + 1);
                    }
                }
            }
        }    
        return cost[0][n-1];
    }

}
