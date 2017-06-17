package sorting;

import java.util.Arrays;

public class Quicksort {
	
	
	
	public static void quick(int[] array,int start,int end){
		if(start < end){
			int pindex = quicksort(array, start, end);
			quick(array,start,pindex-1);
			quick(array,pindex+1,end);
		}
	}
	
	
	private static int quicksort(int[] array, int start, int end){
		int pelement = array[end];
		int pindex = start;
		
		for(int k = start;k < end;k++){
			if(array[k] <= pelement) {
				swap(k,pindex,array);
				pindex++;
			}
		}

		
		swap(pindex,end,array);
		
		return pindex;
		
	}
	
	private static void swap(int index,int pindex,int[] arr){
		int temp = arr[index];
		arr[index] = arr[pindex];
		arr[pindex] = temp;
		
	}
	
	
	public static void main(String[] args){
		int[] kk = {8,18,7,5,9,12,4};
		System.out.println("Before merging: "+Arrays.toString(kk));
		quick(kk, 0, kk.length-1);
		System.out.println("After merging: "+Arrays.toString(kk));
		
	}

}
