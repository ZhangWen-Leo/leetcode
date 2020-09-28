package com.wen.repository.solution0001To0099;

public class Solution0070To0079 {

    /**
     * 79. 单词搜索
     */
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && myExist(board, word, used, 1, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean myExist(char[][] board, String word, boolean[][] used, int index, int x, int y) {
        used[x][y] = true;
        if (index == word.length()) {
            return true;
        }
        if (x > 0 && !used[x-1][y] && board[x-1][y] == word.charAt(index)) {
            if (myExist(board, word, used, index+1, x-1, y)) {
                return true;
            }
        }
        if (y > 0 && !used[x][y-1] && board[x][y-1] == word.charAt(index)) {
            if (myExist(board, word, used, index+1, x, y-1)) {
                return true;
            }
        }
        if (x < board.length-1 && !used[x+1][y] && board[x+1][y] == word.charAt(index)) {
            if (myExist(board, word, used, index+1, x+1, y)) {
                return true;
            }
        }
        if (y < board[0].length-1 && !used[x][y+1] && board[x][y+1] == word.charAt(index)) {
            if (myExist(board, word, used, index+1, x, y+1)) {
                return true;
            }
        }
        used[x][y] = false;
        return false;
    }
}
