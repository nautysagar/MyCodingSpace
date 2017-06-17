package string;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	 static String str1 ="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		compress("");
	}
	
	
	static void compress(String str) {
       
   // int len = str.length();
       // char curr = '\0';
        char prev = '\0';
        int count = 0;
       char[] cc = str.toCharArray();
       int len = str.length();  
     
      // char[] cc = str.toCharArray();
       for(char curr:cc){
    	   len--;
    	   if (prev != curr) {
    		   appendString(prev,count);
    		   prev = curr;
    		   count =1;
    	   } else {
    		   count++;
    	   }
    	   if(len == 0) appendString(curr,count);
    	   
    	   
//            len--;
//            if(c == '\0') {
//        		   c = k;
//        		   count++;
//        		   continue;
//        	   } else if( c == k){
//        		   count++;
//        		   continue;
//        		   
//        	   } else
//            if(count > 1)
//     		   str1 = str1+c+count;
//     	   else  
//     		   str1 = str1+c;
//               count = 1;
//               c = k;
       } 
       
        
        System.out.println(str1 + ":length"+str1.length());
    }

	
	private static void appendString(char c, int count){
		if(count > 1) {
			 str1 = str1+c+count;
		} else {
			str1 = str1+c;
		}
	}

}
