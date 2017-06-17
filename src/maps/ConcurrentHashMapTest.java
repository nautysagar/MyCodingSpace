package maps;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String userId = "test";
		String s1 = "HCUC_BasicMessaging";
		String s2 = "HCUC_BasicMessaging";

		String licStr = s1 + "|1";

		ConcurrentHashMap<String, String> userVMHashMap = new ConcurrentHashMap<String, String> ();
		userVMHashMap.put(userId, licStr);
		
		String existinglic = userVMHashMap.get(userId);
		
		userVMHashMap.put(userId, existinglic +"|"+licStr);
		
		
		System.out.println(userVMHashMap.size() +":::: "+userVMHashMap.get(userId));
		
	}

}
