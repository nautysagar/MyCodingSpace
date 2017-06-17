package brainteaser;

public class TowerOfHenoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toh(4,'A','B','C');
	}
	
	
	
	private static void toh(int n, char leftpole, char rightpole,char midpole){
		
		if(n == 1) {
			System.out.println("Moving "+ n + "from pole "+leftpole+"to "+ rightpole);
			return;
		}
		
		
		toh(n-1,leftpole,midpole,rightpole);
		System.out.println("Moving "+ n + "from pole "+leftpole+"to "+ rightpole);
		toh(n-1,midpole,rightpole,leftpole);
	}

}
