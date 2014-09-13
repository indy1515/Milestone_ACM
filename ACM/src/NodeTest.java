
public class NodeTest {
	public static void main(String[] args){
		permutation("12345");
	}
	public static void printBin(String soFar, int iterations) {
	    if(iterations == 0) {
	        System.out.println(soFar);
	    }
	    else {
	        printBin(soFar + "0", iterations - 1);
	        printBin(soFar + "1", iterations - 1);
	    }
	}
	
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	
	
}
