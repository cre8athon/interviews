package com.amazon.misc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * FORGET ABOUT THIS, IT DOESN'T WORK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 *
 *
 * Created by gnowakow on 7/1/16.
 *
 * http://www.geeksforgeeks.org/find-number-subarrays-even-sum/
 *
 * Input : arr[] = {1, 2, 2, 3, 4, 1}
 Output : 9

 There are possible subarrays with even
 sum. The subarrays are
 1) {1, 2, 2, 3}  Sum = 8
 2) {1, 2, 2, 3, 4}  Sum = 12
 3) {2}  Sum = 2 (At index 1)
 4) {2, 2}  Sum = 4
 5) {2, 2, 3, 4, 1}  Sum = 12
 6) {2}  Sum = 2 (At index 2)
 7) {2, 3, 4, 1} Sum = 10
 8) {3, 4, 1}  Sum = 8
 9) {4}  Sum = 4
 */
public class FindNumberSubArraysEvenSum {

    public boolean isEven(int value) {
        return (value / 2.0) - (value / 2 ) == 0;
    }

    /**
     * A brute force approach which requires O(n^2)
     * @param array
     * @return
     */
    public List<int[]> findEvenSumSubArrays(int[] array) {
        List<int[]> evenSubArrays = new ArrayList<>();

        for (int ctr1 = 0; ctr1 < array.length; ctr1++ ) {
            int sum = 0;
            for( int ctr2 = ctr1; ctr2 < array.length; ctr2++ ) {
                sum += array[ctr2];
                if( isEven(sum) ) {
                    evenSubArrays.add(new int[] {ctr1, ctr2});
                }
            }
        }
        return evenSubArrays;
    }

    public List<int[]> findEvenSumSubArraysEfficient(int[] array) {
        List<int[]> evenSubArrays = new ArrayList<>();

        int n = array.length;

        int temp[] = new int[] {0, 1};
        int sum = 0;
        int result = 0;

        for( int i=0; i < n-1; i++ ) {
            sum = ((sum+array[i]) %2 + 2) %2;
            temp[sum]++;
        }

        result = result + (temp[0]*(temp[0]-1/2));
        result = result + (temp[1]*(temp[1]-1/2));

        System.out.println("********* The result is: " + result);


        return evenSubArrays;
    }

    public String showSubArrays(List<int[]> subArrays, int[] array) {
        StringBuilder sb = new StringBuilder();

        for( int[] subArray : subArrays ) {
            int total = 0;
            boolean first = true;
            for( int ctr = subArray[0]; ctr <= subArray[1]; ctr++ ) {
                if( first ) {
                    sb.append("{");
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append(array[ctr]);
                total += array[ctr];
            }
            sb.append("} = ").append(total);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FindNumberSubArraysEvenSum find = new FindNumberSubArraysEvenSum();
        int[] array = new int[] {1, 2, 2, 3, 4, 1};
//        List<int[]> evenSubArrays = find.findEvenSumSubArrays(array);
//        System.out.println(find.showSubArrays(evenSubArrays, array));
        System.out.println(find.findEvenSumSubArraysEfficient(array));
    }
}
