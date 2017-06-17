package creational.factory;

public class TestFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoryMethod mm = FactoryMethod.getInstance();
		mm.getVoice("dog");
		mm.getVoice("cat");
	}

}
