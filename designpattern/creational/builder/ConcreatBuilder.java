package creational.builder;

public interface ConcreatBuilder {
	
	public void buildDrink();

	public void buildMainCourse();

	public void buildSide();

	public BuilderClass getMeal();
	

}
