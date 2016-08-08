package com.amazon.misc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/


 * Created by gnowakow on 7/5/16.
 */
public class SmallestSubsetSumGreater {

    public List<Integer> findSmallestSubarray(int[] array, int x) {

        List<Integer> smallest = new ArrayList<>();

        int sum = 0;
        int start = 0;
        int end = 0;
        int minLen = array.length;

        while( end < array.length ) {

            while ( sum <= x && end < array.length ) {
                sum += array[end++];
            }

            while( sum > x && start < end ) {
                minLen = Math.min(minLen, end-start+1);
                sum -= array[start++];
            }
        }

        System.out.println("Minimum length: " + minLen);
        return smallest;
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 4, 45, 6, 0, 19};
        int x = 51;

        SmallestSubsetSumGreater driver = new SmallestSubsetSumGreater();
        System.out.println(driver.findSmallestSubarray(array, x));
    }
}
