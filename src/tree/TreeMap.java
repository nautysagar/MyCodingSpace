package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TreeMap<K,V> implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Comparator<? super K> cpr;
	
	transient MapEntry<K,V> root = null;
 	
	private transient int size = 0;
	
	private transient int modCount = 0;
	
	
	public TreeMap(){
		cpr = null;
	}
	
	public TreeMap(Comparator<? super K> cpr){
		this.cpr = cpr;
	}
	
	private static final boolean RED   = false;
    private static final boolean BLACK = true;
	
	
	static class MapEntry<K,V> implements Map.Entry<K, V> {

		K key;
		V value;
		MapEntry<K,V> left;
		MapEntry<K,V> right;
		MapEntry<K,V> parent;
		MapEntry<K,V> nextright = null;
		 boolean color = BLACK;
		
		public MapEntry(K key,V value,MapEntry<K,V> p){
			this.key = key;
			this.value = value;
			this.parent = p;
		}
		
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			V old = this.value;
			this.value = value;
			return old;
		}
		
		public boolean equals(Object o){
			if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;

            return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
		}
		
		public int hashCode(){
				int keyHash = (key==null ? 0 : key.hashCode());
	            int valueHash = (value==null ? 0 : value.hashCode());
	            return keyHash ^ valueHash;
		}
		
		public String toString(){
			return key + "="+value;
		}
		
		 final boolean valEquals(Object o1, Object o2) {
	        return (o1==null ? o2==null : o1.equals(o2));
	    }
		
	}
	
	@SuppressWarnings("unchecked")
	public V put(K key, V value){
		MapEntry<K, V> t = root;
		if(t == null){
			root = new MapEntry<>(key, value, null);
			size++;
			modCount++;
			return null;
		}
		
		int cmp;
		MapEntry<K, V> p ;
		
		if(cpr != null){
			 K k = (K) key;
			do {
				p = t;
				cmp = cpr.compare(k,t.key);
				if(cmp < 0){
					t= t.left;
				} else if(cmp > 0){
					t = t.right;
				} else {
					return t.setValue(value);
				}
			} while (t != null);
			
		} else {
			if(key == null) throw new NullPointerException();
			Comparable<? super K> k = (Comparable<? super K>) key;
			do {
				p = t;
				cmp = k.compareTo(t.key);
				if(cmp < 0){
					t= t.left;
				} else if(cmp > 0){
					t = t.right;
				} else {
					return t.setValue(value);
				}
			} while (t != null);
		}

		MapEntry<K, V> e = new MapEntry<>(key, value, p);
		if(cmp < 0){
			p.left = e;
		} else {
			p.right =e;
		}
		size++;
		modCount++;
		return null;
		
	}
	
	public V get(K key){
		MapEntry<K, V> e = getEntry(key);
		
		return (e != null? e.getValue():null);
	}
	
	
	@SuppressWarnings("unchecked")
	private MapEntry<K,V> getEntry(K key){
		MapEntry<K, V> t = root;
		int cmp;
		
		if(cpr != null) {
			 K k = (K) key;
			while( t != null) {
				cmp = cpr.compare(k,t.key);
				if(cmp < 0){
					t = t.left;
				} else if(cmp > 0){
					t = t.right;
				} else {
					return t;
				}
			}
			
		} else {
			Comparable<? super K> kk = (Comparable<? super K>) key;
			while( t != null) {
				cmp = kk.compareTo(t.key);
				if(cmp < 0){
					t = t.left;
				} else if(cmp > 0){
					t = t.right;
				} else {
					return t;
				}
			}
			
		}
		
		return null;
		
	}
	
	// Delete node
	
	 /* case 1 : Node has one leaf only
		case 2 : node has left and right node both
		case 3 : node has no leaf  
	
	 */
	
	public V remove(K key){
		size--;
		modCount++;
		
		MapEntry<K, V> t = getEntry(key);
		if(key == null) return null;
		
		V oldvalue = t.getValue();
		
		if(t.left != null && t.right != null){
			MapEntry<K, V> p = findMin(t.right);
			MapEntry<K, V> temp = t;
			t =p;
			temp = null;
		} else if (t .left != null){
			MapEntry<K, V> temp = t;
			t = t.left;
			temp = null;
		} else if (t .right != null){
			MapEntry<K, V> temp = t;
			t = t.right;
			temp = null;
		} else {
			if(t == t.parent.left){
				t.parent.left = null;
			} else {
				t.parent.right = null;
			}
		}
		
		return oldvalue;
		
	}
	
	
	public MapEntry<K, V> findMin(MapEntry<K, V> first){
		while (first.left != null){
			first = first.left;
		}
		
		return first;
	}
	
	public MapEntry<K, V> findMax(MapEntry<K, V> first){
		while (first.right != null){
			first = first.right;
		}
		
		return first;
		
	}
	
	public MapEntry<K, V> findMinRecusion(MapEntry<K, V> first){
		if(first == null || first.left == null ) return first;
		
		return findMinRecusion(first.left);
	}
	
	
	public int heightofTree(MapEntry<K, V> t){
		if(t == null) return -1;
		
		int lh = heightofTree(t.left);
		int rh = heightofTree(t.right);
		return lh >=rh ? lh+1:rh+1;
		
	}
	
	//BFS traversal.....
	
	public void levelorder(){
		Queue<MapEntry<K, V>> qq = new LinkedList<MapEntry<K, V>>();
		MapEntry<K, V> t= root;
		qq.add(t);
		while(!qq.isEmpty()) {
			MapEntry<K, V> pp = qq.poll();
			System.out.println(pp);
			if(pp.left != null) qq.add(pp.left);
			if(pp.right != null) qq.add(pp.right);
		}
		
		
		
		
	}
	//DFS traversal.....
	
	public void preorderrec(MapEntry<K, V> t){
		
		if(t == null) return;
		System.out.println(t.key);
		preorderrec(t.left);
		preorderrec(t.right);
		
	}
	
	public void postorderrec(MapEntry<K, V> t){
		if(t == null) return;
		postorderrec(t.left);
		postorderrec(t.right);
		System.out.println(t.key);
	}
	
	public void inorderrec(MapEntry<K, V> t){
		if(t == null) return;
		inorderrec(t.left);
		System.out.println(t.key);
		inorderrec(t.right);
		
	}
	
	
	public void inorder(MapEntry<K, V> t){
		ArrayList<MapEntry<K, V>> list = new ArrayList<MapEntry<K, V>>();
		Stack<MapEntry<K, V>> ss = new Stack<MapEntry<K, V>>();
		//ss.push(t);
		while(!ss.isEmpty() || t != null){
			if(t != null){
				ss.push(t);
				t = t.left;
			} else {
				t = ss.pop();
				list.add(t);
				t = t.right;
				}
			
		}
		
		System.out.println(list);
		
	}
	
	
	public void preorder(MapEntry<K, V> t){
		ArrayList<MapEntry<K, V>> list = new ArrayList<MapEntry<K, V>>();
		Stack<MapEntry<K, V>> ss = new Stack<MapEntry<K, V>>();
		ss.push(t);
		while(!ss.isEmpty()){
			MapEntry<K, V> pp = ss.pop();
			list.add(pp);
			if(pp.right != null) ss.push(pp.right);
			if(pp.left != null) ss.push(pp.left);
		}
		
		System.out.println(list);
	}
	
	public void postorder(MapEntry<K, V> t){
		
		ArrayList<MapEntry<K, V>> list = new ArrayList<MapEntry<K, V>>();
		Stack<MapEntry<K, V>> ss = new Stack<MapEntry<K, V>>();
		//ss.push(t);
		MapEntry<K, V> lastvisited = null;
		while(!ss.isEmpty() || t != null){
			if(t != null){
				ss.push(t);
				t = t.left;
			} else {
				MapEntry<K, V> peek = ss.peek();
				if(peek.right != null && peek.right != lastvisited) {
					t = peek.right;
				} else {
				list.add(peek);
				lastvisited = ss.pop();
				}
			}
		}
		
		System.out.println(list);
		
	}
	
	
	public void connectnode2right(MapEntry<K, V> t){
		
		Queue<MapEntry<K, V>> qq = new LinkedList<MapEntry<K, V>>();
		t.nextright = null;
		qq.add(t);
		while(!qq.isEmpty()){
			MapEntry<K, V> e = qq.poll();
			
			if(e.left != null) {
				qq.add(e.left);
				
				if(e.right != null) {
					e.left.nextright = e.right;
				} else {
					if(e.nextright != null) {
						if(e.nextright.left != null)
						e.left.nextright = e.nextright.left;
						else 
							e.left.nextright = e.nextright.right;
					}
				}
				
				
			}
			
			if(e.right != null) {
				qq.add(e.right);
				if(e.nextright != null) {
					if(e.nextright.left != null)
					e.right.nextright = e.nextright.left;
					else 
						e.right.nextright = e.nextright.right;
				}
			}
			
		}
	}
	
	public int level(K key){
		int level =0; int cmp;
		Comparable<? super K> kk = (Comparable<? super K>) key;
		
		MapEntry<K, V> tt = root;
		while(true) {
			if(tt == null || tt.key == key) {
				break;
			} else {
				cmp = kk.compareTo(tt.key);
				if(cmp < 0) {
					tt = tt.left;
				} else {
					tt = tt.right;
				}
				level++;
			}
			
		}
		
		return level;
	}
	
	public int levelrec(MapEntry<K, V> node, K key,int level){
		if(node == null) return -1;
		Comparable<? super K> kk = (Comparable<? super K>) key;
		if(kk.compareTo(node.key) < 0) {
			level = levelrec(node.left,key,level+1);
		} else if(kk.compareTo(node.key) > 0){
			level = levelrec(node.right,key,level+1);
		} else {
			return level;
		}
		return level;
		
	}
	
	
	public void ancestor(MapEntry<K, V> node, K key){
		
		Comparable<? super K> kk = (Comparable<? super K>) key;
		if(kk.compareTo(node.key) < 0) {
			ancestor(node.left, key);
			//System.out.println(node.key);
		} else if(kk.compareTo(node.key) > 0) {
			ancestor(node.right, key);
			//System.out.println(node.key);
		} else {
			return;
		}
		
		System.out.println(node.key);
		
	}
	
	public void treezigzag(){
		
		Queue<MapEntry<K, V>> qq = new LinkedList<>();
		qq.add(root);
		boolean flag = true;
		while(!qq.isEmpty()){
			MapEntry<K, V> t = qq.poll();
			System.out.println(t.key);
			if(flag){
				flag = false;
			if(t.left != null) qq.add(t); 
			if(t.right != null) qq.add(t);
			} else {
				flag = true;
			if(t.right != null) qq.add(t);
			if(t.left != null) qq.add(t);
			}
		}
		
		
		
	}
	
	
}
