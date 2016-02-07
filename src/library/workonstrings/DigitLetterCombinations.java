package library.workonstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by anatarajan on 11/11/15.
 */
public class DigitLetterCombinations {

    public List<String> letterCombinations(String digits) {
        HashMap<String, String> digitLetterMap = new HashMap<String, String>();
        digitLetterMap.put("2", "ABC");
        digitLetterMap.put("3", "DEF");
        digitLetterMap.put("4", "GHI");
        digitLetterMap.put("5", "JKL");
        digitLetterMap.put("6", "MNO");
        digitLetterMap.put("7", "PQRS");
        digitLetterMap.put("8", "TUV");
        digitLetterMap.put("9", "WXYZ");
        List<String> result = new ArrayList<String>();

        char[] digitsArr = digits.toCharArray();

        //for(int j = 0; )






       return result;
    }

}