package com.wen.repository.solution0001To0099;

import java.util.*;

public class Solution0070To0079 {

    /**
     * 70. Climbing Stairs
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i < n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }

    /**
     * 71. Simplify Path
     */
    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();

        int i = 0, j;
        while (i < path.length()) {
            j = i+1;
            while (j < path.length() && path.charAt(j) != '/') {
                j++;
            }
            // 找到一个区间
            canonicalList(list, path.substring(i+1, j));

            i = j;
        }

        StringBuilder result = new StringBuilder();
        for (String s :
                list) {
            result.append("/");
            result.append(s);
        }
        if (result.length() == 0) {
            result.append("/");
        }

        return result.toString();
    }
    private void canonicalList(List<String> list, String s) {
        if (s.equals("") || s.equals(".")) {
            return;
        }
        else if (s.equals("..")) {
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
            return;
        }
        else {
            list.add(s);
        }
    }

    /**
     * 72. Edit Distance
     * TODO
     */
    public int minDistance(String word1, String word2) {
        return -1;
    }

    /**
     * 73. Set Matrix Zeroes
     */
    public void setZeroes(int[][] matrix) {
        boolean row = false, column = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                column = true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row = true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
            if (column) {
                matrix[i][0] = 0;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
            if (row) {
                matrix[0][i] = 0;
            }
        }
        if (row || column) {
            matrix[0][0] = 0;
        }
    }

    /**
     * 74. Search a 2D Matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = 0;

        while (x < matrix.length && y < matrix[x].length) {
            while (x < matrix.length - 1 && target >= matrix[x+1][0]) {
                x++;
            }
            while (y < matrix[x].length) {
                if (target > matrix[x][y]) {
                    y++;
                }
                else if (target == matrix[x][y]) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        return false;
    }

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
     * 76. Minimum Window Substring
     */
    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }

        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> mapS = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        String result = "";
        int min = s.length() + 1;

        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0, end;
        // 将start指向第一个t中存在的字符
        while (start < s.length() && !mapT.containsKey(s.charAt(start))) {
            start++;
        }
        // end初始和start在一起，表示结果为""
        end = start;
        while (end < s.length()) {
            char c = s.charAt(end);
            // end处字符存在于t中，进行记录
            if (mapT.containsKey(c)) {
                mapS.put(c, mapS.getOrDefault(c, 0) + 1);
                queue.offer(end++);

                // 若此时window符合包含条件
                while (mapContains(mapS, mapT)) {
                    if (end - start < min) {
                        result = s.substring(start, end);
                        min = result.length();
                    }
                    mapS.put(s.charAt(start), mapS.get(s.charAt(start)) - 1);
                    queue.poll();
                    if (queue.isEmpty()) {
                        return result;
                    }
                    start = queue.peek();
                }
            }
            else {
                end++;
            }
        }

        return result;
    }
    private boolean mapContains(Map<?, Integer> mapA, Map<?, Integer> mapB) {
        for (Object key :
                mapB.keySet()) {
            if (!(mapA.containsKey(key) && mapA.get(key) >= mapB.get(key))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 77. Combinations
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            indexes.add(i);
        }

        int i = 0;
        while (i >= 0) {
            indexes.set(i, indexes.get(i) + 1);
            if (indexes.get(i) <= n - k + 1 + i) {
                if (i < k - 1) {
                    indexes.set(i+1, indexes.get(i));
                    i++;
                }
                else {
                    result.add(new ArrayList<>(indexes));
                }
            }
            else {
                i--;
            }
        }

        return result;
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
