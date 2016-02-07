package library.sortingalgos;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/5/15.
 */
public class MyHeap {

    public static int N;
    public MyHeap() {

    }

    public int LEFT(int i) {
        return (2*i);
    }

    public int RIGHT(int i) {
        return (2*i + 1);
    }

    public void MAX_HEAPIFY(int[] A, int i) {

        //int heapSize = A.length - 1;
        int l = LEFT(i); int r = RIGHT(i);
        int max = i;
        if(l <= N && A[l] > A[i]) {
            max = l;
        }

        if(r <= N && A[r] > A[max]) {
            max = r;
        }

        if(max != i) {
            int temp = A[max];
            A[max] = A[i];
            A[i] = temp;

            MAX_HEAPIFY(A, max);
        }
    }
    //O(n)
    public void BUILD_MAX_HEAP(int[] A) {
        N = A.length - 1;
        for(int i = N/2; i >= 0; i--) {
            MAX_HEAPIFY(A, i);
        }
    }

    public void heapSort(int[] A) {
        BUILD_MAX_HEAP(A); // O(n)
        for(int i = N; i > 0; i--) {
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            N = N -1;
            MAX_HEAPIFY(A, 0);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{7, 2, 5, 9, 4, 3, 1, 10};
        System.out.println("UnSorted Order: " + Arrays.toString(a));
        MyHeap heap = new MyHeap();
        heap.heapSort(a);
        System.out.println("Using heap-sort, Sorted Order: " + Arrays.toString(a));
    }


}
