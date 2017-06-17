package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {38, 7, 43, 3, 9, 82, 10};
	     System.out.println("Array after Sorting: "+ Arrays.toString(bubble(a)));
	}
	
	
	private static int[] bubble(int[] a){
		
		for(int i=a.length-1;i>=0;i--){
			
			for(int j=0; j< i;j++){
				 if(a[j] > a[j+1]){
					 SelectionSort.swap(a, j, j+1);
				 }
			}
			
		}
		return a;
	}

}
