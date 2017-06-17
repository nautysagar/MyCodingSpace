package threading.ping.pong;

public class TestPingPong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PingPong p = new PingPong();
		
		Thread t1 = new Thread(new Ping(p));
		Thread t2 = new Thread(new Pong(p));
		
		t1.start();
		t2.start();
	}

}
