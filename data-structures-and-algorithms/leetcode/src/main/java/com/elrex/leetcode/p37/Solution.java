package com.elrex.leetcode.p37;

import com.elrex.leetcode.utils.IO;

/**
 * Problem: 37. Sudoku Solver
 * @see <a href="https://leetcode.com/problems/sudoku-solver/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/2/22.
 */
public class Solution {

    /**
     *  Time complexity: O(9 ^ M), where M is the number of '.'
     *  Space complexity: O(M), where M is the number of '.'
     */
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board.length < 9 || board[0].length < 9) return;
        int M = 9;
        boolean[][] rows = new boolean[M][10];
        boolean[][] cols = new boolean[M][10];
        boolean[][] blocks = new boolean[M][10];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int n = c - '0';
                rows[i][n] = true;
                cols[j][n] = true;

                int index = (i / 3 * 3) + (j / 3);
                blocks[index][n] = true;
            }
        }
        fill(board, rows, cols, blocks, 0);
    }

    private boolean fill(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks, int index) {
        if (index >= 81) return true;
        int rowIndex = index / 9;
        int colIndex = index % 9;
        if (board[rowIndex][colIndex] != '.') return fill(board, rows, cols, blocks, index + 1);
        int blockIndex = (rowIndex / 3 * 3) + (colIndex / 3);
        for (char c = '1'; c <= '9'; c++) {
            int n = c - '0';
            if (rows[rowIndex][n] || cols[colIndex][n] || blocks[blockIndex][n]) {
                continue;
            }
            board[rowIndex][colIndex] = c;
            rows[rowIndex][n] = true;
            cols[colIndex][n] = true;
            blocks[blockIndex][n] = true;
            if (fill(board, rows, cols, blocks, index + 1)) {
                return true;
            }
            board[rowIndex][colIndex] = '.';
            rows[rowIndex][n] = false;
            cols[colIndex][n] = false;
            blocks[blockIndex][n] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] input = new char[][] {
                                            {'5','3','.','.','7','.','.','.','.'},
                                            {'6','.','.','1','9','5','.','.','.'},
                                            {'.','9','8','.','.','.','.','6','.'},
                                            {'8','.','.','.','6','.','.','.','3'},
                                            {'4','.','.','8','.','3','.','.','1'},
                                            {'7','.','.','.','2','.','.','.','6'},
                                            {'.','6','.','.','.','.','2','8','.'},
                                            {'.','.','.','4','1','9','.','.','5'},
                                            {'.','.','.','.','8','.','.','7','9'}
                                        };
        // Output:
        // [
        //  ['5','3','4','6','7','8','9','1','2'],
        //	['6','7','2','1','9','5','3','4','8'],
        //	['1','9','8','3','4','2','5','6','7'],
        //	['8','5','9','7','6','1','4','2','3'],
        //	['4','2','6','8','5','3','7','9','1'],
        //	['7','1','3','9','2','4','8','5','6'],
        //	['9','6','1','5','3','7','2','8','4'],
        //	['2','8','7','4','1','9','6','3','5'],
        //	['3','4','5','2','8','6','1','7','9']
        // ]

        solution.solveSudoku(input);
        IO.print(input);
    }
}
