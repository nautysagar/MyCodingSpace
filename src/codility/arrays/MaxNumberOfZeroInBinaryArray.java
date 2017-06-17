package codility.arrays;

public class MaxNumberOfZeroInBinaryArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,0,1,0,0,1};
	
	//	solution(a);
		System.out.println(solution2(10100001));
	}
	
	
	private static void solution(int[] arr){
		
		boolean start = false;
		int count =0;
		int tempcount=0;
		for(int i=0;i<arr.length;i++){
			
			if(!start ){
				if(arr[i] == 1)
					start = true;
				 continue;
			} else {
				if(arr[i] == 0){
					count++;
				} else {
					if(tempcount < count){
						tempcount = count;
						count =0;
					}
				}
			}
			
			
		}
		System.out.println(tempcount);
	}

	private static int solution2(int N){
		int pre = -1;
		int len = 0;

		while (N > 0) {
		int k = N & -N;

		int curr = (int) Math.log(k);

		N = N & (N - 1);

		if (pre != -1 && (Math.abs(curr - pre) - 1) > len) {
		len = Math.abs(curr - pre) ;
		}
		pre = curr;
		}

		return len;
    }

}
