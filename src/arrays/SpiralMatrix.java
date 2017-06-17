package arrays;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a[][] = { {1,  2,  3,  4,  5},
			        {16, 17,  18,  19, 6},
			        {15, 22, 21, 20, 7},
			        {14, 23, 24, 25, 8},
			        {13, 12, 11, 10, 9}
			    };
			 int R = a.length;
			 int C = a[0].length;
			 soultion(R, C, a);

	}
	
	private static void soultion(int m, int n,int[][] arr){
		int x = 0;  //start of row
		int y = 0; // start of column  
		int i = 0; // start of iteration
		
		while(x < m && y < n){
		for(i=y;i<n;i++){
			System.out.println(arr[x][i]);
		}
		x++;
		
		for(i=x;i< m;i++){
			System.out.println(arr[i][n-1]);
		}
		n--;
		
		if(x < m){
		for(i=n-1;i>=y;i--){
			System.out.println(arr[m-1][i]);
		}
		m--;
		}
		if(y < n){
		for(i=m-1;i>=x;i--){
			System.out.println(arr[i][y]);
		}
		y++;
		}
		
		}
	}

}
