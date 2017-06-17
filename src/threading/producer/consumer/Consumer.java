package threading.producer.consumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	
	private BlockingQueue<String> q;

	public Consumer(BlockingQueue<String> q) {
		this.q = q;
	}

	@Override
	public void run() {
		while(true){
		try {
			System.out.println("Consumed: "+ q.take());
			
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	}
	

}
