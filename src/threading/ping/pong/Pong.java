package threading.ping.pong;

public class Pong implements Runnable{

	private PingPong p;
	
	
	
	public Pong(PingPong p) {
		this.p = p;
	}



	@Override
	public void run() {
		try {
			p.pong();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
