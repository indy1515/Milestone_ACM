import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class SortTest {
	public static void main(String[] args){
		
		//Sort Array
		Integer[] num = {1,2,4,2,3,10};
		Arrays.sort(num);
		System.out.println(new ArrayList<Integer>(Arrays.asList(num)));
		
		
		//Sort ArrayList
		ArrayList<Integer> unsortList = new ArrayList<Integer>();
		
		//sort the list
		Collections.sort(unsortList);
	}
}
