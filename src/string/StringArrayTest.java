package string;

public class StringArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hierarchyStr = "sys.ATT-P1-HCS-FLAT.ATT-OPS-FLAT.Luther King Capital.1.edewdwe";
		String[] hierarchyArr = hierarchyStr.split("\\.");
		 System.out.println(hierarchyArr.length +"\n");
        if(hierarchyArr.length > 0) {
        	 String providerName = hierarchyArr[1];
        	 String resellerName = hierarchyArr[2];
        	 String customerName = hierarchyArr[3];
        	 System.out.println(hierarchyArr[4] +"\n");
        	 if(hierarchyArr.length > 4) {
        		 int count = 4;
        		 while(count < hierarchyArr.length){
        			 customerName = customerName.concat(".").concat(hierarchyArr[count++]);
        		 }
        	 }
        	 System.out.println(providerName + ":::"+resellerName+":::"+customerName);
        }

        
	}

}
