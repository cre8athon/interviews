package com.amazon.wc;

import java.util.Stack;

/**
 * Created by gnowakow on 8/5/16.
 */
public class MaximizeProfit {

    // Given a list of prices, find the optimal way to buy/sell in order to maximize profits.

    static class BS {
        public final int maxBuyIdx;
        public final int maxSellIdx;
        public final int profit;

        public BS(final int maxBuyIdx, final int maxSellIdx, final int profit) {
            this.maxBuyIdx = maxBuyIdx;
            this.maxSellIdx = maxSellIdx;
            this.profit = profit;
        }
    }


    public static int maximizeProfit(int[] values) {

        Stack<BS> bsStack = new Stack<>();
        int maxProfit = -1;

        for( int i = 0; i < values.length; i++ ) {
            maxProfit = -1;
            for( int j = i; j < values.length; j++ ) {
                int profit = values[j] - values [i];
                if( profit > maxProfit ) {
                    maxProfit = profit;
                    BS newMax = new BS(i, j, profit);
                    if( bsStack.isEmpty() ) {
                        bsStack.push(newMax);
                    } else {
                        if (isOverlap(bsStack.peek(), newMax)) {
                            if (profit > bsStack.peek().profit) {
                                bsStack.pop();
                                bsStack.push(newMax);
                            }
                        } else {
                            bsStack.push(newMax);
                        }
                    }
                }
            }
        }

        int totalProfit = 0;
        for( BS top : bsStack ) {
            totalProfit += top.profit;
        }
        return totalProfit;
    }

    public static boolean isOverlap(BS one, BS two) {
        return !(one.maxSellIdx < two.maxBuyIdx && two.maxBuyIdx > one.maxSellIdx );
    }

    public static void main(String[] args) {
//        int[] prices = new int[] {100, 25, 101, 200};
        int[] prices = new int[] { 100, 180, 260, 310, 40, 535, 695}; // Should be 865!

        System.out.println("Max profit is: " + maximizeProfit(prices));


    }
}
