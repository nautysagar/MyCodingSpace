package codility.arrays;

import java.util.Arrays;

public class ArrayRotationByN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(rotate(arr, 4)));

	}

	
	public static int[] rotate(int[] arr, int order) {	
		if (arr == null || arr.length==0 || order < 0) {
			return arr;
		}
	 
		if(order > arr.length){
			order = order %arr.length;
		}
	 
		//length of first part
		int a = arr.length - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
		return arr;
	 
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
}
