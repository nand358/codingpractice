package library;

import java.util.Arrays;

/**
 * Created by anatarajan on 10/29/15.
 */
public class MergeTwoSortedArrays {

    // todo: fix bug
    public static int[] crudeSort(int[] a, int[] b) {
        // Size of a is large, b is relatively small
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        int compa = a[0];
        int compb = b[0];
        while(k < result.length) {
            if((i <= a.length - 1) && compa < compb) {
                result[k++] = compa; i++;
                if(i < a.length) {
                    compa = a[i];
                }
            } else {
                result[k++] = compb; j++;
                if(j < b.length) {
                    compb = b[j];
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] a = {2, 5, 5, 9, 12}, b = {6, 8, 11};
        int[] result = crudeSort(a, b);
        for(int k = 0; k < result.length; k++) {
            System.out.println(result[k]);
        }

    }
}
