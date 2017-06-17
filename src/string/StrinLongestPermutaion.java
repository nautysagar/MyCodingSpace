package string;



public class StrinLongestPermutaion {
	
	private static String regex = "\\d+";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "53212";
		//Queue<Integer> qq = new LinkedList<>()
		int n = 4;
		
		char[] a = s.toCharArray();
	    int lpos = 0;
	    
		if(isNumber(s)){
			while(n > 0){
				int p1=0 ,p2=1;
				int len = s.length();
				while(p2 < len){
					if(a[p1] < a[p2]) {
						lpos = p1;
					} else {
						lpos = p2;
						p1=p2;
					}
					p2++;
				}
				s = s.substring(0, lpos).concat(s.substring(lpos+1));
				n--;
			}
			
			
			
		}
		
		System.out.println(s);
		

	}
	
	
	
	private static boolean isNumber(String str){
		return str.matches(regex);
	}

}
