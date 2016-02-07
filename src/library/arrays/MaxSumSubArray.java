package library.arrays;

import java.util.Arrays;

/**
 * Created by anatarajan on 11/3/15.
 */
public class MaxSumSubArray {

    public void findMaxSubArray(int[] a) {
        int maxAtIndex = a[0];
        int maxSoFar = a[0];
        int startIdx = 0, endIdx = 0;

        for(int i = 1; i < a.length; i++) {
            maxAtIndex = maxAtIndex + a[i];
            if(maxAtIndex < 0) {
                startIdx += 1;
                maxAtIndex = 0;
            } else {
                endIdx = i;
            }
            maxSoFar = Math.max(maxAtIndex, maxSoFar);
        }

        System.out.println("SubArray Max for " + Arrays.toString(a) + " is " + maxSoFar);
        System.out.println("SubArray with Max is " + Arrays.toString(Arrays.copyOfRange(a, startIdx, endIdx)));
    }

    public static void main(String[] args) {
        int[] a = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        MaxSumSubArray msa = new MaxSumSubArray();
        msa.findMaxSubArray(a);

        // [-2, 1, -3, 4, -1, 2, 1, -5, 4] <- Given array
        // [-2, 1, -2, 4,  3, 5, 6,  1, 5] <- MaxArray
    }


}
