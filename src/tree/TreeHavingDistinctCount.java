package treeQuestions;

import java.util.HashMap;
import java.util.Map;

//Java program to print all root to leaf paths

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class Node 
{
 int data;
 Node left, right;

 Node(int item) 
 {
     data = item;
     left = right = null;
 }
}

public class TreeHavingDistinctCount {

	 Node root;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeHavingDistinctCount tree = new TreeHavingDistinctCount();
		  
	        tree.root = new Node(4);
	        tree.root.left = new Node(5);
	        tree.root.right = new Node(6);
	        tree.root.left.left = new Node(4);
	        //tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(1);
	        tree.root.right.right = new Node(6);
	        //tree.root.right.left.right = new Node(8);
	        //tree.root.right.right.right = new Node(9);
	      
	        tree.root.left.left.left = new Node(5);
	        /* Print all root-to-leaf paths of the input tree */
	        System.out.println( tree.largestUinquePath(tree.root));
	  
	}
	
//	void printPaths(Node node) {
//		int[] path = new int[1000];
//		printPathsRecur(node, path, 0);
//	}
//
//	void printPathsRecur(Node node, int path[], int pathLen) 
//    {
//        if (node == null)
//            return;
//  
//        /* append this node to the path array */
//        path[pathLen] = node.data;
//        pathLen++;
//  
//        /* it's a leaf, so print the path that led to here */
//        if (node.left == null && node.right == null)
//            printArray(path, pathLen);
//        else
//            { 
//            /* otherwise try both subtrees */
//            printPathsRecur(node.left, path, pathLen);
//            printPathsRecur(node.right, path, pathLen);
//        }
//    }
//  
//    /* Utility that prints out an array on a line */
//    void printArray(int ints[], int len) 
//    {
//        int i;
//        for (i = 0; i < len; i++) 
//            System.out.print(ints[i] + " ");
//        System.out.println("");
//    }
	
	int largestUinquePath(Node node)
	{
	    if (node == null)
	        return 0;
	 
	    // hash that store all node value
	    Map<Integer,Integer> hash = new HashMap<>();
	//    unordered_map<int, int> hash;
	 
	    // return max length unique value path
	    return largestUinquePathUtil(node, hash);
	}
	 
	int largestUinquePathUtil(Node node, Map<Integer,Integer> m)
	{
	    if (node == null)
	        return m.size();
	 
	    // put this node into hash
	    if(m.containsKey(node.data)) {
	    	m.replace(node.data, m.get(node.data)+1);
	    } else {
	    	m.put(node.data,1);
	    }
	 
	    int lLen = largestUinquePathUtil(node.left,m);
	    int rLen = largestUinquePathUtil(node.right,m);
	    
	    int max_path = Math.max(lLen, rLen);
	 
	    // remove current node from path "hash"
	    m.replace(node.data, m.get(node.data)-1);
	 
	    // if we reached a condition where all duplicate value
	    // of current node is deleted
	    if ( m.get(node.data) == 0)
	        m.remove(node.data);
	 
	    return max_path;
	}
  
}
