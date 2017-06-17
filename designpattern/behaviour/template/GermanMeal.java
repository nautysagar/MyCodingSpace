package behaviour.template;

public class GermanMeal extends Meal{

	public GermanMeal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepareIngredient() {
		// TODO Auto-generated method stub
		System.out.println("Adding german salt in cooking");
	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub
		System.out.println("cooking in German Stoves");
	}

	@Override
	public void cleanup() {
		System.out.println("Throwing papers");
		
	}

}
