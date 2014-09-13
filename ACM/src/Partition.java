import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Partition { 

	public static ArrayList<String> possibility = new ArrayList<String>();
    public static void partition(int n) {
        partition(n, n, "");
    }
    public static void partition(int n, int max, String prefix) {
        if (n == 0) {
            permutation(prefix);
            return;
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
        	partition(n-i, i, prefix + "" + i);
//            partition(n-i, i, prefix + " " + i);
        }
    }


    public static void main(String[] args) { 
        int N = 4;
        partition(N);
        //Delete Duplication
        possibility = new ArrayList<String>(new LinkedHashSet<String>(possibility));
        System.out.print(possibility);
    }
    
    public static void permutation(String str) { 
        permutation("", str); 
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0){
        	possibility.add(prefix);
//        	System.out.println(prefix);
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

}