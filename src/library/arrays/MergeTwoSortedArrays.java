package library.arrays;

import java.lang.reflect.Array;
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
        int na = a.length;
        int nb = b.length;

        while(i < na && j < nb) {
            if(a[i] <= b[j]) {
                result[k] = a[i]; i++;
            } else {
                result[k] = b[j]; j++;
            }
            k++;
        }

        while(i < na) {
            result[k] = a[i]; i++; k++;
        }

        while(j < nb) {
            result[k] = b[j]; j++; k++;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] a = {2, 5, 5, 9, 12}, b = {6, 8, 11};
        System.out.println("UnSorted Arrays: a=" + Arrays.toString(a) + "; b=" + Arrays.toString(b));
        int[] result = crudeSort(a, b);
        System.out.println("After Merging: " + Arrays.toString(result));

    }
}
