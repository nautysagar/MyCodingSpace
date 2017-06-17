package behaviour.command;


public class DinnerCommand implements Command{
	
	private DinnerClass dd = null; 
	 
	public DinnerCommand(DinnerClass dd) {
		// TODO Auto-generated constructor stub
		this.dd = dd;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		dd.makedinner();
	}

}
