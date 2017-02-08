package com.amazon.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gnowakow on 2/8/17.
 */
public class QueensProblem {
    public static Integer MAX_QUEENS = 8;
    private static Integer MAX_GRID = 8;

    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private int[][] queenGrid = new int[MAX_QUEENS][MAX_QUEENS];
    private List<Point> queens = new ArrayList<>();

    public boolean checkQueenAttack(Point proposed) {
        for( Point queen : queens ) {
            if( queen.x == proposed.x || queen.y == proposed.y ||
                    Math.abs(proposed.x - queen.x) == Math.abs(proposed.y - queen.y) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Arrange queens on the chess board
     * @param colCtr the column
     * @param rowCtr the row
     */
    private void arrangeQueens(final int colCtr, final int rowCtr) {
        if (queens.size() == MAX_QUEENS) {
            return;
        }
        Point pt = new Point(colCtr, rowCtr);
        if (!checkQueenAttack(pt)) {
            System.out.println("Added point: " + pt.toString());
            queens.add(pt);
            arrangeQueens(colCtr + 1, 0);
        } else {
            if (rowCtr == (MAX_GRID - 1) ) {
                int prevIdx = queens.size();
                int prevY = -1;
                int redoCol = colCtr;
                do {
                    prevIdx--;
                    redoCol--;
                    prevY = queens.get(prevIdx).y;
                    System.out.println("Removing point : " + queens.get(queens.size() - 1).toString());
                    queens.remove(prevIdx);
                } while( prevY >= (MAX_GRID - 1) );

                int rowToAvoid = prevY + 1;
                arrangeQueens(redoCol, rowToAvoid);
            } else if (rowCtr <= (MAX_GRID - 1) ) {
                arrangeQueens(colCtr, rowCtr + 1);
            } else {
                arrangeQueens(colCtr + 1, 0);
            }
        }
    }

    public static void main(String[] args) {
        QueensProblem qp = new QueensProblem();
        qp.arrangeQueens(0, 0);
        for( Point pt : qp.queens ) {
            System.out.println(pt.toString());
        }
    }

}

