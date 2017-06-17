package threading;

public class TestparallelThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//beginthread();
		//processnext();
		

	}
	
	
	
	
	private static void beginthread(){
		PrintingThread tt = new PrintingThread();
		tt.start();
	}

	
	private static void processnext(){
		for(int i=0;i<100;i++) System.out.println("Next Process"+i);
	}
	
}
