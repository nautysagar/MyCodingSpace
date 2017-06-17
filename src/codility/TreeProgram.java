package codility;

public class TreeProgram {
	 
	
	public static class Binarytree
	{
		private static Tree root;

	    public Binarytree(int data)
	    {
	        root = new Tree(data);
	    }

	    public void add(Tree parent, Tree child, String orientation)
	    {
	        if (orientation.equals("left"))
	        {
	           parent.setLeft(child);
	        }
	        else
	        {
	            parent.setRight(child);
	        }
	    }

	   
	}

	public static class Tree {
	    private int key;
	    private Tree left;
	    private Tree right;

	    Tree (int key) {
	        this.key = key;
	        right = null;
	        left = null;
	    }

	    public void setKey(int key) {
	        this.key = key;
	    }

	    public int getKey() {
	        return key;
	    }

	    public void setLeft(Tree left) {
	        this.left = left;
	    }

	    public Tree getLeft() {
	        return left;
	    }

	    public void setRight(Tree right ) {
	        this.right = right;
	    }

	    public Tree getRight() {
	        return right;
	    }

	}
	
	

	public static void main(String[] args) {
		
		Tree n1 = new Tree(3);
		Tree n2 = new Tree(10);
		Tree n3 = new Tree(20);
		Tree n4 = new Tree(21);
		Tree n5 = new Tree(1);
	        Binarytree tree = new Binarytree(5); //  3
	    //    tree.add(Binarytree.root, n1, "left"); //         1/ \
	    //    tree.add(Binarytree.root, n2, "right"); //            4
	    //    tree.add(n1, n3, "left"); //             2/ \
	  //      tree.add(n1, n4, "right"); //   
	   //     tree.add(n2, n5, "left"); 
		
		System.out.println(solution(tree.root));

	}
	
	private static int rootv ;
	
	public static int solution(Tree T)
    {
        // write your code in C# 6.0 with .NET 4.5 (Mono)
        int defaultVisible = 1;
        rootv = T.key;
        return defaultVisible + visibleNode(T);
    }
	
	private static int visibleNode(Tree t){
		int sum = 0;
		
		if(t.left != null){
			if(t.left.key > t.key && t.left.key > rootv){
				sum += 1 + visibleNode(t.left);
			}else {
				sum +=0+ visibleNode(t.left);
			}
			
		}
		
		if(t.right != null){
			if(t.right.key > t.key && t.right.key > rootv){
				sum += 1 + visibleNode(t.right);
			}else {
				sum +=0+ visibleNode(t.right);
			}
			
		}
		
		
		return sum;
	}

}
