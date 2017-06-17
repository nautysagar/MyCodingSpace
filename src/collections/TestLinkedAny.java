package collections;

import java.util.Arrays;

import collections.MySingleLinkedList.Entry;

public class TestLinkedAny {

	static MySingleLinkedList<Integer> ss = new MySingleLinkedList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ss.add(10);
		ss.add(20);
		ss.add(03);
		ss.add(8);
		ss.add(13);
		ss.add(81);
		
		swapsingly(3,13);
	}

	private static void swapsingly(int key1,int key2){
		//	key1= 3;
		//	key2 = 13;
			Entry<Integer> k = ss.first;
			if(key1 == key2) return;
			
			Entry<Integer> p1 = null;
			Entry<Integer> c1= ss.first;
			Entry<Integer> p2 = null;
			Entry<Integer> c2 = ss.first;
			boolean found1 = false;
			boolean found2 = false;
			
			while ( k != null){
				if ( !found1 && k.value == key1) {
					found1 = true;
					c1 = k;
				} else {
					p1 = k;
				}
				
				if ( !found2 && k.value == key2) {
					found2 = true;
					c2 = k;
				} else {
				p2 = k;
				}
				k = k.next;
			}
			
			if(p1 != null){
				p1.next = c2;
			}
			
			if(p2 != null){
				p2.next = c1;
			}
			
			
			Entry<Integer> temp = c2.next;
			c2.next = c1.next;
			c1.next = temp;
			
			prittyprint(ss.first);
			
		}
	
	private static void prittyprint(Entry<Integer> prev){
		
		while(prev != null){
			System.out.println(prev.value);
			prev= prev.next;
		}
		
	}
}
