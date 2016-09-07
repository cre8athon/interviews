package com.amazon.wc;

/**
 * Created by gnowakow on 7/26/16.
 */
public class FindMissingNumber {

    // Below finds it in O(log n)
    public static int findMissingNumber(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;

            int expectedValue = arr[0] + (high - mid);
            // If the expected value is at the mid index, the missing number is on the high side,
            // otherwise it is on the low side...
            if( arr[mid] == expectedValue ) {
                low = mid - 1;
            } else {
                high = mid + 1;
            }

            if ((high - mid) == (arr[high] - arr[mid]))
                high = mid - 1;
            else if ((mid - low) == (arr[mid] - arr[low]))
                low = mid + 1;
            else
                return arr[high] - 1; //high, low, mid all same
        }
        return -1;
    }

    public static int findMissingNumber2(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            mid = (low + high) / 2;
            if ((high - mid) == (arr[high] - arr[mid]))
                high = mid - 1;
            else if ((mid - low) == (arr[mid] - arr[low]))
                low = mid + 1;
            else
                return arr[high] - 1; //high, low, mid all same
        }
        return -1;
    }


     // n*(lowest+highest)/2
    // Note that we multiply n which is the size of the array * (lowest+highest)/2.  However, we are told that
    // an integer is missing, therefore we need to pretend that the size of the array is size + 1
    public static int calculateTotal(int[] arr) {
        int arrayLength = arr.length+1; // Compensate for the missing integer!
        return arrayLength*(arr[0]+arr[(arr.length-1)])/2;
    }

    // Solves in linear time
    //** Important note: Assumes the following:
    // 1) The array passed is the size of the original array, with one number missing
    // 2) The missing number is not in the first or last slot.
    public static int findMissingNumber2(int[] arr) {
        int sum = 0;
        for (final int item : arr) {
            sum += item;
        }

        int totalForEntireArray = calculateTotal(arr);
        return totalForEntireArray - sum;
    }


    public static void main(String[] args) {

        int[] t0 = new int[] {10,11,12,14,15,16,17,18,19,20};
        System.out.println("Missing number is: " + findMissingNumber2(t0));
        System.out.println("Missing using bins is: " + findMissingNumber(t0));

//        int[] t1 = new int[]{1,2,3,4,5,7,8,9};
//        System.out.println("Total for the array is: " + calculateTotal(t1));
//
//        int[] t2 = new int[] {17 ,18 ,19 ,20 ,22 ,23 ,24 ,25};
//        System.out.println("T2: " + calculateTotal(t2));
//        int[] t1 = new int[]{1,2,3,4,5,6,7,8,9};
//        System.out.println("totes1: " + ((t1.length+1)*t1.length / 2));
//
//
//        int[] arr = new int[]{1, 2, 3, 5, 6, 7, 8, 9};
//        System.out.println("The total sum of complete array is: " + ((arr.length+1)*arr.length / 2) );
//        System.out.println("The missing number: " + findMissingNumber(arr));
//
//        int[] arr2 = new int[]{1, 2, 3, 5, 6, 8, 9};
//        System.out.println("The missing number: " + findMissingNumber(arr2));
//        System.out.println("The missing number: " + findMissingNumber2(arr2));

    }
}
