package com.sample.test;

public class RemoveExtraSpacesFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveExtraSpacesFromString obj = new RemoveExtraSpacesFromString();
		String str = "I   live   on     earth         ";
		System.out.println(obj.removeSpaces(str));
	}
	
	private String removeSpaces(String str) {
		int n = str.length();
		int i=0;
		
		char[] charArray = str.toCharArray();
		
		for(int k=0; k<n;) {
			
			charArray[i] = charArray[k];
			i++;
			
			if(charArray[k] == ' ') {
				while(k<n && charArray[k] == ' ') {
					k++;
				}
			}else {
				k++;
			}
		}
		
		System.out.println(i);
		
		String res = "";
		for(int k=0; k<i; k++) {
			res+=charArray[k];
		}
		
		return res.trim();
	}

}
