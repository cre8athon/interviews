package com.amazon.wc;

import java.util.Arrays;

/**
 * Created by gnowakow on 7/26/16.
 */
public class FindMissingNumber {

    // Calculate value expected in the mid of the array (used by O(log n) solution).
    public static int calcExpected(int[] intArray, int left, int right) {
        return intArray[left] + (intArray[right] - intArray[left]) / 2 - (right - left) % 2;
    }

    // Below finds it in O(log n)
    public static int getMissingInt(int[] intArray, int left, int right) {
        if (right == left + 1) return intArray[right] - 1; // Base case
        int pivot = left + (right - left) / 2; // Offset + difference/2
        int expected = calcExpected(intArray, left, right);

        System.out.println(String.format(
                "\tcomparing (actual)%d == (expected)%d where expected = %d + (%d - %d)/2 - (%d - %d) mod 2 )",
            intArray[pivot], expected, intArray[left], intArray[right], intArray[left], right, left));

        if (intArray[pivot] == expected )
            return getMissingInt(intArray, pivot, right);
        else
            return getMissingInt(intArray, left, pivot);
    }

     // n*(lowest+highest)/2
    // Note that we multiply n which is the size of the array * (lowest+highest)/2.  However, we are told that
    // an integer is missing, therefore we need to pretend that the size of the array is size + 1
    public static int calculateTotal(int[] arr) {
        int arrayLength = arr.length+1; // Compensate for the missing integer!
        return arrayLength*(arr[0]+arr[(arr.length-1)])/2;
    }

    // Solves in linear time O(n)
    //** Important note: Assumes the following:
    // 1) The array passed is the size of the original array, with one number missing
    // 2) The missing number is not in the first or last slot.
    public static int findMissingNumber(int[] arr) {
        int sum = 0;
        for (final int item : arr) {
            sum += item;
        }

        int totalForEntireArray = calculateTotal(arr);
        return totalForEntireArray - sum;
    }

    public static void runTest(int[] arr, int expected) {
        System.out.println(">> Running for: " + Arrays.toString(arr));
        int missingNumber = getMissingInt(arr, 0, arr.length-1);
        int m2 = findMissingNumber(arr);

        if( missingNumber != m2 ) {
            System.out.println("######### No match!  MissingNumber: " + missingNumber + " m2: " + m2);
        }

        if( missingNumber == expected ) {
            System.out.println("Found the correct missing number: " + expected + " in " + Arrays.toString(arr));
        } else {
            System.out.println("** Error ** expected: " + expected + " found: " + missingNumber + " in " + Arrays.toString(arr));
        }
    }

    /**
     * Questions/Assumptions:
     *   - Missing number cannot be in first or last position (no way to tell which)
     *
     * @param args
     */
    public static void main(String[] args) {
        runTest(new int[] {10,11,12,14,15,16,17,18,19,20}, 13);
        runTest(new int[] {1,3,4,5,6,7,8,9,10}, 2);
        runTest(new int[] {1,2,3,4,5,6,7,8,10}, 9);
        runTest(new int[] {1,2,3,4,5,7,8,9,10}, 6);
    }
}
