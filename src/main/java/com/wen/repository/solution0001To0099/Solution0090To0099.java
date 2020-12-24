package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;
import com.wen.dataStructure.TreeNode;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0090To0099 {

    /**
     * 90. Subsets II
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        result.add(getListFromIndex(nums, indexes));

        indexes.add(0);
        result.add(getListFromIndex(nums, indexes));
        while (true) {
            int i = indexes.get(indexes.size()-1);
            if (i < nums.length-1) {
                indexes.add(i+1);
                result.add(getListFromIndex(nums, indexes));
            }
            else {
                indexes.remove(indexes.size()-1);
                if (indexes.isEmpty()) {
                    break;
                }
                i = indexes.get(indexes.size()-1);
                int j = i+1;
                while (j < nums.length && nums[j] == nums[i]) {
                    j++;
                }
                if (j < nums.length) {
                    indexes.remove(indexes.size()-1);
                    indexes.add(j);
                    result.add(getListFromIndex(nums, indexes));
                }
                else {
                    indexes.remove(indexes.size()-1);
                    indexes.add(nums.length-1);
                }
            }
        }

        return result;
    }
    private List<Integer> getListFromIndex(int[] nums, List<Integer> indexes) {
        List<Integer> list = new ArrayList<>();

        for (int index :
                indexes) {
            list.add(nums[index]);
        }

        return list;
    }

    /**
     * 91. Decode Ways
     *
     * 1 <= s.length <= 100
     * s contains only digits and may contain leading zero(s).
     *
     * 解法2
     *
     * 1ms  100%
     */
    public int numDecodings(String s) {
        char endChar = s.charAt(s.length()-1);
        int end = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        if (s.length() <= 1) {
            return end;
        }
        char beforeEndChar = s.charAt(s.length()-2);
        int[] results = new int[s.length()];

        results[s.length()-1] = end;
        if (beforeEndChar == '0') {
            results[s.length()-2] = 0;
        }
        else if ((beforeEndChar == '1' && endChar != '0') ||
                (beforeEndChar == '2' && (endChar >= '1' && endChar <= '6'))) {
            results[s.length()-2] = 2;
        }
        else if (beforeEndChar == '1' || (beforeEndChar == '2' && endChar == '0')) {
            results[s.length()-2] = 1;
        }
        else {
            results[s.length()-2] = results[s.length()-1];
        }

        for (int i = s.length() - 3; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                results[i] = 0;
            }
            else if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6')) {
                results[i] = results[i+1] + results[i+2];
            }
            else {
                results[i] = results[i+1];
            }
        }

        return results[0];
    }
    /**
     * 解法1
     *
     * 20ms 5.20%
     */
//    private int[] results;
//    public int numDecodings2(String s) {
//        if (s.charAt(0) == '0') {
//            return 0;
//        }
//        results = new int[s.length()];
//
//        return getResult(s, 0);
//    }
//    private int getResult(String s, int index) {
//        if (index >= s.length()) {
//            return 1;
//        }
//        if (results[index] > 0) {
//            return results[index];
//        }
//
//        if (index == s.length() - 1 && s.charAt(index) != '0') {
//            results[index] = 1;
//        }
//        else if (s.charAt(index) == '0') {
//            results[index] = 0;
//        }
//        else if (s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) <= '6')) {
//            results[index] = getResult(s, index+1) + getResult(s, index+2);
//        }
//        else {
//            results[index] = getResult(s, index+1);
//        }
//
//        return results[index];
//    }

    /**
     * 92. Reverse Linked List II
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode nodeA, nodeB, nodeC, nodeD;
        nodeA = new ListNode(-1);
        nodeA.next = head;

        nodeB = nodeA;
        int i = 1;
        while (i < m) {
            nodeB = nodeB.next;
            i++;
        }

        nodeC = nodeB.next;
        while (i++ < n) {
            nodeC = nodeC.next;
        }
        nodeD = nodeC.next;
        nodeC.next = null;

        ListNode[] reverse = reverseList(nodeB.next);
        nodeB.next = reverse[0];
        reverse[1].next = nodeD;

        return nodeA.next;
    }
    private ListNode[] reverseList(ListNode head) {
        if (head == null) {
            return new ListNode[]{null, null};
        }
        else if (head.next == null) {
            return new ListNode[]{head, head};
        }
        else {
            ListNode[] subList = reverseList(head.next);
            subList[1].next = head;
            subList[1] = head;

            return subList;
        }
    }

    /**
     * 93. Restore IP Addresses
     *
     * 0 <= s.length <= 3000
     * s consists of digits only.
     *
     * 7ms  27.18%
     */
    public List<String> restoreIpAddresses(String s) {
        return split(s, 4);
    }
    private List<String> split(String s, int level) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        if (level == 1) {
            if (s.length() == 1) {
                result.add(s);
            }
            else if (s.charAt(0) != '0' && Integer.valueOf(s) <= 255) {
                result.add(s);
            }
        }
        else {
            List<String> subResult;
            if (s.length() < level || s.length() > 3*level) {
                return result;
            }
            else if (s.charAt(0) == '0') {
                subResult = split(s.substring(1), level-1);
                for (String subString :
                        subResult) {
                    result.add("0." + subString);
                }
            }
            else {
                subResult = split(s.substring(1), level-1);
                for (String subString :
                        subResult) {
                    result.add(s.substring(0, 1) + "." + subString);
                }
                if (s.length() > 2) {
                    subResult = split(s.substring(2), level-1);
                    for (String subString :
                            subResult) {
                        result.add(s.substring(0, 2) + "." + subString);
                    }
                }
                if (s.length() > 3 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                    subResult = split(s.substring(3), level-1);
                    for (String subString :
                            subResult) {
                        result.add(s.substring(0, 3) + "." + subString);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 94. Binary Tree Inorder Traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }

        return list;
    }

    /**
     * 95. Unique Binary Search Trees II
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start == end) {
            TreeNode node = new TreeNode(start);
            result.add(node);
        }
        else if (start > end) {
            result.add(null);
        }
        else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> lefts = generateTrees(start, i-1),
                        rights = generateTrees(i+1, end);
                for (TreeNode left :
                        lefts) {
                    for (TreeNode right :
                            rights) {
                        TreeNode node = new TreeNode(i, left, right);
                        result.add(node);
                    }
                }
            }
        }

        return result;
    }

    /**
     * 96. Unique Binary Search Trees
     */
    private int[] numTreesDp;
    public int numTrees(int n) {
        numTreesDp = new int[n+1];
        numTreesDp[0] = 1;
        numTreesDp[1] = 1;

        return getNumTrees(n);
    }
    private int getNumTrees(int n) {
        if (numTreesDp[n] > 0) {
            return numTreesDp[n];
        }

        for (int i = 1; i <= n; i++) {
            int left, right;
            left = getNumTrees(i - 1);
            right = getNumTrees(n - i);
            numTreesDp[n] += left * right;
        }
        return numTreesDp[n];
    }

    /**
     * 97. Interleaving String
     */
    private int[][] checkMatrix;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        checkMatrix = new int[s1.length()+1][s2.length()+1];
        return isInterleave(s1, s2, s3, s1.length(), s2.length(), s3.length());
    }
    private boolean isInterleave(String s1, String s2, String s3, int end1, int end2, int end3) {
        if (checkMatrix[end1][end2] > 0) {
            return checkMatrix[end1][end2] == 1;
        }
        if (end3 == 0) {
            if (end1 == 0 && end2 == 0) {
                checkMatrix[end1][end2] = 1;
            }
            else {
                checkMatrix[end1][end2] = 2;
            }
        }
        else if (end1 == 0 || end2 == 0) {
            if (s3.substring(0, end3).equals(end1 == 0 ? s2.substring(0, end2) : s1.substring(0, end1))) {
                checkMatrix[end1][end2] = 1;
            }
            else {
                checkMatrix[end1][end2] = 2;
            }
        }
        else {
            char c1 = s1.charAt(end1 - 1);
            char c2 = s2.charAt(end2 - 1);
            char c = s3.charAt(end3 - 1);

            if (c == c1 && c == c2) {
                if (isInterleave(s1, s2, s3, end1 - 1, end2, end3 - 1)
                        || isInterleave(s1, s2, s3, end1, end2 - 1, end3 - 1)) {
                    checkMatrix[end1][end2] = 1;
                }
                else {
                    checkMatrix[end1][end2] = 2;
                }
            }
            else if (c == c1) {
                if (isInterleave(s1, s2, s3, end1 - 1, end2, end3 - 1)) {
                    checkMatrix[end1][end2] = 1;
                }
                else {
                    checkMatrix[end1][end2] = 2;
                }
            }
            else if (c == c2) {
                if (isInterleave(s1, s2, s3, end1, end2 - 1, end3 - 1)) {
                    checkMatrix[end1][end2] = 1;
                }
                else {
                    checkMatrix[end1][end2] = 2;
                }
            }
            else {
                checkMatrix[end1][end2] = 2;
            }
        }

        return checkMatrix[end1][end2] == 1;
    }

    /**
     * 98. Validate Binary Search Tree
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, ((long) Integer.MIN_VALUE) - 1, ((long) Integer.MAX_VALUE) + 1);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        else if (root.val <= min || root.val >= max) {
            return false;
        }
        else {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
    }

    /**
     * 99. Recover Binary Search Tree
     */
    TreeNode left, right;
    Long lastVar;
    public void recoverTree(TreeNode root) {
        lastVar = ((long) Integer.MIN_VALUE) - 1;
        leftFirstInOrder(root);
        lastVar = ((long) Integer.MAX_VALUE) + 1;
        rightFirstInOrder(root);

        if (left == null || right == null) {
            System.out.println("未检测到错误");
            return;
        }

        int temp = right.val;
        right.val = left.val;
        left.val = temp;

        return;
    }
    private void leftFirstInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        leftFirstInOrder(root.left);
        if (root.val < lastVar) {
            right = root;
        }
        lastVar = (long) root.val;
        leftFirstInOrder(root.right);

        return;
    }
    private void rightFirstInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        rightFirstInOrder(root.right);
        if (root.val > lastVar) {
            left = root;
        }
        lastVar = (long) root.val;
        rightFirstInOrder(root.left);

        return;
    }
}
