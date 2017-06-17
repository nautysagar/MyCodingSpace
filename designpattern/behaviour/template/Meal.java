package behaviour.template;

public abstract class Meal {

	public Meal() {
		// TODO Auto-generated constructor stub
	}
	
	
	public  final void doMeal(){
		prepareIngredient();
		cook();
		eat();
		cleanup();
	}
	
	public  abstract void prepareIngredient();
	
	public  abstract void cook();
	
	public void eat(){
		System.out.println("Its good food");
	}
	
	public abstract void cleanup(); 
	

}
