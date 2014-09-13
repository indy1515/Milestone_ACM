import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BinarySearchTest {
	public static void main(String[] args){
		Integer[] num = {1,4,5,5,6,8};
		int index = Arrays.binarySearch(num, 5);
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(num));

		System.out.println(Collections.frequency(arr, 6));
		System.out.println(index);
		System.out.println(Arrays.toString(num));
	}
}
