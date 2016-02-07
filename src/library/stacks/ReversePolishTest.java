package library.stacks;

import java.util.Stack;

/**
 * Created by anatarajan on 10/22/15.
 */
public class ReversePolishTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        String operators = "+-*/";

        String[] input = new String[] {"2", "1", "+", "3", "*"};
        // (2 + 1) * 3

        for(String i : input) {
            if(!operators.contains(i)) {
                stack.push(i);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

                int index = operators.indexOf(i);
                switch(index) {
                    case 0: stack.push(String.valueOf(b + a)); break;
                    case 1: stack.push(String.valueOf(b - a)); break;
                    case 2: stack.push(String.valueOf(b * a)); break;
                    case 3: stack.push(String.valueOf(b / a)); break;
                }
            }
        }

        System.out.println("Final value = " + stack.pop());

    }

}