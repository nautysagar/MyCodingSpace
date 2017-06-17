package behaviour.observer;

public class Internet implements Observer {

	@Override
	public void notify(float interest) {
		// TODO Auto-generated method stub
		System.out.println("Internet get Notifyed. Interest change to: "+interest);
	}

}
