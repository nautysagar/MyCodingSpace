package codility;

public class RainyHillSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 3, 2, 4, 1, 2 };
       System.out.println("Total :" + solution(arr));
	}
	
	private static int solution(int[] arr){
		int leftMaxindex = -1;
		int len = arr.length;
		int finalvolume = 0;
		int leftdipvalue = arr[0];
		leftMaxindex = 0;
		int tempvolume = 0;
		for (int i = 0; i < len; i++) {
			if (leftdipvalue > arr[i]) {
				tempvolume += (leftdipvalue - arr[i]);
			} else {
				finalvolume = finalvolume + tempvolume;
				tempvolume = 0;
				leftdipvalue = arr[i];
				leftMaxindex = i;
			}
		}
		// System.out.println(n);
		if (tempvolume > 0) {
			leftdipvalue = arr[len - 1];
			tempvolume = 0;
			for (int i = len - 1; i >= leftMaxindex; i--) {
				if (leftdipvalue > arr[i]) {
					tempvolume += (leftdipvalue - arr[i]);
				} else {
					finalvolume = finalvolume + tempvolume;
					tempvolume = 0;
					leftdipvalue = arr[i];
				}
			}
		}

		return finalvolume;

	}
	

}
