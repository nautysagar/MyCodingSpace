package collections;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import collections.MyDoublyLinkedList.Node;
import collections.MySingleLinkedList.Entry;



public class TestLinkedlist<E>{
	MyDoublyLinkedList<Integer> tt = new MyDoublyLinkedList<Integer>();
	MySingleLinkedList<Integer> ss = new MySingleLinkedList<Integer>();
	
	@Before
	public  void adddouble(){
		
		tt.add(10);
		tt.add(20);
		tt.add(03);
		tt.add(8);
		tt.add(13);
		tt.add(81);
		System.out.println("Passed test");
	}
	
	@Before
	public  void addSingle(){
		
		ss.add(10);
		ss.add(20);
		ss.add(03);
		ss.add(8);
		ss.add(13);
		ss.add(81);
		System.out.println("Passed test");
	}
	
	@Test
	public void swapdoubly(){
		prittyprint();
		swapdoubly(2,4);
		prittyprint();
	}
	
	//Swap two Nodes in Doubly linked list
	
	private void swapdoubly(int index1,int index2){
		index1= 2;
		index2 = 4;
		
		if(index1 == index2) return;
		Node<Integer> t1 = tt.findNode(index1);
		Node<Integer> t2 = tt.findNode(index2);
		
		if(t1 ==  t2 ) return;
		
		// case when both are adjacent Node
		if(t1.right == t2) {
			t1.right = t2.right; 
			t2.left = t1.left;
			
			if(t1.right != null) t1.right.left = t1;
			
			if(t2.left != null) t2.left.right = t2;
			
			t1.left = t2;
			t2.right =t1;
			
			
		} else {
			// store prev and next of 2nd node
			
			Node<Integer> p = t2.left;
			Node<Integer> n = t2.right;
			
			t2.left = t1.left;
			t2.right = t1.right;
			
			t1.left = p;
			t1.right = n;
			
			if(t2.left != null){
				t2.left.right = t2;
			}
			
			if(t2.right != null){
				t2.right.left = t2;
			}
			
			if(t1.left != null){
				t1.left.right = t1;
			}
			
			if(t1.right != null){
				t1.right.left = t1;
			}
		}
		
		
	}
	
	@Test
	public void swapsingly(){
		swapsingly(3,13);
	}
	
	// Swap Singly linked list.....
	
	private void swapsingly(int key1,int key2){
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
			}
			p1 = k;
			if ( !found2 && k.value == key2) {
				found2 = true;
				c2 = k;
			}
			p2 = k;
			
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
		
	}
	
	
	//Reverse Singly linkedlist....
	@Test
	public void reversesingly(Entry<Integer> root){
		Entry<Integer> prev = null;
		Entry<Integer> curr = root;
		Entry<Integer> next = null;
		
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		prittyprint(prev);
	}
	
	@Test
	public Entry<Integer> reversesinglyrecursively(Entry<Integer> root){
		
		if(root == null || root.next == null) return root;
		
		Entry<Integer> rem = reversesinglyrecursively(root.next);
		root.next.next = root;
		root.next = null;
		
		return rem;
		
	}
	
	
	//Reverse doubly linked list....
	@Test
	public void reversedoubly(Node<Integer> root){
		Node<Integer> prev = null;
		Node<Integer> curr = root;
		while(curr != null){
			prev = curr.left;
			curr.left = curr.right;
			curr.right = prev;
			curr = curr.left;
		}
		
//		temp = curr.right;
//		curr.right = curr.left;
//		curr.left = temp
//		prev = curr;
//		curr = temp;
		
	//	prittyprint(prev);
	}
	
	
	//Middle of LinkedList....
	@Test
	public void middleElement(){
		
		Node<Integer> first = tt.first;
		Node<Integer> second = tt.first;
		
		while(second != null && second.right != null){
			second = second.right.right;
			first= first.right;
		}
		
		System.out.println("Middle of Linkedlist: "+ first.value);
	}
	
	@Test
	public void makecircularlinkedlistDoubly(){
		if(tt.last != null) 
			tt.last.right = tt.first;
		    tt.first.left = tt.last;
	}
	
	@Test
	public void makecircularlinkedlistSingly(){
		if(ss.last != null) 
			ss.last.next = ss.first;
	}
	
	
	public void iscircular(){
		Node<Integer> a = tt.first;
		Node<Integer> b = null;
		if(a != null && a.right !=null ) b= a.right.right;
		
		while(b != null && b.right != null){
			if(a == b) System.out.println("Linkedlist is circular");
			a = a.right;
			b= b.right.right;
		}
		
	}
	
	
	public void nthelement(int k){
		Entry<Integer> a = ss.first;
		Entry<Integer> b = null;
		
		if (k > 0){
			while(k > 0){
				b = a.next;
				k--;
			}
		}
		
		while (b != null){
			a = a.next;
			b = b.next;
		}
		
		System.out.print("Nth Element from the last: "+ a.value);
		
		
	}
	
	
	private void prittyprint(){
		Node<Integer> t = tt.first;
		while(t != null){
			System.out.println(t.value);
			t= t.right;
		}
		System.out.println("null");
	}
	
	private void prittyprint(Entry<Integer> prev){
		
		while(prev != null){
			System.out.println(prev.value);
			prev= prev.next;
		}
		
	}
	
	@Test
	public void getIndex(){
		System.out.print(ss.contains(34));
	}
}
