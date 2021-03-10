package com.wen.repository.solution0200To0299;

import java.util.*;

public class Solution0210To0219 {

    /**
     * 210. Course Schedule II
     *
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * ai != bi
     * All the pairs [ai, bi] are distinct.
     *
     * 8ms
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] numOfInDegree = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            if (!map.containsKey(prerequisite[1])) {
                map.put(prerequisite[1], new ArrayList<>());
            }
            map.get(prerequisite[1]).add(prerequisite[0]);
            numOfInDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numOfInDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (queue.isEmpty()) {
                return new int[0];
            }
            res[i] = queue.poll();
            if (map.containsKey(res[i])) {
                for (int num: map.get(res[i])) {
                    if (--numOfInDegree[num] == 0) {
                        queue.offer(num);
                    }
                }
            }
        }

        return res;
    }

    /**
     * 211. Design Add and Search Words Data Structure
     *
     * 见design/WordDictionary
     */

    /**
     * 212. Word Search II
     *
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 12
     * board[i][j] is a lowercase English letter.
     * 1 <= words.length <= 3 * 10^4
     * 1 <= words[i].length <= 10
     * words[i] consists of lowercase English letters.
     * All the strings of words are unique.
     *
     * @param board 字符矩阵
     * @param words 字符串数组
     * @return  对于words中的每个字符串，在字符矩阵中查找改字符串，如果能找到，则添加到返回列表中
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (findWord(board, words[i])) {
                res.add(words[i]);
            }
        }

        return res;
    }
    private boolean findWord(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        int len = word.length();
        if (len > m * n) {
            return false;
        }

        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && findWord(board, used, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean findWord(char[][] board, boolean[][] used, String word, int start, int x, int y) {
        int m = board.length, n = board[0].length;
        int len = word.length();
        if (start == len - 1) {
            return true;
        }
        used[x][y] = true;

        if (x > 0 && !used[x-1][y] && board[x-1][y] == word.charAt(start + 1)
                && findWord(board, used, word, start + 1, x - 1, y)) {
            return true;
        }
        if (x < m - 1 && !used[x+1][y] && board[x+1][y] == word.charAt(start + 1)
                && findWord(board, used, word, start + 1, x + 1, y)) {
            return true;
        }
        if (y > 0 && !used[x][y-1] && board[x][y-1] == word.charAt(start + 1)
                && findWord(board, used, word, start + 1, x, y - 1)) {
            return true;
        }
        if (y < n - 1 && !used[x][y+1] && board[x][y+1] == word.charAt(start + 1)
                && findWord(board, used, word, start + 1, x, y + 1)) {
            return true;
        }
        used[x][y] = false;
        return false;
    }

    /**
     * 214. Shortest Palindrome
     */
    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int right = len - 1;
        while (right >= 0) {
            if (isPalindrome(s, 0, right)) {
                break;
            }
            right--;
        }
        return new StringBuilder(s.substring(right + 1)).reverse().toString() + s;
    }
    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        else {
            return s.charAt(left) == s.charAt(right) && isPalindrome(s, left + 1, right - 1);
        }
    }
}
