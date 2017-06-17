package threading;

public class OddEven {
	
	private volatile Boolean flag = true;
	
	private volatile int num = 2;
	
	
	
	public void printodd() throws InterruptedException{
		int k = 0;
		while ( k < 10){
			synchronized(this){
				k++;
			if(num % 2 == 0){
				System.out.println("Even number:"+ num +'\n');
				num++;
				notify();
				
			} else {
				wait();
			}
			
			
		}
		
		}
		
		
	}
	
	public void printeven() throws InterruptedException{
		int k = 0;
		while ( k < 10){
			synchronized(this){
				k++;
			if(num % 2 != 0){
				System.out.println("Odd number:"+ num +'\n');
				num++;
				notify();
				
			} else {
				wait();
			}
			
			
		}
		
		}
	}

}
