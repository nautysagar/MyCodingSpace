package creational.factory;

public class FactoryMethod {
	
	
	private FactoryMethod(){
		
	}
	
	private static  FactoryMethod Instance;
	
	
	public static FactoryMethod getInstance(){
		if(Instance == null) {
			synchronized(FactoryMethod.class){
				if(Instance == null){
					Instance = new FactoryMethod();
				}
			}
		}
		
		return Instance;
		
	}
	
	protected  void getVoice(String type){
		if(type != null){
		if(type.equalsIgnoreCase("dog")){
			 new DogSound().makesound();
		} else if(type.equalsIgnoreCase("cat")){
			 new CatSound().makesound();
		} else {
			 new HenSound().makesound();
		}
		
	}
		
	}
	
	

}
