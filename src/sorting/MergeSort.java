package sorting;

public class MergeSort {
	
	public static void mergesort(int[] array){
		
		int len = array.length;
		if(len < 2 ) return ;
		int m = len/2;
		
		int[] left = new int[m];
		int[] right = new int[len - m];
		
		for(int k =0; k < m;k++){
			left[k] = array[k];
		}
		
		for(int kk = m; kk < len;kk++){
			right[kk-m] = array[kk];
		}
		
		mergesort(left);
		mergesort(right);
		
		merge(left,right,array);
	}
	
	
	
	
	
	private static void merge(int[] left, int[] right, int[] main){
		int ll = left.length;
		int rl = right.length;
		int i = 0, j = 0, k = 0;
		
		while(i < ll && j < rl) {
			if(left[i] <= right[j]) {
				main[k] = left[i];
				i++;
			} else {
				main[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < ll) {
			main[k] = left[i];
			i++;
			k++;
		}
		
		while(j < rl) {
			main[k] = right[j];
			j++;
			k++;
		}
	}

}
