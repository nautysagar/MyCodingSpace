package maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapWithoutHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashClass h = new HashClass(5,"Vivek");
		HashClass h1 = new HashClass(51,"Vivek");
		
		
		Map<HashClass,Integer> map = new HashMap<HashClass,Integer>();
		map.put(h, h.getRollno());
		map.put(h1, h1.getRollno());
		
		System.out.println(map.size());
		System.out.println(map.get(h1));

	}

}
