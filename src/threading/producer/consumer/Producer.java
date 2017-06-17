package threading.producer.consumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<String> q;

	public Producer(BlockingQueue<String> q) {
		// TODO Auto-generated constructor stub
		this.q = q;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//int i = 5;
		for(int i=0; i<10; i++){
			try {
				System.out.println("Produced "+i);
				q.put("Hello " + i);
				Thread.sleep(1000);
				//i--;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
