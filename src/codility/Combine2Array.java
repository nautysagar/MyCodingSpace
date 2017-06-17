package codility;

import java.util.Arrays;

public class Combine2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {38, 27, 43, 3};
		int[] b = {4,5,9,8,6};
         combineArray(a, b);
	}
	
	
	private static void combineArray(int[] a, int[] b){
		int len = a.length+b.length;
		int alen = a.length;
		int blen = b.length;
		int[] c = new int[len];
		int shorterlen = alen > blen? blen:alen;
		int j=1, k=0;
		
		for(int i =0;i<shorterlen;i++){
			c[k++] = a[i];
			c[k++] = b[i];
		}
		while(shorterlen < alen)
			c[k++] = a[shorterlen++];
		while(shorterlen < blen) c[k++] = b[shorterlen++];
		System.out.println("New Array: "+Arrays.toString(c));
		
	}

}
