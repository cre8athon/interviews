package com.amazon.longestsubstr;

/**
 * Created by gnowakow on 6/10/16.
 */
public class LongestSubstring {

    public String findLongest(String source) {
        String longest = "";

        for( int ctr = 0; ctr < source.length(); ctr++ ) {
            char current = source.charAt(ctr);
            for( int ctr2 = ctr+1; ctr2 < source.length(); ctr2++ ) {
                char c1 = source.charAt(ctr2);
                if( current == c1 ) {
                    StringBuilder sb = new StringBuilder();
                    int offset = 0;
                    while( ctr2+offset < source.length() && source.charAt(ctr+offset) == source.charAt(ctr2+offset) )  {
                        sb.append(source.charAt(ctr+offset));
                        offset++;
                    }

                    if( sb.length() > longest.length() ) {
                        longest = sb.toString();
                    }
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
//        String tst = "banana";
        String tst = "Ask not what your country can do for you, ask what you can do for your country.";
        LongestSubstring ls = new LongestSubstring();

        System.out.println("The longest substring is: " + ls.findLongest(tst));
    }
}
