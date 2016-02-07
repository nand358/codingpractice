package library.arrays;

/**
 * Created by anatarajan on 10/29/15.
 */
public class IdentifyElementInRotatedArray {

    public static int findIndexInSortedArray(int[] a, int n) {
        int start = 0;
        int end = a.length - 1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(n == a[mid]) return mid;
            else if(n < a[mid]) end = mid - 1;
            else if(n > a[mid]) start = mid + 1;
        }

        return -1;
    }

    public static int findIndexInRotatedArray(int[] a, int n) {
        int start = 0;
        int end = a.length - 1;

        while(start <= end) {
            int mid = (start + end)/2;
            int valueAtMid = a[mid];
            if(n == valueAtMid) return mid;
            else if(a[start] <= valueAtMid) {
                // left half is sorted
                if(a[start] <= n && valueAtMid >= n) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right half is sorted
                if(valueAtMid <= n && a[end] >= n) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25};

        System.out.println("Index of 5 : " + findIndexInSortedArray(a, 5) );
        System.out.println("Index of 99 : " + findIndexInSortedArray(a, 99) );

        int[] b = {15, 16, 19, 1, 3, 4, 5, 7, 10};
        System.out.println("Index of 1 : " + findIndexInRotatedArray(b, 1));
        System.out.println("Index of 7 : " + findIndexInRotatedArray(b, 7));
    }

}
