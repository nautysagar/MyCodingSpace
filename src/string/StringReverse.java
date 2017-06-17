package string;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) throws Exception {
	//	 TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String str = sc.next();
		if(str == null || str.length() < 1) throw new Exception("Invalid String");
		reverse(str);
		
		
	}

	private static void reverse(String str){
		char[] ch = str.toCharArray();
		int len = str.length()-1;
		int k = 0;
		
		while (k < len){
			char c = ch[k];
			ch[k++] = ch[len];
			ch[len--] = c;
		}
		
		System.out.println("String after reverse:"+Arrays.toString(ch));
		
	}
	
	 
	
}
