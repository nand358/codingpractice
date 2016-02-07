package library.workonstrings;

/**
 * Created by anatarajan on 11/7/15.
 */
public class LCS {

    public int lcsLength(char[] X, char[] Y, int i, int j ) {
        // Boundary conditions / Base cases
        if(i == -1 || j == -1) return 0;

        // algo
        if(X[i] == Y[j]) {
            return lcsLength(X, Y, i - 1, j - 1) + 1;
        } else {
            return Math.max(lcsLength(X, Y, i, j - 1), lcsLength(X, Y, i - 1, j));
        }
    }

    public static void main(String[] args) {

        //String s1 = "ABCBDAB";
        //String s2 = "BDCABA";

        String s1 = "ABCDEF";
        String s2 = "BACF";
        LCS lcs = new LCS();
        int lcsLen = lcs.lcsLength(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1);
        System.out.println("LCS length b/w " + s1 + ' ' + s2 + " is " + lcsLen);


    }
}
