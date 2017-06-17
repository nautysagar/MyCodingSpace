package creational.builder;

public class IndianBuilder implements ConcreatBuilder{
	
	private BuilderClass ind;
	
	public IndianBuilder(){
		ind = new BuilderClass();
	}

	@Override
	public void buildDrink() {
		// TODO Auto-generated method stub
		ind.setDrink("Water");
	}

	@Override
	public void buildMainCourse() {
		// TODO Auto-generated method stub
		ind.setMainCourse("Paratha");
	}

	@Override
	public void buildSide() {
		// TODO Auto-generated method stub
		ind.setSide("juice");
	}

	@Override
	public BuilderClass getMeal() {
		// TODO Auto-generated method stub
		return ind;
	}
	

}
