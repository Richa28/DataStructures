package com.sample.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenation {

	public static void main(String[] args) {
		SubstringConcatenation obj = new SubstringConcatenation();
		String A = "barfoothefoobarman";
		List<String> B = new ArrayList<>();
		B.add("foo");
		B.add("bar");
		ArrayList<Integer> result = obj.findSubstring(A, B);
		for(int i : result) {
			System.out.print(i + "  ");
		}
	}
	
	public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        
        int size_word = B.get(0).length(); 
  
        int word_count = B.size(); 
  
        int size_L = size_word * word_count; 
  
        ArrayList<Integer> res = new ArrayList<>(); 
  
        if (size_L > A.length()) 
            return res; 
  
        Map<String, Integer> hash_map = new HashMap<>();
  
        for (int i = 0; i < word_count; i++)  {
            if(hash_map.containsKey(B.get(i))){
                int temp = hash_map.get(B.get(i));    
                temp++;
                hash_map.put(B.get(i), temp);
            }else{
                hash_map.put(B.get(i), 1);
            }
            
        }
            
  
        for (int i = 0; i <= A.length() - size_L; i++) { 
            Map<String,Integer> temp_hash_map = new HashMap<>(hash_map);
  
            int j = i,count=word_count; 
  
            while (j < i + size_L) { 
  
                String word = A.substring(j, j+size_word); 
  
  
                if (!temp_hash_map.containsKey(word)||temp_hash_map.get(word)==0) 
                    break; 
  
                else
                { 
                   int temp = temp_hash_map.get(word);
                   temp--;
                   temp_hash_map.put(word, temp);
                   count--;
                   
               }  
  
  
                j += size_word; 
            } 
       
            if (count == 0) 
                res.add(i); 
    } 
  
        return res; 
    }

}
