package library.algorithms;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by anatarajan on 11/14/15.
 */
public class OfflineMinimum {

    public static List<Integer> getOfflineMinimum(String[] arr) {
        List<Integer> result = null;
        if(arr.length == 0) return result;
        if(arr.length == 1) {
            if(arr[0].equals("E")) {
                return result;
            } else {
                result = new ArrayList<Integer>(1);
                result.add(Integer.valueOf(arr[0]));
            }
        } else {
            result = new ArrayList<Integer>(arr.length);
            int j = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(arr.length);
            for(int i = 0; i < arr.length; i++) {
                if(arr[i].equals("E")) {
                    result.add(pq.poll());
                } else {
                    pq.add(Integer.valueOf(arr[i]));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        PrintStream StdOut = System.out;
        String[] arr = new String[]{"4", "8", "E", "3", "E", "9", "2", "6", "E", "E", "E", "1", "7", "E", "5"};
        StdOut.println("Offline-Minimum Arr " + getOfflineMinimum(arr));
    }
}
