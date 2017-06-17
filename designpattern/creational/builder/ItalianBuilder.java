package creational.builder;

public class ItalianBuilder implements ConcreatBuilder{
	
	private BuilderClass bb;
	
	public ItalianBuilder(BuilderClass bb){
		bb = new BuilderClass();
	}

	@Override
	public void buildDrink() {
		// TODO Auto-generated method stub
		bb.setDrink("wine");
		
	}

	@Override
	public void buildMainCourse() {
		// TODO Auto-generated method stub
		bb.setMainCourse("piza");
	}

	@Override
	public void buildSide() {
		// TODO Auto-generated method stub
		bb.setSide("bread");
		
	}

	@Override
	public BuilderClass getMeal() {
		// TODO Auto-generated method stub
		return bb;
	}

}
