package NQueens;
import java.util.List;
import java.util.ArrayList;
//Leetcode Hard, might be hard to generate tests: https://leetcode.com/problems/n-queens/submissions/1024199429/
class Nqueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        int[][] board = new int[n][n];
        putQueens(board, 0, ret);
        return ret;
    }

    public void putQueens(int[][] board, int row, List<List<String>> ret) {
        if (row == board.length) {
            putBoard(board, ret);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row][i] = 1;
            if (validBoard(board, row, i)) {
                putQueens(board, row + 1, ret);
            }
            board[row][i] = 0;
        }
    }

    public boolean validBoard(int[][] board, int row, int col) {
        row--;
        int diagRight = col + 1;
        int diagLeft = col - 1;
        while (row >= 0) {
            boolean up = board[row][col] == 0;
            boolean dR = diagRight >= board.length || board[row][diagRight] == 0;
            boolean dL = diagLeft < 0 || board[row][diagLeft] == 0;
            if (!(up && dR && dL)) {
                return false;
            }
            row--;
            diagRight++;
            diagLeft--;
        }
        return true;
    }

    public void putBoard(int[][] board, List<List<String>> ret) {
        List<String> curr = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder currRow = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    currRow.append('.');
                } else {
                    currRow.append('Q');
                }
            }
            curr.add(currRow.toString());
        }
        ret.add(curr);
    }
}
