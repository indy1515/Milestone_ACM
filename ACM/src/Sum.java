import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Sum {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("src/suminput.txt"));
		int M = Integer.parseInt(sc.nextLine().trim());
		int num[][] = new int[M][];
		for (int i = 0; i < M; i++) {
			String[] s = sc.nextLine().split(" ");
			num[i] = new int[s.length];
			for (int j = 0; j < s.length; j++) {
				num[i][j] = Integer.parseInt(s[j].trim());
			}
		}
		
		int sum[] = new int[(int)Math.pow(2, M)];
		sum(num);
	}
	
	public static void sum(int[][] arr) {
		sum(arr, "", 0, arr.length-1);
	}
	
	public static void sum(int[][] arr, String soFar, int i, int iterations) {
		if (iterations == -1) {
			System.out.println(soFar);
		} else {
			if(i<arr[arr.length-1-iterations].length) 
				sum(arr, soFar+arr[arr.length-1-iterations][i]+" ", i, iterations-1);
			if(i+1<arr[arr.length-1-iterations].length)
				sum(arr, soFar+arr[arr.length-1-iterations][i+1]+" ", i+1, iterations-1);
		}
	}
	
}
