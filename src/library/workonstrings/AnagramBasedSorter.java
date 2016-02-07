package library.workonstrings;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by anatarajan on 10/29/15.
 */
public class AnagramBasedSorter implements Comparator<String> {

    public int compare(String s1, String s2) {
       //return sortChars(s1.toCharArray())
        return -1;
    }



    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("def");
        list.add("bc");
        list.add("xyz");
        list.add("bac");
        list.add("cab");
        list.add("yxz");
    }

}
