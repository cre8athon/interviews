package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnowakow on 6/10/16.
 */
public class Misc {

    public List<Integer> findRepeating(int[] elements) {
        List<Integer> repeating = new ArrayList<Integer>(elements.length);
        for( int ctr1 = 0; ctr1 < elements.length; ctr1++ ) {
            if( elements[ctr1] != -1 ) {
                for (int ctr2 = ctr1 + 1; ctr2 < elements.length; ctr2++) {
                    if (elements[ctr1] == elements[ctr2]) {
                        elements[ctr2] = -1;
                        repeating.add(elements[ctr1]);
                    }
                }
            }
        }
        return repeating;
    }

    private static int[] vals = new int[] {1000, 500, 100, 50, 10, 5, 1};
    private static String[] numerals = new String[] {"M", "D", "C", "L", "X", "V", "I"};

    /*
    1976;
    1976 -> 1000 = M
    976 -> 900 = CM
    76 -> 70 = LXX
    6 = VI
    MCMLXXVI
    */

    public String convertToRoman(StringBuilder sb, int number) {
        /*
        "M" = 1000
        "D" = 500
        "C" = 100
        "L" = 50
        "X" = 10
        "V" = 5
        "I" = 1
        */
        // Smaller number to left means subtraction
        // Only powers of 10 can only be repeated (up to 3 times)
        // Those that are not powers of 10 cannot repeat
        // Numbers are read from left to right (lowest to highest) -- unless lower is to left, then it is subtraction
        // You can subtract only powers of 10
        // Only one number can be subtracted from a larger (IIX = 8 is not allowed)
        // You can't subtract a number from one that is more than 10 times greater. That is, you can only subtract I from V or X, X from L or C, etc. For e.g., IC can not be used for 99. It must be XCIX


        // > Discussion: What is the largest number that can be represented?

        if( number == 0 ) {
            return sb.toString();
        }

        int idx = findLargestRoman(number);

        if( number > idx) {
            int factor = number / vals[idx];
            if( factor > 3 ) {
                throw new RuntimeException("Number entered is too large");
            } else {
                for( int ctr = 0; ctr < factor; ctr++) {
//                    sb.append(number[idx]);
                }
                int remain = number - (factor*vals[idx]);
            }
        }

        return "";
    }

    public int findLargestRoman(int number) {
        for(int ctr = 0; ctr < vals.length; ctr++) {
            if( vals[ctr] <= number ) {
                return ctr;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Misc m = new Misc();
        System.out.println(m.findRepeating(new int[] {2, 1, 2, 5, 3, 5}));
    }
}
