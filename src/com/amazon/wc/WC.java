package com.amazon.wc;

/**
 * Created by gnowakow on 6/10/16.
 * Wordcount
 */
public class WC {

    public int count(String txt) {
        String[] words = txt.split(" ");
        int count = 0;
        for( String word : words ) {
            if( word.trim().length() > 0 ) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        WC wc = new WC();
        String tst = "asdfasdfasdfasdfasdf fds adf sa df  ffffsw aas dfs saa";
        System.out.println(wc.count(tst));
    }
}
