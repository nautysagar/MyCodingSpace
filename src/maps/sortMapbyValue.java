package maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.Map.Entry;

public class sortMapbyValue {
	private static Map<Integer,String> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map = new HashMap<Integer,String>();
		map.put(1, "Axes");
		map.put(5, "ALU");
		map.put(11, "Juniper");
		map.put(45, "Cisco");
		
		sort(map);

	}
	
	
	private static void sort(Map<Integer,String> pmap){
		if(pmap.isEmpty()) return;
		Set<Entry<Integer,String>> ss = pmap.entrySet();
		List<Entry<Integer,String>> ll = new ArrayList<Entry<Integer,String>>(ss);
		
		Collections.sort(ll, new Comparator<Map.Entry<Integer, String>>() {

			@Override
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				// TODO Auto-generated method stub
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		for(Entry<Integer,String> e: ll){
			System.out.println(e.getKey() +" "+e.getValue());
		}
	}
	
	
	

}
