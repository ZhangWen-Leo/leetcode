package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.*;

public class Solution0120To0129 {

    /**
     * 120. Triangle
     *
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> list = new ArrayList<>(triangle.get(triangle.size()-1));

        int i = triangle.size() - 2;
        while (i >= 0) {
            for (int j = 0; j < list.size() - 1; j++) {
                list.set(j, Math.min(list.get(j), list.get(j+1)) + triangle.get(i).get(j));
            }
            list.remove(list.size()-1);
            i--;
        }

        return list.get(0);
    }

    /**
     * 121. Best Time to Buy and Sell Stock
     */
    public int maxProfit121(int[] prices) {
        int lowest, max;
        lowest = Integer.MAX_VALUE;
        max = 0;
        for (int price :
                prices) {
            if (price < lowest) {
                lowest = price;
            }
            if (price - lowest > max) {
                max = price - lowest;
            }
        }

        return max;
    }

    /**
     * 122. Best Time to Buy and Sell Stock II
     *
     * 1 <= prices.length <= 3 * 10 ^ 4
     * 0 <= prices[i] <= 10 ^ 4
     */
    public int maxProfit122(int[] prices) {
        int result = 0;
        boolean hold = false;

        for (int i = 0; i < prices.length-1; i++) {
            if (!hold && prices[i+1] > prices[i]) {
                result -= prices[i];
                hold = true;
            }
            else if (hold && prices[i+1] < prices[i]) {
                result += prices[i];
                hold = false;
            }
        }
        if (hold) {
            result += prices[prices.length-1];
        }

        return result;
    }

    /**
     * 123. Best Time to Buy and Sell Stock III
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] profitDp = new int[length+1];
        profitDp[length]= 0;
        profitDp[length-1] = 0;
        int highest = prices[length-1];
        for (int i = length - 2; i >= 0; i--) {
            if (prices[i] > highest) {
                profitDp[i] = profitDp[i+1];
                highest = prices[i];
            }
            else if (highest - prices[i] > profitDp[i+1]) {
                profitDp[i] = highest - prices[i];
            }
            else {
                profitDp[i] = profitDp[i+1];
            }
        }

        int lowest = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            int profit = prices[i] - lowest + profitDp[i+1];
            if (profit > max) {
                max = profit;
            }
        }

        return max;
    }

    /**
     * 124. Binary Tree Maximum Path Sum
     *
     * The number of nodes in the tree is in the range [0, 3 * 104].
     * -1000 <= Node.val <= 1000
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return myMaxPathSum(root)[1];
    }
    private int[] myMaxPathSum(TreeNode root) {
        int[] leftMax = root.left == null ? null : myMaxPathSum(root.left);
        int[] rightMax = root.right == null ? null : myMaxPathSum(root.right);

        int[] result = new int[]{root.val, root.val};

        if (leftMax != null && rightMax != null) {
            result[0] += Integer.max(0, Integer.max(leftMax[0], rightMax[0]));
            result[1] += Integer.max(0, leftMax[0]) + Integer.max(0, rightMax[0]);
        }
        else if (leftMax != null) {
            result[0] += Integer.max(0, leftMax[0]);
            result[1] += Integer.max(0, leftMax[0]);
        }
        else if (rightMax != null && rightMax[0] > 0) {
            result[0] += Integer.max(0, rightMax[0]);
            result[1] += Integer.max(0, rightMax[0]);
        }

        if (leftMax != null || rightMax != null) {
            if (leftMax != null) {
                result[1] = Integer.max(result[1], leftMax[1]);
            }
            if (rightMax != null) {
                result[1] = Integer.max(result[1], rightMax[1]);
            }
        }
        return result;
    }

    /**
     * 125. Valid Palindrome
     */
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int i = 0, j = s.length()-1;
        while (true) {
            while (i < j && !Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++;
            }
            if (i >= j) {
                return true;
            }

            while (i < j && !Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--;
            }
            if (i >= j) {
                return true;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
    }

    /**
     * 127. Word Ladder
     *
     * 2368ms   5.03%
     * 可优化 TODO
     */
    private int[] ladderDp;
    private int[][] transDp;
    private List<String> ladderWords;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ladderDp = new int[wordList.size()+1];
        transDp = new int[wordList.size()+1][wordList.size()+1];
        ladderWords = wordList;
        wordList.add(0, beginWord);

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < ladderWords.size(); i++) {
            if (ladderWords.get(i).equals(endWord)) {
                ladderDp[i] = 1;
                queue.offer(new int[]{i, 1});
                break;
            }
        }
        if (queue.isEmpty()) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < wordList.size(); i++) {
                if (ladderDp[i] == 0 && transString(i, current[0])) {
                    ladderDp[i] = current[1] + 1;
                    queue.offer(new int[]{i, ladderDp[i]});
                }
            }
        }

        return ladderDp[0];
    }
    private boolean transString(int a, int b) {
        if (transDp[a][b] != 0) {
            return transDp[a][b] == 1;
        }
        String stringA = ladderWords.get(a), stringB = ladderWords.get(b);
        if (stringA.length() != stringB.length()) {
            transDp[a][b] = -1;
            transDp[b][a] = -1;
            return false;
        }

        int count = 0;
        for (int i = 0; i < stringA.length(); i++) {
            if (stringA.charAt(i) != stringB.charAt(i)) {
                count++;
            }
        }

        if (count == 1) {
            transDp[a][b] = 1;
            transDp[b][a] = -1;
            return true;
        }
        else {
            transDp[a][b] = -1;
            transDp[b][a] = -1;
            return false;
        }
    }

    /**
     * 128. Longest Consecutive Sequence
     *
     * 0 <= nums.length <= 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num :
                nums) {
            set.add(num);
        }

        int max = 0;
        for (int num :
                nums) {
            if (set.contains(num)) {
                max = Integer.max(max, deleteInSet(set, num));
            }
        }

        return max;
    }
    private int deleteInSet(Set<Integer> set, int num) {
        if (set.contains(num)) {
            set.remove(num);
            return 1 +
                    (num == Integer.MIN_VALUE ? 0 : deleteInSet(set, num - 1)) +
                    (num == Integer.MAX_VALUE ? 0 : deleteInSet(set, num + 1));
        }
        else {
            return 0;
        }
    }

    /**
     * 129. Sum Root to Leaf Numbers
     */
    private int sumOfNumbers = 0;
    public int sumNumbers(TreeNode root) {
        sumOfNumbers = 0;

        if (root != null) {
            sumNumbers(root, 0);
        }

        return sumOfNumbers;
    }
    private void sumNumbers(TreeNode root, int parent) {
        int current = parent * 10 + root.val;
        if (root.left == null && root.right == null) {
            sumOfNumbers += current;
        }
        else {
            if (root.left != null) {
                sumNumbers(root.left, current);
            }
            if (root.right != null) {
                sumNumbers(root.right, current);
            }
        }
        return;
    }
}
