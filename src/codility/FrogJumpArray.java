package codility;

public class FrogJumpArray {

	public static void main(String[] args) {
		int[] a = {2,3,-1,1,3};
		System.out.println(solution(a));
	}
	
	
		
	
		public static int solution(int[] a) {
	        // write your code in Java SE 8
	        long len = a.length;
	        long sum = 0;
	        long count = len;
	        for(long i=0;i<len;i = sum){
	             sum += a[(int) i];
	            
	             if(i+sum > len){
	              return (int) i;
	            } else if(count < 1){
	            	return -1;
	            }
	             i = (int) sum;
	             count --;
	        }
	      return -1;  
	    }
	}