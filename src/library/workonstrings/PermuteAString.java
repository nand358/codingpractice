package library.workonstrings;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/6/15.
 *
 * Interesting problem, revisit.
 */
public class PermuteAString {

    public void permute(char[] a, int k, int n) {
        if(k == n) System.out.println(Arrays.toString(a));
        else {
            for(int i = k; i <= n; i++) {
                swap(a, i, k);
                permute(a, k+1, n);
                swap(a, i, k);
            }
        }
    }

    public void swap(char[] a, int index1, int index2) {
        char temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String[] args) {
        String aString = "abc";
        PermuteAString permuteAString = new PermuteAString();
        permuteAString.permute(aString.toCharArray(), 0, aString.length() - 1);
    }
}
