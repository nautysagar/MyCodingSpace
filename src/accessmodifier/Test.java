package accessmodifier;

import java.util.HashSet;
import java.util.Set;

class Bar{
	Integer k;
	Bar(Integer k){
		this.k =k;
	}
	
	public boolean equals(Bar b){
		return false;
	}
}
public class Test {

	
	
	
	

	
	public static void main(String args[]) {
	      try {
	         int a[] = new int[2];
	         System.out.println("Access element three :" + a[3]);
	      }catch(ArrayIndexOutOfBoundsException e) {
	         System.out.println("Exception thrown  :" + e);
	      }
	      System.out.println("Out of the block");
	   }
	
	public static void  test( ) throws RuntimeException {
		try {
			
			
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println("exception");
		}
		
		
	}
	
}
