package behaviour.strategy;

public class Context {

	Strategy st;
	
	public Context(Strategy st){
		this.st = st;
	}
	
	public int getStrategy(int a, int b){
		return st.doOperation(a, b);
	}
	
	
}
