package library.arrays;

/**
 * Created by anatarajan on 10/24/15.
 */
public class MyBinarySearchC {

    private int[] elementData;
    private int length;
    private static final int CAPACITY = 16;

    public MyBinarySearchC() {
        this(CAPACITY);
    }

    public MyBinarySearchC(int capacity) {
        length = capacity;
        elementData = new int[capacity];
    }

    public int find(int obj) {

        int lower = 0;
        int upper = length;
        int curIdx = 0;
        while(true) {

            curIdx = (lower + upper)/2;
            int element = elementData[curIdx];
            if(element == obj) {
                return curIdx;
            } else if(lower > upper) {
                return -1;
            } else {
                if(element < obj) {
                    lower = curIdx + 1;
                } else {
                    upper = curIdx - 1;
                }
            }

        }

    }
}
