import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ArrayListTesting {
	public static void main(String[] args){
		
		Integer[] num = {1,3,4,5,6,6,11,20};
		
		// Array to List to Arraylist
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(num));
		
		// Find number duplicaiton value or frequency of the value 
		int freq = Collections.frequency(arr, 6);
		System.out.println(freq);
		
		// Find location of number 
		arr.contains(new Integer(5));
		
		// ArrayList to array
		Integer[] num2 = arr.toArray(new Integer[0]);
		System.out.println(Arrays.toString(num2));
	}
}
