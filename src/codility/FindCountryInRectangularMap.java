package codility;
/*
 * A rectangular map consisting of N rows and M columns of square areas 
is given. Each area is painted with a certain color. 

Two areas on the map belong to the same country if the following 
conditions are met: 

they have the same color; 
it is possible to travel from one area to the other by moving only 
north, south, west or east without moving over areas of a different 
color. 

The map can be described by a zero-indexed matrix consisting of N rows 
and M columns of integers. The color of each area is described by the 
corresponding element of the matrix. Two areas have the same color if 
and only if their corresponding matrix elements have the same value. 

For example, consider the following matrix A consisting of seven rows 
and three columns: 

A[0][0] = 5    A[0][1] = 4    A[0][2] = 4 
A[1][0] = 4    A[1][1] = 3    A[1][2] = 4 
A[2][0] = 3    A[2][1] = 2    A[2][2] = 4 
A[3][0] = 2    A[3][1] = 2    A[3][2] = 2 
A[4][0] = 3    A[4][1] = 3    A[4][2] = 4 
A[5][0] = 1    A[5][1] = 4    A[5][2] = 4 
A[6][0] = 4    A[6][1] = 1    A[6][2] = 1 

Matrix A describes a map that is colored with five colors. Areas on 
the map belong to eleven different countries: 

area A[0][0] forms a one-area country; 
areas A[0][1], A[0][2], A[1][2], A[2][2] belong to the same country; 
area A[1][0] forms a one-area country; 
area A[1][1] forms a one-area country; 
area A[2][0] forms a one-area country; 
areas A[2][1], A[3][0], A[3][1], A[3][2] belong to the same country; 
areas A[4][0], A[4][1] belong to the same country; 
areas A[4][2], A[5][1], A[5][2] belong to the same country; 
area A[5][0] forms a one-area country; 
area A[6][0] forms a one-area country; 
areas A[6][1], A[6][2] belong to the same country. 

Write a function 

int countries_count(const vector< vector<int> > &A); 

that, given a zero-indexed matrix A consisting of N rows and M columns 
of integers, returns the number of different countries that the areas 
of the map described by matrix A belong to. 

Assume that: 

N is an integer within the range [1..1,000,000]; 
M is an integer within the range [1..1,000,000]; 
the number of elements in matrix A is within the range [1..1,000,000]; 
each element of matrix A is an integer within the range 
[-1,000,000,000..1,000,000,000]. 

For example, given matrix A consisting of seven rows and three columns 
corresponding to the example above, the function should return 11. 

Complexity: 

expected worst-case time complexity is O(N*M); 
expected worst-case space complexity is O(N*M). 
 * 
 * 
 * 
 * 
 * 
 * */
 
public class FindCountryInRectangularMap {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[][] A = new int[7][3];
		A[0][0] = 5;    A[0][1] = 4;    A[0][2] = 4 ;
				A[1][0] = 4 ;   A[1][1] = 3   ; A[1][2] = 4 ;
				A[2][0] = 3  ;  A[2][1] = 2  ;  A[2][2] = 4 ;
				A[3][0] = 2   ; A[3][1] = 2  ;A[3][2] = 2 ;
				A[4][0] = 3    ;A[4][1] = 3   ; A[4][2] = 4 ;
				A[5][0] = 1    ;A[5][1] = 4  ;  A[5][2] = 4 ;
				A[6][0] = 4    ;A[6][1] = 1 ;   A[6][2] = 1 ;
				
				
			System.out.println(countries_count(A));	

	}

	
	

		private static int countries_count(int[][] A) {
		   int N = A.length;
		   int M = A[0].length;
		   boolean[][] W = new boolean[N][M];
		  int sum = 0;
		  for(int i = 0;i< N;i++){
			  for(int j =0;j<M;j++){
				  if(W[i][j]) 
					  continue;
				  sum++;
				  color(A[i][j],W,A,i,j);
		  }
		 }
		  return sum;
		}
		
		private static void color(int val,boolean[][] B,int[][] A,int i,int j){
			if(i < 0 || i >A.length-1) return;
			if(j < 0 || j > A[0].length-1) return;
			
			if(B[i][j]) return;
			if(A[i][j] != val) return;
			
			B[i][j] = true;
			color(val,B,A,i+1,j);
			color(val, B, A, i-1, j);
			color(val,B,A,i,j+1);
			color(val, B, A, i, j-1);
			
		}
		
}
