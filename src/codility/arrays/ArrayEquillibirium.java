package codility.arrays;

public class ArrayEquillibirium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3, 1, -5, 2, -4, 3, 0};
		System.out.println(solution(a));
	}
	
	private static int solution(int[] A){
		
	
		int length = A.length;
		    int leftSum = 0;
	        int rightSum = 0;
	        
	        for (int i = 0; i < length; i++)
	        {
	            rightSum += A[i];
	        }
	        
	      
		
		for (int i = 0; i < length; ++i)
        {
			rightSum-=A[i];
			if(leftSum == rightSum) {
				//System.out.println(A[i]);
				return i;
			}
			leftSum +=A[i];
        }
        
        return -1;
    }
	}


