package com.amazon.thebasics;

/**
 * Created by gnowakow on 7/6/16.
 */
public class BinarySearch {

    // Iterative approach

    public int search(int[] array, int value) {

        int index = 0;

        index = array.length / 2;

        while( true ) {
            System.out.println("Checking at index: " + index + " value: " + array[index]);
            if( array[index] == value) {
                return index;
            } else if( value < array[index]  ) {
                    index = index - index/2;
            } else {
                index = index + index/2;
            }
        }
    }

    // James P code.
    public int findInt(int num, int[] thearray){
        int greaterthan= 0;
        int lessthan = 0;

        int i= thearray.length/2;
        while (true){
            if (thearray[i] == num)
            {
                return i;
            }
            else
            if (thearray[i] < num && greaterthan ==0 )
            {
                i = i/2 + i;
                greaterthan = 1;
            }
            else
            if (thearray[i] > num && lessthan ==0)
            {
                i = i/2;
                lessthan = 1;
            }
            else
            if (thearray[i] < num && greaterthan == 1)
            {
                i= i - i/2;
            }
            else
            if (thearray[i] > num && lessthan ==1)
            {
                i=i/2;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] array = new int[] {1,3,5,6,7,9,11, 15};
        System.out.println(bs.search(array, 9));
    }
}
