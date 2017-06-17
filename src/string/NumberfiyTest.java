package string;

import java.util.Random;

public class NumberfiyTest {



	public static String numerify(String numberString) {
	      Random randomGenerator = new Random();
	      int len = numberString.length();
	      String nn = numberString.replaceAll("[#@]", String.valueOf(randomGenerator.nextInt(len)));
	      return nn;
	    }

	 
	 public static String letterify(String numberString) {

		 	Random r = new Random();
		 	String nn = numberString.replaceAll("[?]", String.valueOf((char) (r.nextInt(26) + 'a')));
		 	return nn;
		 
	 }
	
	 public static String bothify(String numberString) {

		 return numerify(letterify(numberString));
		 	
		 
	 }
	 

		    
}





