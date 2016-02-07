package library.stacks;

import java.util.Stack;

/**
 * Created by anatarajan on 10/25/15.
 */
public class StackSorter {

    private static Stack<Integer> sortStack(Stack<Integer> input) {

        if(input.isEmpty()) return null;

        Stack<Integer> output = new Stack<Integer>();

        while(!input.isEmpty()) {
            int temp = input.pop();

            while (!output.isEmpty() && output.peek() > temp) {
                input.push(output.pop());
            }
            output.push(temp);
        }

        return output;


    }


    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();
        myStack.push(6);
        myStack.push(1);
        myStack.push(7);
        myStack.push(2);
        myStack.push(5);
        System.out.println(sortStack(myStack));

    }
}
