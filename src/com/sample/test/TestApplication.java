package com.sample.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class TestApplication {
	
	public static void main(String []args) {
		//LinkedList<String>list = new LinkedList<>();
		LinkedList<String> list = new LinkedList<>();
		String lit = "romeo romeo wherefore art thou";
		list.add("t2 13 121 98");
		list.add("r1 1box ape mit");
		list.add("b4 box ape mit");
		list.add("br8 Eat nim did");
		list.add("br8 fat nim did");
		list.add("w1 has uni gry");
		list.add("f3 52 54 31");
		
		//retrieveMostFrequentlyUsedWords(lit, list);
		
		TestApplication test = new TestApplication();
		test.reorderLines(5, list);
		
		//takeInput();
	}
	
	public static List<String> retrieveMostFrequentlyUsedWords(String literatureText, 
            List<String> wordsToExclude)
{
		int maxfreq = 0;
		List<String> output = new LinkedList<String>();
		
		if(literatureText.indexOf(" ")!= -1)
		{
		String[] a = literatureText.split(" ");
		HashMap<String, Integer> frequency = new HashMap<>();
		for(int i=0;i<a.length;i++)
		{
			if(frequency.containsKey(a[i]))
			{
				frequency.put(a[i], frequency.get(a[i]) +1);
				if(maxfreq < frequency.get(a[i]))
				{
					maxfreq = frequency.get(a[i]);
				}
				
					
			}
			else
			{
				if(!wordsToExclude.contains(a[i]))
				frequency.put(a[i], 1);
				{
					if(maxfreq < 1)
						maxfreq = 1;
				}
			}
		}
		 
		for(Map.Entry<String,Integer> e:frequency.entrySet())
		{
			if(e.getValue() == maxfreq)
			{
			     output.add(e.getKey());
			}
		}
		}else {
			if(!wordsToExclude.contains(literatureText)) {
				output.add(literatureText);
			}
		}
		
	return output;
// WRITE YOUR CODE HERE
}
	
	public List<String> reorderLines(int logFileSize, List<String> logLines) 
	{
		LinkedList<String> numberList = new LinkedList<>();
		LinkedList<String> stringList = new LinkedList<>();
		LinkedList<String> resultList = new LinkedList<>();
		
		HashMap<String, List<String>> map = new HashMap<>();
		Map<String, List<String>> storage = new HashMap<>();
		
		for(String str : logLines) {
			if(str.indexOf(" ")!=-1) {
				String temp[] = str.split(" ");
				if(temp[1]!=null) {
					try {
						Integer.parseInt(temp[1]);
						numberList.add(str);
					}catch(Exception e) {
						String s = str.substring(str.indexOf(" "),str.length());
						stringList.add(s);
						List<String> listSTr = new LinkedList<>();
						if(map.containsKey(s)) {
							listSTr = map.get(s);
							listSTr.add(temp[0]);
							map.put(s, listSTr);
						}else {
							listSTr.add(temp[0]);
							map.put(s, listSTr);
						}
					}
				}
			}
		}
		
		Collections.sort(stringList);
		LinkedList<String> stringListOut = new LinkedList<>();
		
		String prev = null;
		for(String str:stringList) {
			if(str.equals(prev)) {
				continue;
			}
			prev = str;
			List<String> temp = map.get(str);
			Collections.sort(temp);
			for(String s:temp) {
				stringListOut.add(s+str);
			}
			
		}
		
		resultList.addAll(stringListOut);
		resultList.addAll(numberList);
		
		return resultList;
		
	}
	
	public static void takeInput() {
		Scanner sc=new Scanner(System.in);  
	     
		System.out.println("Enter your rollno");  
		int rollno=sc.nextInt();  
		System.out.println("Enter your name");  
		String name=sc.next();  
		System.out.println("Enter your fee");  
		double fee=sc.nextDouble();  
		System.out.println("Rollno:"+rollno+" name:"+name+" fee:"+fee);  
		sc.close();  
	}

}
