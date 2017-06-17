package string;

import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		
		String s2 = sc.next();
		System.out.println(s1+" "+s2);
		
		isAnagram(s1, s2);
	}
	
	
	public static void isAnagram(String s1,String s2){
		
		s1 = s1.replaceAll("\\s", "");
		s2 = s2.replaceAll("\\s", "");
		
		if(s1.length() != s2.length()){
			System.out.println("Not an Anagram");
			return;
		}
		else {
			for(char c:s2.toCharArray()){
				if(s1.indexOf(c) != -1){
					s1 = s1.substring(0,s1.indexOf(c))+s1.substring(s1.indexOf(c)+1);
				} else {
					System.out.println("Not an Anagram");
					return;
				}
			}
		}
		
		System.out.println("is an Anagram");
	}

}
