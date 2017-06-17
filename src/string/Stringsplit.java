package string;

import java.util.Arrays;

public class Stringsplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ss = "SITE|-1|-1|LFHQ|~|1700 West Tasman Drive|~|~|San Jose|CA|37|95138|~|";
		
		String[] kk = ss.split("\\|");
		System.out.println(Arrays.toString(kk));
		System.out.println(kk[4]);
		
	}

}
