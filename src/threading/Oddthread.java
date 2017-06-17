package threading;

public class Oddthread implements Runnable{
	
	private OddEven odd ;
	
	public  Oddthread(OddEven odd) {
		// TODO Auto-generated constructor stub
		this.odd = odd;
	}

	@Override
	public void run(){
		// TODO Auto-generated method stub
		try {
			odd.printodd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
