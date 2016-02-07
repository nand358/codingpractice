package library.sortingalgos;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/2/15.
 */
public class BubbleSort {

    /**
     * Bubble sort deals with bubbling the largest element (assuming we are
     * doing an ascending order) in every iteration.
     *
     * @param a
     */
    public void sort(int[] a, int n) {

        for(int j = 1; j < n - 1; j++) {
            for (int i = 0; i < n - 2; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 5, 9, 4, 3, 1, 10};
        System.out.println("UnSorted Order: " + Arrays.toString(a));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(a, a.length);
        System.out.println("Using BubbleSort, Sorted Order: " + Arrays.toString(a));

    }

}
