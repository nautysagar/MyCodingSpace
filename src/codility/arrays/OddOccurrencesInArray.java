package codility.arrays;



public class OddOccurrencesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,3,9,3,9,7,9};
		System.out.println(solution(A));		
	}
	
	private static int solution(int[] A) {
        // write your code in Java SE 8
                  int  missing = 0;
            for (int i = 0; i < A.length; i ++) {
            missing ^= A[i];
            
            }
            return missing;
        
    }

}
