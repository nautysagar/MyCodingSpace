package codility;

import java.util.HashMap;
import java.util.Map;

public class SumOfElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,8,-3,0,1,3,-2,4,5};
		System.out.println(solution(6,a));
	}
	
	
		
	
		
	public static int solution(int K, int[] A) {
        // write your code in Java SE 8
        Map<Long, Integer> C = new HashMap<Long, Integer>( );
			  for ( int i = 0; i < A.length; i++ )
			  {
			    final long complValue = ( ( long ) K ) - A[ i ];
			    final int tempValue = C.containsKey( complValue ) ? C.get( complValue ) : 0;
			    C.put( complValue, tempValue + 1 );
			  }
			 
			  int counter = 0;
			  for ( int i = 0; i < A.length; i++ )
			  {
			    final long value = A[ i ];
			    counter += C.containsKey( value ) ? C.get( value ) : 0;
			  }
			 
			  return counter;
			
    }
	}
