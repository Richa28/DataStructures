package com.sample.test;

public class ReverseWordsInString {

	public static void main(String[] args) {
		ReverseWordsInString obj = new ReverseWordsInString();
		String str = "the sky is blue";
		System.out.println(obj.reverseWords(str));
	}
	
	public String reverseWords(String a) {
        
        String result = "";
        String [] temp = a.split(" ");
        for(int i=0; i<temp.length; i++){
            result += reverse(temp[i]);
            result += " ";
        }
        
        result = reverse(result.trim());
        return result;
    }
    
    private String reverse(String str){
        int n = str.length();
        char ch[] = str.toCharArray();
        int i = 0, j = n-1;
        while(i <= j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }

}
