package library;

/**
 * Created by anatarajan on 10/23/15.
 */
public class MyStackC implements MyStack {

    private static final int CAPACITY = 16;
    private Object[] elementData;
    private int currentSize;
    private int length;

    public MyStackC() {
        this(CAPACITY);
    }

    public MyStackC(int capacity) {
        length = capacity;
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return currentSize;
    }

    // 0 > 3, 1 > 3, 2 > 3, 3 > 3
    @Override
    public void push(Object object) {
        if(currentSize >= length) {
            int newLength = length * 2;
            Object[] newElementDataArr = new Object[newLength];
            System.arraycopy(elementData, 0, newElementDataArr, 0, elementData.length);
            elementData = newElementDataArr;
            length = elementData.length;
        }
        elementData[currentSize] = object;
        currentSize++;

    }

    @Override
    public Object pop() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        Object result = elementData[currentSize - 1];
        return elementData[currentSize - 1] == null;
    }

    @Override
    public Object top() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }
        Object result = elementData[currentSize - 1];
        return result;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }
}
