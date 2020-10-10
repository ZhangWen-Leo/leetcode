package com.wen.repository.solution0001To0099;

import java.util.ArrayList;
import java.util.List;

public class Solution0070To0079 {

    /**
     * 75. Sort Colors
     */
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length-1, i;
        if (nums.length == 0) {
            return;
        }
        while (start <= end && nums[start] == 0) {
            start++;
        }
        while (end >= start && nums[end] == 2) {
            end--;
        }
        i = start;
        while (i <= end) {
            if (nums[i] == 0) {
                nums[i] = nums[start];
                nums[start++] = 0;
                i++;
            }
            else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end--] = 2;
            }
            else {
                i++;
            }
        }
    }

    /**
     * 78. Subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
    private List<List<Integer>> subsets(int[] nums, int index) {
        List<List<Integer>> lists = new ArrayList<>();

        if (index >= nums.length) {
            lists.add(new ArrayList<>());
        }
        else {
            List<List<Integer>> subLists = subsets(nums, index + 1);

            for (List<Integer> subList :
                    subLists) {
                List<Integer> newList = new ArrayList<>();
                newList.addAll(subList);
                newList.add(nums[index]);
                lists.add(newList);
                lists.add(subList);
            }
        }

        return lists;
    }

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
