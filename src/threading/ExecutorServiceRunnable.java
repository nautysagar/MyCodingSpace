package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executeservice();
	}
	
	
	
	
	public static void executeservice(){
		ExecutorService exe = Executors.newFixedThreadPool(5);
		
		for(int i =0;i <5;i++){
			exe.execute(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
					System.out.println("Hello Vivek: "+ Thread.currentThread().getName());
				
						//Thread.sleep(100);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
		}
		
		exe.shutdown();
		while(!exe.isTerminated()){
			System.out.println("Not terminited: "+ Thread.currentThread().getName());
		}
		
		System.out.println("Finished All thread");
	}

}
