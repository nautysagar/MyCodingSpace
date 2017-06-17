package threading.ping.pong;

public class PingPong {

	private volatile boolean flag = true;

	public void ping() throws InterruptedException {
		int k = 0;
		while (k < 5) {
			synchronized (this) {
				k++;
				if (flag) {
					System.out.println("ping");
					flag = false;
					notify();
				} else {
					wait();
				}
			}

		}
	}

	public void pong() throws InterruptedException {
		int kkk = 0;
		while (kkk < 5) {
			synchronized (this) {
				kkk++;
				if (!flag) {
					System.out.println("pong");
					flag = true;
					notify();
				} else {
					wait();
				}
			}
		}
	}
}
