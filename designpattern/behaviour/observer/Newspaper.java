package behaviour.observer;

public class Newspaper implements Observer {

	@Override
	public void notify(float interest) {
		// TODO Auto-generated method stub
		System.out.println("Newspaper get Notifyed. Interest change to: "+interest);
	}

}
