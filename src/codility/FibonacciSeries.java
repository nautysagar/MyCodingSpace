package codility;

import java.math.BigInteger;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fib(10);
	//	System.out.println("Fib: "+ fib(50));
	}
	
	private static void fib(int n){
		int count = n;
		BigInteger[] feb = new BigInteger[count];
	      feb[0] = BigInteger.valueOf(0);
	      feb[1] = BigInteger.valueOf(1);
	      
	      for(int i = 2; i < count; i++) {
	         feb[i] = feb[i-1].add(feb[i-2]);
	      } 
	      for(int i = 0; i< count; i++) {
	         System.out.print(feb[i] + " ");
	      }
	   }
	
	

}
