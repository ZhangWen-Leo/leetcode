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
     * 213. House Robber II
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     *
     * @param nums  一个数组，每个元素表示一个家庭里的钱，所有家庭形成了一个环
     * @return  不连续打劫任意两家的情况下，最多能打劫到的钱财
     */
    private int[][] robDp;
    public int rob(int[] nums) {
        int len = nums.length;
        robDp = new int[len][2];
        for (int i = 0; i < len; i++) {
            Arrays.fill(robDp[i], -1);
        }

        int res = Math.max(nums[0] + getRob(nums, 2, 0), getRob(nums, 1, 1));
        return res;
    }
    private int getRob(int[] nums, int start, int end) {
        int len = nums.length;
        if ((end == 0 && start >= len - 1) || (end == 1 && start >= len)) {
            return 0;
        }
        else if ((end == 0 && start == len - 2) || (end == 1 && start == len - 1)) {
            return nums[start];
        }
        else if (robDp[start][end] >= 0) {
            return robDp[start][end];
        }

        robDp[start][end] = Math.max(
                nums[start] + getRob(nums, start + 2, end),
                getRob(nums, start + 1, end)
        );
        return robDp[start][end];
    }

    /**
     * 214. Shortest Palindrome
     *
     * 未通过
     *
     * @param s 字符串s
     * @return  返回最短的字符串s1，使得s1+s是一个回文串
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

    /**
     * 215. Kth Largest Element in an Array
     *
     * @param nums  数组
     * @param k     数字
     * @return  返回数nums中第k大的数字
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num :
                nums) {
            if (queue.size() < k) {
                queue.offer(num);
            }
            else if (num > queue.peek()){
                queue.poll();
                queue.offer(num);
            }
        }

        return queue.peek();

//        Arrays.sort(nums);
//        return nums[nums.length - k];
    }

    /**
     * 216. Combination Sum III
     *
     * 2 <= k <= 9
     * 1 <= n <= 60
     *
     * @param k 数字
     * @param n 数字
     * @return  在1-9中不重复的使用k个数求得和为n，返回所有可能的序列
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n > 45) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>(k);
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 1; i <= k; i++) {
            list.add(i);
            stack.push(i);
            sum += i;
        }
        if (sum > n) {
            return res;
        }
        else if (sum == n) {
            res.add(list);
            return res;
        }
        else {
            while (true) {
                if (sum == n) {
                    res.add((List<Integer>) list.clone());
                }
                if (sum >= n || stack.peek() == 9) {
                    int pop = stack.pop();
                    list.remove(list.size() - 1);
                    sum -= pop;
                    while (!stack.isEmpty() && stack.peek() + 1 == pop) {
                        pop = stack.pop();
                        list.remove(list.size() - 1);
                        sum -= pop;
                    }
                    if (stack.isEmpty()) {
                        break;
                    }
                    else {
                        pop = stack.pop();
                        list.remove(list.size() - 1);
                        sum -= pop;
                        while (list.size() < k) {
                            ++pop;
                            stack.push(pop);
                            list.add(pop);
                            sum += pop;
                        }
                    }
                }
                else {
                    int pop = stack.pop();
                    list.remove(list.size() - 1);
                    sum -= pop;
                    pop++;
                    stack.push(pop);
                    list.add(pop);
                    sum += pop;
                }
            }
        }
        return res;
    }
}
