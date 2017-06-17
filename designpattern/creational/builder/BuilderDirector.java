package creational.builder;

public class BuilderDirector {

	private ConcreatBuilder build = null;
	
	public BuilderDirector(ConcreatBuilder build){
		this.build = build;
	}
	
	public void constructMeal(){
		build.buildDrink();
		build.buildMainCourse();
		build.buildSide();
	}
	
	public BuilderClass getbuilder(){
		return build.getMeal();
	}
	
}
