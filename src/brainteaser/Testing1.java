package brainteaser;

public class Testing1 extends Testing{
	
	
	
	
	
	protected Testing1(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	protected int get(int x,int y){
		return x+y;
		
	}
	
	
	public static void maths() throws ArithmeticException{
		int x = 6;
		int y = 0;
		
		int z = x/y;
	}
	
	public static void main(String[] args){
		maths();
	}
	

}
