package behaviour.observer;

public class TestObserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observer s1 = new Newspaper();
		Observer s2 = new Internet();
		
		Subject s11 = new Loan(4.5f, "SBI", "Personal Loan");
		
		s11.registerObserver(s1);
		s11.registerObserver(s2);
		
		s11.notifyAllObserver(5.5f);
		
		
		
		
		
		

	}

}
