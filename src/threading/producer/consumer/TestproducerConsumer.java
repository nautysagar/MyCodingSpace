package threading.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestproducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<String> q =  new ArrayBlockingQueue<>(2);
		
		Thread t1 = new Thread(new Producer(q));
		
		Thread t2 = new Thread(new Consumer(q));
		
		t1.start();
		t2.start();
		
		

	}

}
