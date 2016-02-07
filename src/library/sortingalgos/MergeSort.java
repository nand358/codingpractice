package library.sortingalgos;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/3/15.
 *
 *  1. Not in-place algorithm
 *  2. O(nlogn) - time complexity
 *  3. If subarrays are cleared, then space complexity is O(n)
 *
 */
public class MergeSort {

    public void sort(int[] a) {

        int n = a.length;
        if(n < 2) return;

        int mid = n/2;

        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for(int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        for(int i = mid; i < n; i++) {
            right[i - mid] = a[i];
        }

        sort(left);
        sort(right);

        merge(left, right, a);
    }

    public void merge(int[] L, int[] R, int[] a) {
        int nL = L.length;
        int nR = R.length;

        int i = 0, j = 0, k = 0;

        while(i < nL && j < nR) {
            if(L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < nL) {
            a[k] = L[i]; i++; k++;
        }

        while(j < nR) {
            a[k] = R[j]; k++; j++;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 5, 9, 4, 3, 1, 10};
        System.out.println("UnSorted Order: " + Arrays.toString(a));
        MergeSort sorter = new MergeSort();
        sorter.sort(a);
        System.out.println("Using MergeSort, Sorted Order: " + Arrays.toString(a));
    }
}
