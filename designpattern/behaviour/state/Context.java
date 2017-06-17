package behaviour.state;

public class Context implements State{
	
	State st;
	
	public Context(State st){
		this.st = st;
	}

	public State getSt() {
		return st;
	}

	public void setSt(State st) {
		this.st = st;
	}

	@Override
	public String SayHello() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String SayBye() {
		// TODO Auto-generated method stub
		return null;
	}

}
