package threading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCallable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		executeservice();
	}
	
	
	
	
	public static void executeservice(){
		ExecutorService exe = Executors.newFixedThreadPool(5);
		List<Future<String>> ff = new ArrayList<Future<String>>();
		
		for(int i =0;i <5;i++){
			Future<String> ss = exe.submit(new Callable<String>() {
		 

				@Override
				public String call() {
					// TODO Auto-generated method stub
				
					return "Hello Vivek: "+ Thread.currentThread().getName();
				
				}
				
			});
			ff.add(ss);
		}
		
		
		Iterator<Future<String>> itr = ff.iterator();
		while(itr.hasNext()){
			try {
				System.out.println(itr.next().get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		exe.shutdown();
		System.out.println("Finished All thread");
	}

}
