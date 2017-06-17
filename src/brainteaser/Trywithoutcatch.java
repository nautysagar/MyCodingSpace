package brainteaser;

import java.util.ArrayList;
import java.util.List;

public class Trywithoutcatch {
	
	private static List<Integer> instances;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
check();
	}
	
	
	
	private static void check(){
		try{
		try{
			callanother();
		} finally {
			intilaizelist();
			System.out.println("finished");
		}
		} catch (Exception e){
			System.out.println("In catch bloack");
		}
	}
	
	
	private static void callanother(){
		throw new IllegalArgumentException();
	}
	
	private static void  intilaizelist(){
		instances = new ArrayList<Integer>();
	}

}
