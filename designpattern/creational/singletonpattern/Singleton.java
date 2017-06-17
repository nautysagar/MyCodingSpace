package creational.singletonpattern;

public class Singleton {

	private static Singleton instance = null;
	
	private static final Singleton eagerinstance = new Singleton();
	private Singleton(){
	}
	
	
	//Double locking 
	public static Singleton getInstance(){
		
		if(instance == null){
			synchronized(Singleton.class){
				if(instance == null){
					instance = new Singleton();
				}
			}
		}
		
		return instance;
	}
	
	//fast and single 
	
	public static Singleton EagerInstance(){
		return eagerinstance ;
	}
	
	
	
}
