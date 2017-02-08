package com.amazon.misc;

/**
 * Created by gnowakow on 2/8/17.
 */
public class Junk {
    public void showVal(int value) {
        System.out.println("The value is: " + value);
    }
    public static void main(String[] args) {
        int val = 0;
        Junk j = new Junk();
        j.showVal(val++);
        j.showVal(++val);
    }
}
