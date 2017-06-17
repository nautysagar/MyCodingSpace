package codility;

import java.util.Arrays;

public class Bug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(solution(955));
	}

	
	
	 private static  int solution(int n) {
		 int[] d = new int[30];
	        int l = 0, res = -1;
	        while (n > 0) {
	            d[l] = n % 2;
	            n /= 2;
	            l++;
	        }
System.out.println(Arrays.toString(d));
	        for (int p = 1; p < l; p++) {
	            if (p <= l / 2) {
	                boolean ok = true;
	                for (int i = 0; i < l - p; i++) {
	                    if (d[i] != d[i + p]) {
	                        ok = false;
	                        break;
	                    }
	                }
	                if (ok) {
	                    res = p;
	                }
	            }
	        }

	        return res;
	    
	    }
	}

