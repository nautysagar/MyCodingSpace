package behaviour.command;


public class LunchCommand implements Command{
	
	private LunchClass ll = null; 
	 
	public LunchCommand(LunchClass ll) {
		// TODO Auto-generated constructor stub
		this.ll = ll;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ll.makelunch();
	}

}
