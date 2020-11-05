package com.wen.repository.solution0100To0199;

import com.wen.dataStructure.TreeNode;

import java.util.*;

public class Solution0120To0129 {

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
     * 127. Word Ladder
     *
     * TODO
     */
    private int[] ladderDp;
    private int[][] transDp;
    private List<String> ladderWords;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ladderDp = new int[wordList.size()+1];
        transDp = new int[wordList.size()+1][wordList.size()+1];
        ladderWords = wordList;
        wordList.add(0, beginWord);

        int result = getLadderOn(0, endWord);
        return result == -1 ? 0 : result;
    }
    private int getLadderOn(int index, String target) {
        if (ladderDp[index] != 0) {
            return ladderDp[index];
        }
        else if (ladderWords.get(index).equals(target)) {
            ladderDp[index] = 1;
            return 1;
        }

        int min = Integer.MAX_VALUE;
        ladderDp[index] = Integer.MAX_VALUE - 1;
        for (int i = 0; i < ladderWords.size(); i++) {
            if (transString(i, index)) {
                int ladder = getLadderOn(i, target);
                if (ladder >= 0) {
                    min = Integer.min(min, ladder + 1);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            ladderDp[index] = -1;
            return -1;
        }
        else {
            ladderDp[index] = min;
            return min;
        }
    }
    private boolean transString(int a, int b) {
        if (transDp[a][b] != 0) {
            return transDp[a][b] == 1;
        }
        String stringA = ladderWords.get(a), stringB = ladderWords.get(b);
        if (stringA.length() != stringB.length()) {
            transDp[a][b] = -1;
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
            return true;
        }
        else {
            transDp[a][b] = -1;
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
