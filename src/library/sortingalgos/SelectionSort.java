package library.sortingalgos;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/2/15.
 */
public class SelectionSort {

    public void sort(int[] a, int n) {
        for (int i = 0; i < n - 2; i++) {
            int iMin = i; // set current index as min

            //now find min in subarray starting from the next element till end of the array.
            // Left-subarray of the array is already sorted, and hence no need to search for
            // min in that part
            for (int j = i + 1; j < n - 1; j++) {
                if (a[j] < a[iMin]) iMin = j;
            }

            //Now swap the elements
            int temp = a[iMin];
            a[iMin] = a[i];
            a[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 5, 9, 4, 3, 1, 10};
        System.out.println("UnSorted Order: " + Arrays.toString(a));
        SelectionSort sorter = new SelectionSort();
        sorter.sort(a, a.length);
        System.out.println("Using SelectionSort, Sorted Order: " + Arrays.toString(a));

    }
}
