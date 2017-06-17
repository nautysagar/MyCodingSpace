package sorting;

import java.util.Arrays;

public class TestMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kk = {34,5,87,12,4,64};
		System.out.println("Before merging: "+Arrays.toString(kk));
		Quicksort.quick(kk, 0, kk.length-1);
		System.out.println("After merging: "+Arrays.toString(kk));
		

	}

}
