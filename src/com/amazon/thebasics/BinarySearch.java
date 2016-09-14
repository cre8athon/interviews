package com.amazon.thebasics;

/**
 * Created by gnowakow on 7/6/16.
 */
public class BinarySearch {

    // Iterative approach
    public int search(int[] array, int value) {
        int low = 0;
        int high = array.length;

        while(low <= high ) {
            int mid = low + (high - low) / 2;
            if( array[mid] == value ) {
                return mid;
            } else if( array[mid] < value ) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Search for value within the array.
    public int search(int[] array, int value, int low, int high) {
        if( low > high ) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if( array[mid] == value ) {
            return mid;
        } else if( array[mid] < value ) {
            return search(array, value, mid + 1, high);
        } else {
            return search(array, value, low, mid - 1);
        }
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] array = new int[] {1,3,5,6,7,9,11, 15};
        System.out.println(bs.search(array, 9));

        //System.out.println(bs.search(array, 9, 0, array.length));
    }
}
