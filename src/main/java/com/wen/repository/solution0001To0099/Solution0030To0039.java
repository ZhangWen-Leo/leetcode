package com.wen.repository.solution0001To0099;

import com.wen.util.MyArrays;

import java.util.*;

public class Solution0030To0039 {

    /**
     * 31. Next Permutation
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;

        while (i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if (i > 0) {
            int j = i;
            i--;
            while (j < nums.length && nums[j] > nums[i]) {
                j++;
            }
            j--;

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            Arrays.sort(nums, i+1, nums.length);
        }
        else {
            MyArrays.reverse(nums);
        }
        return;
    }

    /**
     * 32. Longest Valid Parentheses
     */
    public int longestValidParentheses(String s) {
        int[] current = new int[s.length()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(': {
                    current[i] = 0;
                    stack.push(i);
                    break;
                }
                case ')': {
                    if (stack.isEmpty()) {
                        current[i] = 0;
                    }
                    else {
                        current[i] = current[i-1] + 2;
                        int left = stack.pop();
                        if (left > 0) {
                            current[i] += current[left-1];
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("未知字符");
                }
            }
        }

        int max = 0;
        for (int i = 0; i < current.length; i++) {
            max = Integer.max(max, current[i]);
        }

        return max;
    }

    /**
     * 33. Search in Rotated Sorted Array
     */
    public int search(int[] nums, int target) {
        return rotatedSearch(nums, target, 0, nums.length);
    }
    private int rotatedSearch(int[] nums, int target, int start, int end) {
        int i = (start + end) / 2, result;
        if (start >= end) {
            return -1;
        }
        if (nums[i] == target) {
            return i;
        }
        else if (nums[i] > target) {
            if (nums[i] >= nums[start]) {
                if (target >= nums[start]) {
                    result = Arrays.binarySearch(nums, start, i, target);
                    return result >= 0 ? result : -1;
                }
                else if (target <= nums[end-1]) {
                    return rotatedSearch(nums, target, i+1, end);
                }
                else {
                    return -1;
                }
            }
            else {
                return rotatedSearch(nums, target, start, i);
            }
        }
        else {
            if (nums[i] >= nums[start]) {
                return rotatedSearch(nums, target, i+1, end);
            }
            else {
                if (target >= nums[start]) {
                    return rotatedSearch(nums, target, start, i);
                }
                else if (target <= nums[end-1]) {
                    result = Arrays.binarySearch(nums, i+1, end, target);
                    return result >= 0 ? result : -1;
                }
                else {
                    return -1;
                }
            }
        }
    }

    /**
     * 37. 解数独
     */
    static final int maxSize = 9;
    static final int charToInt = -48;
    /*
        三个list，分别表示行、列与区块
        rowList.get(0)[5] == true表示第1行已存在数6
     */
    List<boolean[]> rowList = new ArrayList<>(maxSize);
    List<boolean[]> colList = new ArrayList<>(maxSize);
    List<boolean[]> blockList = new ArrayList<>(maxSize);
    /**
     * 主方法
     * @param board 棋盘
     */
    public void solveSudoku(char[][] board) {
        initLists();
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                char c = board[i][j];
                if (Character.isDigit(c)) {
                    int num = c + charToInt;
                    rowList.get(i)[num-1] = true;
                    colList.get(j)[num-1] = true;
                    blockList.get(getBlock(i, j))[num-1] = true;
                }
            }
        }

        mySolveSudoku(board);
    }
    /**
     * 辅助方法，与主方法不同的是，有返回值，用于结束循环与递归调用
     * @param board 棋盘
     * @return      当成功解题时，返回true
     */
    private boolean mySolveSudoku(char[][] board) {
        // 找到第一个未填的数
        int i = 0, j = 0;
        boolean found = false;
        while (i < maxSize) {
            j = 0;
            while (j < maxSize) {
                if (!Character.isDigit(board[i][j])) {
                    found = true;
                    break;
                }
                j++;
            }
            if (found) {
                break;
            }
            i++;
        }
        if (!found) {
            return true;
        }

        for (int k = 0; k < maxSize; k++) {
            if (putNum(board, k+1, i, j)) {
                if (mySolveSudoku(board)) {
                    return true;
                }
            }
            withdraw(board, i, j);
        }

        return false;
    }
    /**
     * 在坐标（x,y）处填入数字num
     * @return  可以填则返回true，冲突则返回false并不改变数独
     */
    private boolean putNum(char[][] board, int num, int x, int y) {
        if (rowList.get(x)[num-1]) {
            return false;
        }
        else if (colList.get(y)[num-1]) {
            return false;
        }
        else if (blockList.get(getBlock(x, y))[num-1]) {
            return false;
        }
        else {
            board[x][y] = (char)(num - charToInt);
            setLists(x, y, num, true);
            return true;
        }
    }
    /**
     * 擦掉坐标（x,y）填的数字
     */
    private void withdraw(char[][] board, int x, int y) {
        if (Character.isDigit(board[x][y])) {
            int num = board[x][y] + charToInt;
            board[x][y] = '.';
            setLists(x, y, num, false);
        }
    }
    /**
     * 初始化三个list
     */
    private void initLists() {
        for (int i = 0; i < maxSize; i++) {
            boolean[] row = new boolean[maxSize];
            boolean[] col = new boolean[maxSize];
            boolean[] block = new boolean[maxSize];
            rowList.add(row);
            colList.add(col);
            blockList.add(block);
        }
    }
    /**
     * 在修改坐标（x,y）处时同步修改三个list
     */
    private void setLists(int x, int y, int num, boolean value) {
        rowList.get(x)[num-1] = value;
        colList.get(y)[num-1] = value;
        blockList.get(getBlock(x, y))[num-1] = value;
    }
    /**
     * 将坐标（x,y）映射为区块号
     */
    private int getBlock(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }

    /**
     * 39. 组合总和
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        if (candidates.length == 0) {
            return lists;
        }
        int num = 0;
        while (num < target) {
            int newTarget = target - num;
            List<List<Integer>> subLists = combinationSum(
                    Arrays.copyOfRange(candidates, 1, candidates.length),
                    newTarget
            );
            for (List<Integer> subList :
                    subLists) {
                subList.addAll(currentList);
                lists.add(subList);
            }
            num += candidates[0];
            currentList.add(candidates[0]);
        }

        if (num == target) {
            lists.add(currentList);
        }
        return lists;
    }
}
