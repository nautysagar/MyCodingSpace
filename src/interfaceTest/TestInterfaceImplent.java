package interfaceTest;

public class TestInterfaceImplent implements TestInterface{

	@Override
	public void getStateName() {
		System.out.println("Karnataka");
		
	}

	@Override
	public void getCityName() {
		// TODO Auto-generated method stub
		System.out.println("Bangalore");
	}

	public void test(){
		System.out.println("test");
	}
	
}
