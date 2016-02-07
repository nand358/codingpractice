package library.sortingalgos;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/3/15.
 */
public class InsertionSort {

    public void sort(int[] a, int n) {

        for(int i = 1; i < n - 1; i++) {
            int hole = i;
            int value = a[i];
            while(hole > 0 && a[hole - 1] > value) {
                a[hole] = a[hole - 1];
                hole--;
            }

            a[hole] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 5, 9, 4, 3, 1, 10};
        System.out.println("UnSorted Order: " + Arrays.toString(a));
        InsertionSort sorter = new InsertionSort();
        sorter.sort(a, a.length);
        System.out.println("Using InsertionSort, Sorted Order: " + Arrays.toString(a));
    }
}
