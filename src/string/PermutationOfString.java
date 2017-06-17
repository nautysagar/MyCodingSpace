package string;

public class PermutationOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		permutation("","ABCD");
	}
	
	
	
	static void permutation(String prefix,String str){
		int len = str.length();
		
		if(len < 1) {
			System.out.println(prefix);
		} else {
			for(int i =0;i<len;i++){
				permutation((prefix+str.charAt(i)),str.substring(0,i)+str.substring(i+1));
			}
		}
		
		
	}

}
