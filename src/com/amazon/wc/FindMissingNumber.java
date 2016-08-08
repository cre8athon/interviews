package com.amazon.wc;

/**
 * Created by gnowakow on 7/26/16.
 */
public class FindMissingNumber {

    public static int findMissingNumber(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high)/2;

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

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,5,6,7,8,9};
        System.out.println(findMissingNumber(arr));
    }
}
