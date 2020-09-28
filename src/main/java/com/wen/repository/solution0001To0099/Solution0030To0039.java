package com.wen.repository.solution0001To0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0030To0039 {
    /**
     * 37. 解数独 TODO
     */
    List<Character> defaultList = new ArrayList<>(); // 默认列表，储存1-9九个字符
    List<int[]> sudokuList = new ArrayList<>(); // 存储所有空点的坐标
    List<Character>[][] selectList = new List[9][9];    // 存储所有点的可选字符列表
    public void solveSudoku(char[][] board) {
        /*
        初始化上述三个列表
         */
        for (int i = 0; i < 9; i++) {
            defaultList.add((char) (i+49));
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    selectList[i][j] = excludeList(board, i, j);
                    sudokuList.add(new int[]{i, j});
                }
            }
        }

        if (sudokuList.size() == 0) {
            return;
        }
        mySolveSudoku(board, sudokuList.get(0)[0], sudokuList.get(0)[1]);
        return;
    }
    /**
     * 利用回溯法递归选择
     * @param board 数独表盘
     * @param x 坐标
     * @param y 坐标
     * @return  不通返回false
     */
    private boolean mySolveSudoku(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (exclude(board, x, y, (char) (i+49))) {
                continue;
            }
            else {

            }
        }
        return false;
    }
    /**
     * 判断一个点的某个字符是否被排斥
     * @param num   被检查的字符
     * @return  排斥则返回true
     */
    private boolean exclude(char[][] board, int x, int y, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num || board[x][i] == num) {
                return true;
            }
        }
        int xStart = (x / 3) * 3, yStart = (y / 3) * 3;
        for (int i = xStart; i < xStart + 3; i++) {
            for (int j = yStart; j < yStart + 3; j++) {
                if (board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 返回一个空点的可选字符list
     */
    private List<Character> excludeList(char[][] board, int x, int y) {
        List<Character> list = new ArrayList<>();
        list.addAll(defaultList);
        for (char c :
                list) {
            if (exclude(board, x, y, c)) {
                list.remove(c);
            }
        }
        return list;
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
