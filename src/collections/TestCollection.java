package collections;

import java.util.ArrayList;
import java.util.Iterator;
import  java.util.List;

public class TestCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> tt = new ArrayList<String>();
		tt.add("test1");
		tt.add("test11");
		tt.add("test111");
		
		Iterator<String> itr = tt.iterator();
		
		while(itr.hasNext()){
			if(itr.next().equals("test11")){
		itr.remove();
		}
	}
}
}
