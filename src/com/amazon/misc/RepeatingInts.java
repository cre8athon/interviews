package com.amazon.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnowakow on 6/30/16.
 *
 * http://www.geeksforgeeks.org/find-frequency-of-each-element-in-a-limited-range-array-in-less-than-on-time/
 *
 * Input: arr[] = [1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10]
 Output:
 Element 1 occurs 3 times
 Element 2 occurs 1 times
 Element 3 occurs 2 times
 Element 5 occurs 2 times
 Element 8 occurs 3 times
 Element 9 occurs 2 times
 Element 10 occurs 1 times
 */
public class RepeatingInts {

    public Map<Integer, Integer> countRepeating(int[] array) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        return countRepeatingUtil(array, 0, array.length-1, freqMap);
    }

    public Map<Integer, Integer> countRepeatingUtil(int[] array, int low, int high, Map<Integer, Integer> freqMap) {
        if( array[low] == array[high] ) {
            int numOccur = high - low + 1;
            freqMap.put(array[low], numOccur + (freqMap.containsKey(array[low])?freqMap.get(array[low]):0) );
        } else {
            int mid = (low + high) /2;
            countRepeatingUtil(array, low, mid, freqMap);
            countRepeatingUtil(array, mid+1, high, freqMap);
        }

        return freqMap;
    }

    /**
     * Use this method to check results
     * @param array
     * @return
     */
    public Map<Integer, Integer> countRepeatingBruteForce(int[] array) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for( int val : array ) {
            int currNum = freqMap.containsKey(val)?freqMap.get(val):0;
            freqMap.put(val, ++currNum);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10};
        RepeatingInts cl = new RepeatingInts();
        Map<Integer, Integer> counts = cl.countRepeating(arr);
        System.out.println(counts.toString());

        System.out.println(cl.countRepeatingBruteForce(arr).toString());
    }
}
