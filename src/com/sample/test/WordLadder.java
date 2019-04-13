package com.sample.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	
	public static void main(String[] args) {
		WordLadder obj = new WordLadder();
		ArrayList<String> dict = new ArrayList<>();
		dict.add("bb");
		dict.add("ab");
		obj.ladderLength("bb", "ab", dict);
	}

	public int ladderLength(String start, String end, ArrayList<String> dictV) {
        int n = dictV.size();
        
        if(n==0 || (n==1 && !start.equals(end))){
            return 0;
        }
        
        if(start.equals(end)){
            return 0;
        }
        
        List<String> tempDict = new ArrayList<>();
        tempDict.addAll(dictV);
        
        Queue<QueueObj> queue = new LinkedList<>();
        QueueObj obj = new QueueObj();
        obj.word = start;
        obj.count = 1;
        queue.add(obj);
        
        while(!queue.isEmpty()){
            QueueObj temp = queue.poll();
            
            for(String word: tempDict){
                if(dictV.contains(word) && isAdjacent(temp.word, word)){
                    QueueObj obj1 = new QueueObj();
                    obj1.word = word;
                    obj1.count = temp.count + 1;
                    queue.add(obj1);
                    
                    dictV.remove(word);
                    
                    if(word.equals(end)){
                        return temp.count;
                    }
                }
            }
        }
        return 0;
    }
    
    boolean isAdjacent(String str1, String str2){
        int diffCount = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                diffCount++;
            }
            if(diffCount > 1){
                return false;
            }
        }
        return true;
    }
    
    class QueueObj{
        String word;
        int count;
    }
}
