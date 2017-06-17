package codility.arrays;

import java.util.Arrays;

public class SortPossibilityArrayBySwapOnce {
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,5,4,3,2,7};
	     System.out.println("Array after Sorting: "+ solution(a,a.length));
	}
	static boolean  swapped = false;
	
	private static boolean solution(int A[],int N){
		 // write your code in C# 6.0 with .NET 4.5 (Mono)
        int LeftIdx = 0;
        int RightIdx = A.length - 1;
        
        while (LeftIdx < RightIdx + 1)
        {
            if ((LeftIdx < A.length - 1) && A[LeftIdx] > A[LeftIdx + 1])
            {
                if (swapped) return false;
                //find right
                while (RightIdx > LeftIdx)
                {
                    if (RightIdx > 0 && A[RightIdx] <= A[RightIdx - 1])
                    {
                        Swap(A, LeftIdx, RightIdx);
                        break;
                    }
                    else
                        RightIdx--;
                }
            }
            else
                LeftIdx++;
        }

        return true;
	}
	
	static void Swap(int[] A, int SourceIdx, int TargetIdx)
    {
        int Temp = A[SourceIdx];
        A[SourceIdx] = A[TargetIdx];
        A[TargetIdx] = Temp;
        swapped = true;
    }

}
