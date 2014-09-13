
public class BinaryPrint {
	public static void main(String[] args){
		printBin("", 3);
	}
	public static void printBin(String soFar, int iterations) {
	    if(iterations == 0) {
	        System.out.println(soFar);
	    }
	    else {
	        printBin(soFar + "+", iterations - 1);
	        printBin(soFar + "-", iterations - 1);
//	        printBin(soFar + "x", iterations - 1);
	    }
	}
}
