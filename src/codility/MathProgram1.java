package codility;




/*
 * Number of perfect squares between two given numbers
Given two given numbers a and b where 1<=a<=b, find the number of perfect squares between a and b (a and b inclusive).

Examples

Input :  a = 3, b = 8
Output : 1
The only perfect in given range is 4.

Input : a = 9, b = 25
Output : 3
The three squares in given range are 9, 
16 and 25

 * 
 * 
 * */

public class MathProgram1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Count between number: "+approach2(15, 26));
		//sqrt(26);
	}
	
	
	private static int approach1(int a, int b){
		if(a > b) return 0;
		
		int count =0;
		for(int i =a;i<=b;i++){
			int number =i;
			int sqrt = (int) Math.sqrt(i);
			if(sqrt * sqrt ==number){
				count++;
				System.out.println(number+ " = "+sqrt+"*"+sqrt);
			}
		}
		
		
		return count;
	}
	
	private static int approach2(int a, int b){
		return (int) (Math.floor(Math.sqrt(b)) -
                Math.ceil(Math.sqrt(a)) + 1);
	}
	
	private static void sqrt(int a){
		System.out.println( Math.ceil(Math.sqrt(a)));
	}

}
