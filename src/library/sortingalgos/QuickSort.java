package library.sortingalgos;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/3/15.
 */
public class QuickSort {

    public void sort(int[] a, int start, int end) {
        if(start >= end) return;

        int pivotIndex = partition(a, start, end);
        sort(a, start, pivotIndex - 1);
        sort(a, pivotIndex + 1, end);
    }

    public int partition(int[] a , int start, int end) {
        int pivot = a[end];
        int pIndex = start;

        for(int i = start; i < end; i++) {
            if(a[i] <= pivot) {
                int temp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = temp;
                pIndex++;
            }
        }

        int temp = a[pIndex];
        a[pIndex] = a[end];
        a[end] = temp;
        return pIndex;
    }

    private void swap(int[] a, int i, int j) {
        // assumes i & j < a.length

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 5, 9, 4, 3, 1, 10};
        System.out.println("UnSorted Order: " + Arrays.toString(a));
        QuickSort sorter = new QuickSort();
        sorter.sort(a, 0, a.length - 1);
        System.out.println("Using MergeSort, Sorted Order: " + Arrays.toString(a));

    }
}
