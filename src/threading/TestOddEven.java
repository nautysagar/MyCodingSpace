package threading;

public class TestOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		OddEven oe = new OddEven();
		
		Runnable r1 = new Eventhread(oe);
		Runnable r2 = new Oddthread(oe);
		
		new Thread(r1).start();
		new Thread(r2).start();

	}

}
