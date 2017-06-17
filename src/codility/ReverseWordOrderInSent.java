package codility;

import java.util.Arrays;

public class ReverseWordOrderInSent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(solution("we test coders?"));
		//reverseindexbasedword("we test coders",1);
	}
	
	
	private static String solution(String S){
		if(S == null || S.equals("")) return S;
		String[] words = S.split(" ");
        
        String reverseString = "";
         
        for (int i = 0; i < words.length; i++) 
        {
            String word = words[i];
             
            String reverseWord = "";
             
            for (int j = word.length()-1; j >= 0; j--) 
            {
                reverseWord = reverseWord + word.charAt(j);
            }
             
            reverseString = reverseString + reverseWord + " ";
        }
        
     //  System.out.println(reverseString.trim().length());
     //  System.out.println(S.length());
        
        return reverseString.trim();
	}
	
	private static String solution2(String S){
		if(S == null || S.equals("")) return S;
		
		
	      S = S.trim();
	 
	     
	      while(S.indexOf("  ") >= 0){  
	         S = S.replaceAll("  ", " ");  
	      }
	 
	      
	      String punctutations = ".:;?";
	      String last_letter = "";
	      if( punctutations.contains(S.substring(S.length()-1))){
	         last_letter = S.substring(S.length()-1);
	         S = S.replace(S.substring(S.length()-1), "");
	      }
	 
	      
	      String[] words = S.split(" "); 
	 
	      
	      int word_count = 0;
	      for (String word: words) {
	        word_count++; 
	        char[] chars = word.toCharArray();
	 
	        for (int x=chars.length - 1; x>=0; x--){
	          System.out.print(chars[x]);
	        } 
	        if (word_count < words.length){
	          System.out.print(" ");
	        }
	      }
	 
	      
	      return last_letter;
	   }
	
	private static void reverseindexbasedword(String S,int index){
		while(S.indexOf("  ") != -1) {
			S.replaceAll("  ", " ");
		}
		String[] str = S.split(" ");
		if(index < str.length) {
			str[index] = new StringBuilder(str[index]).reverse().toString();
		}
		 String str2 = Arrays.asList(str).toString();
		 str2 = str2.substring(1, str2.length()-1).replaceAll(",", "");
		 System.out.println(str2);
		
	}

}
