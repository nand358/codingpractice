package library;

/**
 * Created by anatarajan on 10/24/15.
 */
public class CStringReverser {

    public String reverse(String str) {
        char[] input = str.toCharArray();

        int i = 0, j = str.length() - 1;
        char temp;
        while ( i < j ) {
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }

        return new String(input);
    }


    public static void main(String[] args) {
        String input = "Asha Anand";
        CStringReverser reverser = new CStringReverser();
        System.out.println("Reversed String is " + reverser.reverse(input));
    }
}
