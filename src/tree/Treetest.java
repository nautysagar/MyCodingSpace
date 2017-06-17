package tree;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Treetest {

	static TreeMap<Character,Integer> tt = new TreeMap<Character,Integer>();
	
	@BeforeClass
	public static void add(){
		tt.put('F',6);
		tt.put('B',2);
		tt.put('A',1);
		tt.put('D',4);
		tt.put('C',3);
		tt.put('E',5);
		tt.put('G',7);
		tt.put('I',9);
		tt.put('H',8);
		tt.put('K',11);
		
		System.out.println("Add test case Passed");
	}
	
	
	
/*	@Test
	public void getTest(){
		System.out.println(tt.get('E'));
	}
	
	@Test
	public void delete(){
		System.out.println(tt.remove('K'));
	}
	
	@Test
	public void findMax(){
		System.out.println(tt.findMax(tt.root).key);
	}
	
	@Test
	public void findMin(){
		System.out.println(tt.findMin(tt.root).key);
	}
	
	@Test
	public void findMinrec(){
		System.out.println(tt.findMinRecusion(tt.root).key);
	}

	
	@Test
	public void preorder(){
		tt.preorder(tt.root);
	}
	
	@Test
	public void inorder(){
		tt.inorder(tt.root);
	}
	
	@Test
	public void postorder(){
		tt.postorder(tt.root);
	}
	
	@Test
	public void levelorder(){
		tt.levelorder();
	} 
	
	@Test
	public void connect(){
		tt.connectnode2right(tt.root);
	}
	
	@Test
	public void level(){
		System.out.println(tt.levelrec(tt.root,'Z',0));
	}*/
	
	@Test
	public void ancestor(){
		tt.ancestor(tt.root,'E');
	}
}
