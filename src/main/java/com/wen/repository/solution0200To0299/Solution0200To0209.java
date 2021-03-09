package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.ListNode;
import com.wen.myQuestion.listQuestion.ReverseList;

import java.util.*;

public class Solution0200To0209 {

    /**
     * 200. Number of Islands
     */
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length == 0) {
            return result;
        }
        boolean[][] checked = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!checked[i][j] && grid[i][j] == '1') {
                    result++;
                    myNumIslands(grid, checked, i, j);
                }
            }
        }

        return result;
    }
    private void myNumIslands(char[][] grid, boolean[][] checked, int i, int j) {
        checked[i][j] = true;
        if (i > 0) {
            if (!checked[i-1][j] && grid[i-1][j] == '1') {
                myNumIslands(grid, checked, i-1, j);
            }
            else {
                checked[i-1][j] = true;
            }
        }
        if (j > 0) {
            if (!checked[i][j-1] && grid[i][j-1] == '1') {
                myNumIslands(grid, checked, i, j-1);
            }
            else {
                checked[i][j-1] = true;
            }
        }
        if (i < grid.length-1) {
            if (!checked[i+1][j] && grid[i+1][j] == '1') {
                myNumIslands(grid, checked, i+1, j);
            }
            else {
                checked[i+1][j] = true;
            }
        }
        if (j < grid[0].length-1) {
            if (!checked[i][j+1] && grid[i][j+1] == '1') {
                myNumIslands(grid, checked, i, j+1);
            }
            else {
                checked[i][j+1] = true;
            }
        }
    }

    /**
     * 201. Bitwise AND of Numbers Range
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }

        return m << count;
    }

    /**
     * 202. Happy Number
     *
     * 1 <= n <= 2^31 - 1
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            if (n == 1) {
                return true;
            }
            set.add(n);

            int x = n;
            n = 0;
            while (x > 0) {
                n += Math.pow(x % 10, 2);
                x /= 10;
            }
        }

        return false;
    }

    /**
     * 203. Remove Linked List Elements
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentry = new ListNode(0, head);
        ListNode current = sentry;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }

        return sentry.next;
    }

    /**
     * 204. Count Primes
     */
    public int countPrimes(int n) {
        boolean[] isNotPrimes = new boolean[n];

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isNotPrimes[i]) {
                count++;
                for (int j = 2*i; j < n; j+=i) {
                    isNotPrimes[j] = true;
                }
            }
        }

        return count;
    }

    /**
     * 205. Isomorphic Strings
     *
     * 1 <= s.length <= 5 * 104
     * t.length == s.length
     * s and t consist of any valid ascii character.
     */
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (len != t.length()) {
            return false;
        }
        HashMap<Character, Character> hashMapSToT = new HashMap<>();
        HashMap<Character, Character> hashMapTToS = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!hashMapSToT.containsKey(s.charAt(i)) && !hashMapTToS.containsKey(t.charAt(i))) {
                hashMapSToT.put(s.charAt(i), t.charAt(i));
                hashMapTToS.put(t.charAt(i), s.charAt(i));
            }
            else if ((hashMapSToT.containsKey(s.charAt(i)) && hashMapSToT.get(s.charAt(i)) != t.charAt(i))
                    || (hashMapTToS.containsKey(t.charAt(i)) && hashMapTToS.get(t.charAt(i)) != s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 206. Reverse Linked List
     */
    public ListNode reverseList(ListNode head) {
        return ReverseList.reverseByTraverse(head);
    }

    /**
     * 207. Course Schedule
     *
     * 13ms 22.34%
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        PreRequirement preRequirement = new PreRequirement(numCourses);

        for (int[] prerequisite: prerequisites) {
            int pre = prerequisite[1], post = prerequisite[0];
            if (!preRequirement.connectPre(pre, post)) {
                return false;
            }
        }
        return true;
    }
    class PreRequirement {

        private final Set<Integer>[] sets;

        public PreRequirement(int n) {
            sets = new Set[n];
        }

        public boolean checkPre(int pre, int post) {
            if (sets[post] == null) {
                sets[post] = new HashSet<>();
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(post);

            while (!queue.isEmpty()) {
                int current = queue.poll();

                if (sets[current].contains(pre)) {
                    return true;
                }
                queue.addAll(sets[current]);
            }

            return false;
        }

        public boolean connectPre(int pre, int post) {
            if (checkPre(post, pre)) {
                return false;
            }
            else if (!checkPre(pre, post)) {
                sets[post].add(pre);
            }
            return true;
        }
    }

    /**
     * 208. Implement Trie (Prefix Tree)
     *
     * 见design/Trie
     */

    /**
     * 209. Minimum Size Subarray Sum
     */
    public int minSubArrayLen(int s, int[] nums) {
        int fast = 0, slow = 0, sum = 0, min = Integer.MAX_VALUE;

        while (fast <= nums.length) {
            if (sum < s) {
                if (fast < nums.length) {
                    sum += nums[fast++];
                }
                else {
                    break;
                }
            }
            else {
                min = Integer.min(fast - slow, min);
                sum -= nums[slow++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
