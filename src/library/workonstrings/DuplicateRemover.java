package library.workonstrings;

/**
 * Created by anatarajan on 10/24/15.
 */
public class DuplicateRemover {

    private static String removeDuplicates(char[] input) {
        for(int i = 1; i < input.length; i++) {
            for(int j = 0; j < i; j++) {
                if (input[j] == input[i]) {
                    input[i] = '\0';
                }
            }
        }

        return new String(input);
    }

    public static void main(String[] args) {
        String input = "aaaaaaaaabbbbbbbbbbbbbbccccccccccccccccaABCaBcabcAbc";
        System.out.println(removeDuplicates(input.toCharArray()));

        char[] str = new char[]{'a', 'b', 'c'};
        int newLength = str.length + 4;
        str[newLength] = '\0';

        System.out.println(str.length);
    }
}
