package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {

	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		temp.add("1");
		temp.add("2");
		temp.add("3");
		list.add(temp);
		
		temp = new ArrayList<>();
		temp.add("a");
		temp.add("b");
		list.add(temp);
		
		temp = new ArrayList<>();
		temp.add("X");
		temp.add("Y");
		list.add(temp);
		
		System.out.println(multiplyAll(list));
	}
	
	public static String multiplyAll(List<List<String>> elements) {
	    
	    while (elements.size() > 1) {
	        List<String> parts1 = elements.remove(0);
	        List<String> parts2 = elements.remove(0);
	        elements.add(multiply(parts1, parts2));
	    }
	    String result = "";
	    for (String element: elements.get(0)) {
	        result += element + ",";
	    }
	    return result;
	}

	public static List<String> multiply(List<String> parts1, List<String> parts2) {
	    List<String> result = new ArrayList<>();
	    for (int i = 0; i < parts1.size(); i++) {
	        for (int j = 0; j < parts2.size(); j++) {
	            result.add(parts2.get(j)+parts1.get(i));
	        }
	    }
	    return result;
	}

}
