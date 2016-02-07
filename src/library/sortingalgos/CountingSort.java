package library.sortingalgos;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/5/15.
 */
public class CountingSort {

    public void sort(int[] a) {
        int[] mapArr = new int[1024]; // 10 bit numbers (0 to 1023) can be stored
        for(int i = 0; i < a.length; i++) {
            mapArr[a[i]]++;
        }

        int k = 0;
        for(int i = 0; i < mapArr.length; i++) {
            for(int j = 0; j < mapArr[i]; j++) {
                a[k] = i; k++;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{999, 7, 2, 5, 9, 1000, 992, 875, 1010, 200, 507, 113, 666, 999, 873, 4, 3, 1, 10};
        System.out.println("UnSorted Order: " + Arrays.toString(a));

        CountingSort countingSort = new CountingSort();
        countingSort.sort(a);
        System.out.println("Using CountingSort, Sorted Order: " + Arrays.toString(a));
    }
}
