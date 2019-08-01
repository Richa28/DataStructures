package com.sample.test;

public class RemoveExtraSpaces {

	public static void main(String[] args) {
		RemoveExtraSpaces obj = new RemoveExtraSpaces();
		String str = "I   live   on     earth ";
		str = str.trim();
		char[] chars = str.toCharArray();
		obj.removeExtraSpacesFromLine(chars);
	}

	public void removeExtraSpacesFromLine(char[] chars) {
		int n = chars.length;
		if(n <= 2) {
			return;
		}
		
		int k=0, spaceCount=0;
		for(int i=0; i<n; i++) {
			if(chars[i] != ' ') {
				chars[k++] = chars[i];
				spaceCount = 0;
			}else {
				spaceCount++;
				if(spaceCount <= 1) {
					chars[k++] = chars[i];
				}
			}
		}
		
		for(int i=0; i<k; i++) {
			System.out.print(chars[i]);
		}
	}
	
}
