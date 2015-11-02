package library;

/**
 * Created by anatarajan on 10/23/15.
 */
public interface MyStack {

    public int size();

    public void push(Object object);

    public Object pop() throws Exception;

    public Object top() throws Exception;

    public boolean isEmpty();

}
