package com.sample.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BerlinTest {
	
	public static void main (String args[]) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(0);
		list1.add(1);
		list1.add(1);
		list1.add(0);
		list1.add(1);
		
		list.add(list1);
		list1 = new ArrayList<>();
		list1.add(1);
		list1.add(1);
		list1.add(0);
		list1.add(1);
		list1.add(0);
		list.add(list1);
		list1 = new ArrayList<>();
		list1.add(0);
		list1.add(1);
		list1.add(1);
		list1.add(1);
		list1.add(0);
		list.add(list1);
		list1 = new ArrayList<>();
		list1.add(1);
		list1.add(1);
		list1.add(1);
		list1.add(1);
		list1.add(0);
		list.add(list1);
		list1 = new ArrayList<>();
		list1.add(1);
		list1.add(1);
		list1.add(1);
		list1.add(1);
		list1.add(1);
		list.add(list1);
		
		list1 = new ArrayList<>();
		list1.add(0);
		list1.add(0);
		list1.add(0);
		list1.add(0);
		list1.add(0);
		list.add(list1);
		
		int x = squareMaximizer(list);
		System.out.println(x);
		
	}
	
	static int squareMaximizer(List<List<Integer>> matrix) {
        int i, j;
        int m = matrix.size();
        int n = matrix.get(0).size();
        int sub_array[][] = new int[m][n];

        int maxSubArraySize;

        for (i = 0; i < m; i++)
        {
            sub_array[i][0] = matrix.get(i).get(0);
        }

        for (j = 0; j < n; j++)
        {
            sub_array[0][j] = matrix.get(0).get(j);
        }

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (matrix.get(i).get(j) == 1)
                    sub_array[i][j] = Math.min(sub_array[i][j - 1], Math.min(sub_array[i - 1][j], sub_array[i - 1][j - 1])) + 1;
                else
                    sub_array[i][j] = 0;
            }
        }

        maxSubArraySize = sub_array[0][0];
      //  max_i = 0;
       // max_j = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (maxSubArraySize < sub_array[i][j]) {
                    maxSubArraySize = sub_array[i][j];
         //           max_i = i;
           //         max_j = j;
                }
            }
        }

        return maxSubArraySize;

    }
	
	List<List<Integer>> OPTU (int max, List<List<Integer>> f,List<List<Integer>> ret )
	{
		
		List<List<Integer>> result = new LinkedList<>();
		
		int best = -1;
		for(int i=0;i<f.size();i++)
		{
			List<Integer> element = f.get(i);
			int identifier = element.get(0);
			int val = element.get(1);
			
			
			for(int j=0;j<ret.size();j++)
			{
				List<Integer> tmp = new LinkedList<>();
				int currentval = val + ret.get(j).get(1);
				
				if(currentval > max)
					continue;
				
				if(best == -1)
				{
					best = currentval;
					tmp.add(identifier);
					tmp.add(ret.get(j).get(0));
					result.add(tmp);
					
				}
				if(currentval > best)
				{
					best = currentval;
					result = new LinkedList<>();
					tmp.add(identifier);
					tmp.add(ret.get(j).get(0));
					result.add(tmp);				
				}
				else if (currentval == best)
				{
					tmp.add(identifier);
					tmp.add(ret.get(j).get(0));
					result.add(tmp);
				}			
			}
			
			
			
			
		}
		
		return result;
		
		
		
		
	}
	
	static int snake(List<List<Integer>> grid) {

        int m = grid.size();
        int n = grid.get(0).size();
        int temp[][] = new int[m][n];
        int max_len = 0; 
  
        for (int i = 0; i < m; i++) 
        { 
            for (int j = 0; j < n; j++) 
            { 
                if (i>0 || j>0) 
                { 
                    if (i > 0 && Math.abs(grid.get(i-1).get(j) - grid.get(i).get(j)) == 1) 
                    {   
                        temp[i][j] = Math.max(temp[i][j],temp[i - 1][j] + 1); 
  
                        if (max_len < temp[i][j]) 
                        { 
                            max_len = temp[i][j]; 
                         //   max_row = i;
                          //  max_col = j; 
                        } 
                    } 
  
                    if (j > 0 && Math.abs(grid.get(i).get(j-1) - grid.get(i).get(j)) == 1)
                    { 
                        temp[i][j] = Math.max(temp[i][j], temp[i][j - 1] + 1); 
                        if (max_len < temp[i][j]) 
                        { 
                            max_len = temp[i][j]; 
                         //   max_row = i;
                          //  max_col = j; 
                        }  
                    } 
                }
            }
        } 
        return max_len;
    }


}
