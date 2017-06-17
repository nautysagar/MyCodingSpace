package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {38, 27, 43, 3, 9, 82, 10};
     System.out.println("Array after Sorting: "+ Arrays.toString(selection(a)));
	}
	
	
	private static int[] selection(int[] a){
		
		for(int i=0;i< a.length-1;i++){
			
			int min = i;
			
			for(int j = i+1;j < a.length;j++){
				  if(a[j] < a[min]){
					  min =j;
				  }
			}
			swap(a,i,min);
			
		}
		
		return a;
		
	}
	
	
	public static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
