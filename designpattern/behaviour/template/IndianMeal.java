package behaviour.template;

public class IndianMeal extends Meal{

	public IndianMeal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void prepareIngredient() {
		// TODO Auto-generated method stub
		System.out.println("Adding Masala in cooking");
	}

	@Override
	public void cook() {
		// TODO Auto-generated method stub
		System.out.println("cooking in Indian Chulla");
	}

	@Override
	public void cleanup() {
		System.out.println("Cleaning utensil");
		
	}

}
