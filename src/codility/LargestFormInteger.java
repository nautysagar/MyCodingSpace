package codility;

import java.util.Arrays;
import java.util.Comparator;

public class LargestFormInteger {
	private static Integer[] VALUES = { 5, 82, 199, 9, 50, 56 };

    public static void main(String[] args) {
        Arrays.sort(VALUES, new Comparator<Integer>() {

            @Override
            public int compare(Integer lhs, Integer rhs) {
                String v1 = lhs.toString();
                String v2 = rhs.toString();

                return (v1 + v2).compareTo(v2 + v1) * -1;
            }
        });

        String result = "";
        for (Integer integer : VALUES) {
            result += integer.toString();
        }

        System.out.println(result);
    }   
	
}
