package library.workonstrings;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/8/15.
 */
public class LIS {

    public void findLIS(int[] a) {
        int[] L = new int[a.length];
        StringBuilder sb = new StringBuilder(50);
        L[0] = 1;
        for(int i = 1; i < a.length; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i] && L[j] > max) {
                    max = L[j];
                }
            }
            L[i] = max + 1;
        }
        int finalMax = 0;
        int previous = 0;
        for(int i = 0; i < L.length; i++) {
            if(L[i] >= previous + 1) {
                sb.append(a[i]).append(' ');
                previous = L[i];
            }
            finalMax = Math.max(L[i], finalMax);
        }
        System.out.println("LIS of " + Arrays.toString(a) + " is { " + sb.toString() + "} of length " + finalMax);
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
        LIS lis = new LIS();
        lis.findLIS(a);
    }
}
