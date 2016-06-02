package leetcode.com.pickup1.hard;

/**
 * Created by tclresearchamerica on 6/1/16.
 * *******************************************
 * Location:
 * https://leetcode.com/problems/sudoku-solver/
 * *******************************************
 * Description:
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * A sudoku puzzle...
 * ...and its solution numbers marked in red.
 * *******************************************
 * *******************************************
 * *******************************************
 * *******************************************
 */
public class No037_Sudoku_Solver {

    public static void main(String[] args) {
        int i = 0;
        i += 49;
        char c = (char) i;
        System.out.println("===================================");
        System.out.println(c);
        i = 1;
        System.out.println((char) (i + '0'));

        System.out.println("===================================");
    }

    boolean[][] rowVisit, colVisit, gridVisit;
    private boolean isFound = false;

    public void solveSudoku(char[][] board) {
        rowVisit = new boolean[9][9];
        colVisit = new boolean[9][9];
        gridVisit = new boolean[9][9];

        //initialization
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if ('.' != board[i][j]) {

                    //bug2:forget to minus 1
                    int num = board[i][j] - '1';
                    rowVisit[i][num] = true;
                    colVisit[j][num] = true;
                    int index = i / 3 * 3 + j / 3;
                    gridVisit[index][num] = true;
                }
            }
        }
        backTracking(board, 0, 0);

    }

    public void backTracking(char[][] board, int row, int col) {
        if (row == 9) {
            isFound = true;
            return;
        }
        int index = row / 3 * 3 + col / 3;

        if ('.' == board[row][col]) {
            //bug3:i <=9  --> i < 9
            for (int i = 0; i < 9; i++) {
                //bug4:col的下标和rowvisit的下标一样,copy的时候,没有修改
                if (rowVisit[row][i] == false && colVisit[col][i] == false && gridVisit[index][i] == false) {
                    rowVisit[row][i] = true;
                    colVisit[col][i] = true;
                    gridVisit[index][i] = true;
                    //bug1:how change integer into char?
//                    int num = i + 49;
                    board[row][col] = (char) (i + '1');
                    if (col == 8) {
                        backTracking(board, row + 1, 0);
                    } else {
                        backTracking(board, row, col + 1);
                    }
                    if (isFound) return;
                    board[row][col] = '.';
                    rowVisit[row][i] = false;
                    colVisit[col][i] = false;
                    gridVisit[index][i] = false;
                }
            }

        } else {

            int num = board[row][col] - '1';
            rowVisit[row][num] = true;
            colVisit[col][num] = true;
            gridVisit[index][num] = true;
            if (col == 8) {
                backTracking(board, row + 1, 0);
            } else {
                backTracking(board, row, col + 1);
            }
        }

    }

}
