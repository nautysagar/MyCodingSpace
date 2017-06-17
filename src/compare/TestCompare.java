package compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Compare c1 = new Compare();
		c1.setAge(10);
		c1.setName("Vivek");
		c1.setRollno(1);
		
		
		Compare c11 = new Compare();
		c11.setAge(1);
		c11.setName("Musu");
		c11.setRollno(2);
		
		Compare c111 = new Compare();
		c111.setAge(20);
		c111.setName("Anu");
		c111.setRollno(3);
		
		List<Compare> kk = new ArrayList<Compare>();
		kk.add(c1);
		kk.add(c11);
		kk.add(c111);
		
		System.out.println("Before Sort: "+ kk.get(0) +" "+  kk.get(1) );
		Collections.sort(kk,new Compare());
		System.out.println("After Sort: "+ kk.get(0) +" "+  kk.get(1) );
		
	}

}
