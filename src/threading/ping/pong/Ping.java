package threading.ping.pong;

public class Ping implements Runnable{

	private PingPong p;
	
	
	
	public Ping(PingPong p) {
		this.p = p;
	}



	@Override
	public void run() {
		try {
			p.ping();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
