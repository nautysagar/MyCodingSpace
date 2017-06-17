package threading;

public class Eventhread implements Runnable{
	
	private OddEven even ;
	
	public  Eventhread(OddEven even) {
		// TODO Auto-generated constructor stub
		this.even = even;
	}

	@Override
	public void run(){
		// TODO Auto-generated method stub
		try {
			even.printeven();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
