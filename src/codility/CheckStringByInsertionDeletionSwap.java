package codility;

public class CheckStringByInsertionDeletionSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.print(solution2("hell", "hello"));
	}
	
	
	public static String solution(String S, String T) {
		if(S != null && T != null){
		
        if (S.equals(T)) {
          return "SAME";
        }
        
        
        String result = checkIfInsertionMakesStringsEqual(S, T);
        if (result != null) { 
            return "INSERT " + result;
        }
        result = checkIfDeletionMakesStringsEqual(S, T);
        if (result != null) {
            return "DELETE " + result;
        }
        result = checkIfSwappingMakesStringsEqual(S, T);
        if (result != null) {
            return "SWAP " + result;
        }
        
        return "IMPOSSIBLE";
		}  else {
	    return "IMPOSSIBLE";	
		}
    }
	
	private static String checkIfInsertionMakesStringsEqual(final String s1, final String s2) {
        if (s1.length() + 1 != s2.length()) {
            return null;
        }
        final char[] s1AsCharArr = s1.toCharArray();
          final char[] s2AsCharArr = s2.toCharArray();

        for (int s2CharIndex = 0; s2CharIndex < s2AsCharArr.length; s2CharIndex++) {
            if (s2CharIndex == s2AsCharArr.length-1) { //deal with corner case, at last char in s2
                final String s1WithCharInserted = s1 + s2AsCharArr[s2CharIndex];
                if (s1WithCharInserted.equals(s2)) {
                  return String.valueOf(s2AsCharArr[s2CharIndex]);
                } else {
                  return null;
                }
            }
            if (s1AsCharArr[s2CharIndex] != s2AsCharArr[s2CharIndex]) {
                final String s1WithCharInserted = 
                    s1.substring(0, s2CharIndex) + s2AsCharArr[s2CharIndex] + s1.substring(s2CharIndex, s1AsCharArr.length);
                if (s1WithCharInserted.equals(s2)) {
                  return String.valueOf(s2AsCharArr[s2CharIndex]);
                } else {
                  return null;
                }
            } else {
              continue;
            }
        }

        return null;
    }

  private static String checkIfDeletionMakesStringsEqual(final String s1, final String s2) {
        if (s1.length() - 1 != s2.length()) {
            return null;
        }
        final char[] s1AsCharArr = s1.toCharArray();
          final char[] s2AsCharArr = s2.toCharArray();

        for (int s1CharIndex = 0; s1CharIndex < s1AsCharArr.length; s1CharIndex++) {
            if (s1CharIndex == s1AsCharArr.length-1) { //deal with corner case, at last char in s1
                final String s1WithCharDeleted = s1.substring(0, s1AsCharArr.length-1);
                if (s1WithCharDeleted.equals(s2)) {
                  return String.valueOf(s1AsCharArr[s1CharIndex]);
                } else {
                  return null;
                }
            }
            if (s1AsCharArr[s1CharIndex] != s2AsCharArr[s1CharIndex]) {
                final String s1WithCharDeleted = 
                    s1.substring(0, s1CharIndex) + s1.substring(s1CharIndex+1, s1AsCharArr.length);
                if (s1WithCharDeleted.equals(s2)) {
                  return String.valueOf(s1AsCharArr[s1CharIndex]);
                } else {
                  return null;
                }
            } else {
              continue;
            }
        }

        return null;
    }

    private static String checkIfSwappingMakesStringsEqual(final String s1, final String s2) {
        if (s1.length() != s2.length()) {
            return null;
        }
        final char[] s1AsCharArr = s1.toCharArray();
        for (int s1CharIndex = 0; s1CharIndex < s1AsCharArr.length - 1; s1CharIndex++) {
            swapArrElements(s1AsCharArr, s1CharIndex, s1CharIndex + 1);
            if (s2.equals(new String(s1AsCharArr))) {
                return s1AsCharArr[s1CharIndex + 1] + " " + s1AsCharArr[s1CharIndex];
            }
            swapArrElements(s1AsCharArr, s1CharIndex, s1CharIndex + 1); //reverse back to normal
        }
        return null;
    }

     private static void swapArrElements(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
     
     
   private static String solution2(String S, String T){
	   String result= "IMPOSSIBLE";
	   if(S == null || T == null) return result;
	   int params = S.length() - T.length();
	   if(params > 1 ||params < -1) return result;

	   String k;
	   switch(params) {
	   case -1:
		   k = checkanagram(T,S);
		   if(k != null)
		      result = "INSERT "+k;
		   break;
	   case 1:
		   k = checkanagram(S,T);
		   if(k != null)
			      result = "DELETE "+k;
		   break;
	   case 0:
		   if(S.equals(T))
			   result = "SAME";
		   k = compareAndFind(S,T);
		   if(k != null)
			   result = "SWAP "+k;
		   break;
	   default:
		        break;
	   }
	   
	   return result;
	   
   }
   
  
   
   private static String checkanagram(String S, String T){
	   int misscount = 0;
	   String k = "";
	   for(char s:S.toCharArray()){
		   if(T.indexOf(s) != -1){
			   T = T.substring(0, T.indexOf(s)) + T.substring(T.indexOf(s)+1);
		   } else {
			   misscount++;
			   k = k+s;
		   }
	   }
	   
	  if(misscount > 1) return null; 
	  return  k;
   }
   
   private static String compareAndFind(String S, String T){
	   String k = null;
	   char[] arr = S.toCharArray();
	   int i =0;
	   while(i < arr.length){
		   int index1 = S.indexOf(arr[i]);
		   int index2 = T.indexOf(arr[i]);
		   i++;
		   if(index1 == -1 || index2 == -1) return k;
		   if(index1 == index2) continue;
		   if(index1+1 == index2){
			   String n = swapString(arr,index1,index2);
			   if(n.equals(T)){
				   k =  arr[index1] + " " + arr[index1+1];
				   break;
			   } else {
				   break;
			   }
		   }
		   
	   }
	   
	   
	   return k;
   }
   
   private static String swapString(char[] arr,int index1,int index2){
	   
	   char temp = arr[index1];
	   arr[index1] = arr[index2];
	   arr[index2] = temp;
	   
	   return new String(arr);
	   
   }
     

}
