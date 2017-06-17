package interfaceTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestInterfaceTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//java.util.List<TestInterface> tt = new java.util.ArrayList<TestInterface>();
//		
//	tt.add(new TestInterfaceImplent());
//	tt.add(new TestAnother());
//		
//	for(TestInterface t : tt){
//		t.getStateName();
//		t.test();
//	}
		
		InputStream s = new FileInputStream("TestAnother.java");
		System.out.println(s.available());	
			
	}

}
