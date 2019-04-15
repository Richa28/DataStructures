package com.sample.test;

import java.util.ArrayList;
import java.util.List;

public class StringMultiplication {

	public static void main(String[] args) {
        // Input: "{1,2,3}{a,b}{X,Y}{r,t}"
        List<List<String>> str = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        str.add(list);
        
        list = new ArrayList<>();
        list.add("a");
        list.add("b");
        str.add(list);
        
        list = new ArrayList<>();
        list.add("X");
        list.add("Y");
        str.add(list);
        
        list = new ArrayList<>();
        list.add("r");
        list.add("t");
        str.add(list);
        System.out.println(multiplyAll(str));
    }

    public static String multiplyAll(List<List<String>> str) {
        while (str.size() > 1) {
            List<String> parts1 = str.remove(0);
            List<String> parts2 = str.remove(0);
            str.add(multiply(parts1, parts2));
        }
        String result = "";
        for (String element: str.get(0)) {
            result += element + ",";
        }
        return result;
    }

    public static List<String> multiply(List<String> parts1, List<String> parts2) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < parts1.size(); i++) {
            for (int j = 0; j < parts2.size(); j++) {
                list.add(parts1.get(i) + parts2.get(j));
            }
        }
        return list;
    }
	
}
