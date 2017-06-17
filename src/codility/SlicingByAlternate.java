package codility;

import java.util.ArrayList;

public class SlicingByAlternate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MaxAltSignSize mas = new MaxAltSignSize();
		int input[] = {1, -5, 23, 0, 1, 1, 0, 2, -5, 3, -1, 1, 2, 3};
		
		
			System.out.print(getMaxArray(input));
		
	}
	private static int getMaxArray(int[] a) {
		if  (a.length  <=  1)
	        return a.length;
	    int curRes = 0;
	    int maxRes = 0;
	    int i = 0;
	    while (i  <  a.length && a[i]  ==  0)   {
	        curRes++;
	        i++;
	    }
	    if  (i  <  a.length)  {            
	        int zeros = 0;
	        int prevNonZero  =  a[i];
	        curRes++;
	        i++;
	        while  (i  <  a.length)  {
	            if  (a[i]  ==  0)  {
	                curRes++;
	                zeros++;
	            } else {
	                if  ((a[i]  >  0  &&  prevNonZero  >  0)  ||  (a[i]  <  0  &&  prevNonZero  <  0))  {
	                    if  (zeros  >  0)  {
	                        if  (zeros % 2  ==  1)
	                            curRes  +=  1;
	                        else {
	                            maxRes  =  Math.max(maxRes,  curRes);
	                            curRes  =  zeros  +  1;
	                        }
	                        zeros  =  0;
	                    }
	                    else {
	                        maxRes  =  Math.max(maxRes,  curRes);
	                        curRes  =  zeros  + 1;
	                    }
	                }
	                else {
	                    if  (zeros  ==  0) 
	                        curRes++;
	                    else {
	                        if  (zeros%2  ==  0)  {
	                            curRes  +=  1;
	                        }
	                        else {
	                            maxRes  =  Math.max(maxRes, curRes);
	                            curRes  =  zeros + 1;
	                        }
	                        zeros  =  0;
	                    }
	                }
	                prevNonZero  =  a[i];
	            }
	            i++;
	        }
	    }
	    maxRes  =  Math.max(maxRes, curRes);
	    return maxRes;
}
	
	private static int solution2(int[] nums){
		  int max = 0;
	        for(int i=0, j=1; j<nums.length; j++) {
	        	if((long)nums[j] == 0 &&  (long)nums[j-1] ==0){
	        		if(j-2 > -1) {
	        			nums[j-1] = Integer.signum(nums[j-2]) * -1;
	        			nums[j] = -(nums[j-1]);
	        		}
	        	}
	            if( (long)nums[j] * (long)nums[j-1] > 0) {
	                max = Math.max(max, j-i);  //j-i is the count of current alternating slice size.
	                i = j;
	            }
	        }
	        return max;
	}

}
