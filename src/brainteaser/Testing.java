package brainteaser;

public class Testing {
	
	protected Testing(String name){
		
	}
	
	private Testing(){
		
	}
	
	private static final Testing INSTANCE = new Testing();
	
	public static Testing getTesting(){
		return INSTANCE;
	}
	
	
	protected int get(int x,int y){
		return x+y;
		
	}

}
