package compare;

import java.util.Comparator;

public class Compare implements Comparator<Compare>{

	String name;
	int age;
	int rollno;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRollno() {
		return rollno;
	}





	public void setRollno(int rollno) {
		this.rollno = rollno;
	}



  public String toString(){
	return name;
	  
  }

//	public int compareTo(Compare o) {
//		// TODO Auto-generated method stub
//		int nn = (int) o.age;
//		
//		return this.age -(nn);
//	}
	
	public int compare(Compare o1, Compare o2){
		String n1 = (String) o1.name;
		String n2 = (String) o2.name;
		
		return n1.compareTo(n2);
	}
	

}
