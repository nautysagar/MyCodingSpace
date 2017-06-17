package string;

import java.util.Arrays;

public class StringTeaser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] kk = {"Vivek","Kumar"};
		passbyvalue(kk);
		System.out.println(Arrays.toString(kk));

	}
	
	
	static void passbyvalue(String[] str){
		String temp = str[0];
		str[0] = str[1];
		str[1] = temp;
		System.out.println(Arrays.toString(str));
		
	}

}
