package codility;



public class SumOfArrayBy3Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {38, 27, 43, 3, 9, 82, 10};
	     System.out.println("Add after forloop: "+ sumByForloop(a));
	     System.out.println("Add after while: "+ sumByWhile(a));
	     System.out.println("Add after rec: "+ sumByRec(a,a.length-1));

	}
	
	
	private static int sumByForloop(int[] a){
		int sum = 0;
		for(int i=0;i< a.length;i++){
			sum+=a[i];
		}
		return sum;
	}

	private static int sumByWhile(int[] a){
		int sum = 0,i=0;
		while(i < a.length){
			sum+=a[i];
		i++;
		}
		return sum;
	}
	private static int sumByRec(int[] a,int n){
		if (n == 0)
	        return a[n];
	    else
	        return a[n] + sumByRec(a, n-1);
	}
}
