package com.sample.test;

public class RunLengthEncoding {

	public static void main(String[] args) {
		RunLengthEncoding obj = new RunLengthEncoding();
		String str = "aaaabbbccccc";
		System.out.println(obj.runLengthEncoding(str));
	}
	
	public String runLengthEncoding(String str) {
		int n = str.length();
		char[] charArray = str.toCharArray();
		int i=0, k=0;
		while(i<n) {
			charArray[k++] = charArray[i];
			char prev = charArray[i];
			i++;
			int count = 1;
			while(i<n && charArray[i] == prev) {
				count++;
				prev = charArray[i];
				i++;
			}
			charArray[k++] = (char) (count + '0');
		}
		return String.valueOf(charArray).substring(0, k);
	}

}
