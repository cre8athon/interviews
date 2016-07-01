package com.amazon.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gnowakow on 6/30/16.
 *
 * http://www.geeksforgeeks.org/find-frequency-of-each-element-in-a-limited-range-array-in-less-than-on-time/
 *
 * Input: arr[] = [1, 1, 1, 2, 3, 3, 5,
 5, 8, 8, 8, 9, 9, 10]
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
        Map<Integer, Integer> repeating = new HashMap<>();

        int start = 0;
        int end = array.length-1;
        while( start < array.length - 1) {
            Integer[] foundIdx = find(array, start, end, array[start], null);
            if( foundIdx[0] != null && foundIdx[1] != null ) {
                int numberInSeries = foundIdx[1] - foundIdx[0] + 1;
                repeating.put(array[start], numberInSeries);

                start += numberInSeries;
            } else {
                start++;
            }
        }
        return repeating;
    }

    public Integer[] find(int[] array, int start, int end, int target, Integer[] seriesIdx) {

        if( end > array.length ) {
            throw new RuntimeException("Exceeded length of array");
        }

        if( seriesIdx == null ) {
            seriesIdx = new Integer[2];
        }

        if( array[start] == target ) {
            if( start == 0 ) {
                seriesIdx[0] = 0;
            } else if( start > 0 && array[start-1] != target ) {
                seriesIdx[0] = start-1;
            }
        }

        if( array[end] == target ) {
            if( end == array.length ) {
                seriesIdx[1] = end;
            } else if( end < array.length-2 && array[end+1] != target ) {
                seriesIdx[1] = end+1;
            }
        }

        int mid = (end - start) / 2;

        if( array[mid] < target ) {
            find(array, start, mid, target, seriesIdx);
        } else if( array[mid] > target ) {
            find(array, mid, end, target, seriesIdx);
        } else {
            if( array[mid - 1] != target ) {
                seriesIdx[0] = mid-1;
            }
            if( array[mid + 1] != target ) {
                seriesIdx[1] = mid+1;
            }
        }

        if( seriesIdx[0] != null && seriesIdx[1] != null ) {
            return seriesIdx; // Found series start and end
        } else if( seriesIdx[0] == null ) {
            // Need to find the "low" side
            find(array, start, mid, target, seriesIdx);
        } else if( seriesIdx[1] == null ){
            // Need to find the "high" side
            find(array, mid, end, target, seriesIdx);
        }

        throw new RuntimeException("Logic error -- value from the array is not found in the array");
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 1, 1, 2, 3, 3, 5,
                5, 8, 8, 8, 9, 9, 10};
        RepeatingInts cl = new RepeatingInts();
        Map<Integer, Integer> counts = cl.countRepeating(arr);
        System.out.println(counts.toString());
    }
}
