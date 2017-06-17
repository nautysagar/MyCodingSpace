package codility;

import java.util.Arrays;

public class IncrementDecrementBy1Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-11,7,3,2};
		numberOfSteps(a);
		//System.out.println(numberOfSteps(a));
	}

	
	public static void numberOfSteps(int[] a) {
	    
		//first find largest and smallest element from the array....
		int aitr = 0;
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		boolean flag = true;
		while (aitr < a.length){
			//if(maxValue) 
			if(a[aitr] > maxValue) {
				maxValue = a[aitr];
			}
			if(a[aitr]  < minValue)
				minValue = a[aitr];
			aitr++;
		}
		
		int avg = (int) Math.floor((Math.abs(maxValue) + Math.abs(minValue))/2);
		Arrays.sort(a);
		int count =0;
		while(flag){
			count++;
			for(int i =0;i< a.length;i++){
				if(a[i] > avg) a[i] = a[i]-1;
				else if(a[i] < avg) a[i] = a[i]+1;
			}
			
			if(checkArrayEquals(a, avg)){
				flag = false;
				break;
			}
			
			
			
		}
		
		
		
		
		System.out.println(count);
		
		
	}
	
	private static boolean checkArrayEquals(int[] array,int num){
		
		//boolean isFirstElementNull = array[0] == null;
	    for(int i = 0; i < array.length; i++)
	    {
	        if(array[i] != num) return false;
	    }

	    return true;
	}
}
