package com.wen.repository.solution0200To0299;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution0220To0229 {

    /**
     * 221. Maximal Square
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] numMatrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            numMatrix[i][0] = matrix[i][0] - 48;
        }
        for (int i = 0; i < n; i++) {
            numMatrix[0][i] = matrix[0][i] - 48;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int min = Integer.min(numMatrix[i-1][j-1], Integer.min(numMatrix[i-1][j], numMatrix[i][j-1]));

                    numMatrix[i][j] = min == 0 ? 1 : min + 1;
                }
                else {
                    numMatrix[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Integer.max(max, numMatrix[i][j]);
            }
        }

        return max * max;
    }

    /**
     * 222. Count Complete Tree Nodes
     *
     * The number of nodes in the tree is in the range [0, 5 * 10^4].
     * 0 <= Node.val <= 5 * 10^4
     * The tree is guaranteed to be complete.
     *
     * @param root 根节点
     * @return 完全二叉树的节点个数
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rightDepth = this.countRightDepth(root);

        return this.countFullTreeNode(rightDepth) + this.countNthDepCount(root, rightDepth + 1, -1, rightDepth);
    }
    private int countNthDepCount(TreeNode root, int depth, int knownLeftDepth, int knownRightDepth) {
        int leftDepth = knownLeftDepth >= 0 ? knownLeftDepth : this.countLeftDepth(root);

        if (leftDepth < depth) {
            return 0;
        }
        int rightDepth = knownRightDepth >=0 ? knownRightDepth : this.countRightDepth(root);
        if (rightDepth == depth) {
            return (int) Math.pow(2, depth - 1);
        }

        int result = 0;
        if (root.left != null) {
            result += this.countNthDepCount(root.left, depth - 1, leftDepth - 1, -1);
        }
        if (root.right != null) {
            result += this.countNthDepCount(root.right, depth - 1, -1, rightDepth - 1);
        }
        return result;
    }
    private int countLeftDepth(TreeNode root) {
        if (root.left == null) {
            return 1;
        }
        return this.countLeftDepth(root.left) + 1;
    }
    private int countRightDepth(TreeNode root) {
        if (root.right == null) {
            return 1;
        }

        return this.countRightDepth(root.right) + 1;
    }
    private int countFullTreeNode(int depth) {
        if (depth == 0) {
            return 0;
        }
        else {
            return 1 + 2 * this.countFullTreeNode(depth - 1);
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 223. Rectangle Area
     *
     * -10^4 <= ax1 <= ax2 <= 10^4
     * -10^4 <= ay1 <= ay2 <= 10^4
     * -10^4 <= bx1 <= bx2 <= 10^4
     * -10^4 <= by1 <= by2 <= 10^4
     *
     * @param ax1
     * @param ay1
     * @param ax2
     * @param ay2
     * @param bx1
     * @param by1
     * @param bx2
     * @param by2
     * @return
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int conflictArea;
        // 无相交情况
        if (ax1 >= bx2 || ax2 <= bx1 || ay1 >= by2 || ay2 <= by1) {
            conflictArea = 0;
        } else {
            int left = Math.max(ax1, bx1);
            int right = Math.min(ax2, bx2);
            int bottom = Math.max(ay1, by1);
            int top = Math.min(ay2, by2);
            conflictArea = this.calcRectArea(left, right, bottom, top);
        }
        int area1 = this.calcRectArea(ax1, ax2, ay1, ay2);
        int area2 = this.calcRectArea(bx1, bx2, by1, by2);
        return area1 + area2 - conflictArea;
    }
    private int calcRectArea(int x1, int x2, int y1, int y2) {
        return (x2 - x1) * (y2 - y1);
    }

    /**
     * 224. Basic Calculator
     *
     * 1 <= s.length <= 3 * 10^5
     * s consists of digits, '+', '-', '(', ')', and ' '.
     * s represents a valid expression.
     *
     * 17ms
     *
     * @param s 一个有效的算术表达式字符串，包含数字、'+'、'-'、括号和空格
     * @return  返回算术表达式s的计算结果
     */
    public int calculate224(String s) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 1});
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int[] peek = stack.peek();
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int left = i;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int num = Integer.valueOf(s.substring(left, i));
                peek[0] += peek[1] == 1 ? num : -num;
                i--;
            }
            else if (c == '+') {
                peek[1] = 1;
            }
            else if (c == '-') {
                peek[1] = -1;
            }
            else if (c == '(') {
                stack.add(new int[]{0, 1});
            }
            else if (c == ')') {
                int[] pop = stack.pop();
                peek = stack.peek();

                peek[0] += peek[1] == 1 ? pop[0] : -pop[0];
            }
        }

        return stack.peek()[0];
    }
//    /**
//     * 389ms
//     */
//    public int calculate(String s) {
//        int len = s.length();
//        int res = 0;
//        boolean add = true;
//        for (int i = 0; i < len; i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) {
//                int left = i;
//                while (i < len && Character.isDigit(s.charAt(i))) {
//                    i++;
//                }
//                int num = Integer.valueOf(s.substring(left, i));
//                res += add ? num : -num;
//                i--;
//            }
//            else if (c == '+') {
//                add = true;
//            }
//            else if (c == '-') {
//                add = false;
//            }
//            else if (c == '(') {
//                i++;
//                int left = i;
//                Stack<Boolean> stack = new Stack<>();
//                stack.push(true);
//                while (i < len && !stack.isEmpty()) {
//                    c = s.charAt(i);
//                    if (c == '(') {
//                        stack.push(true);
//                    }
//                    else if (c == ')') {
//                        stack.pop();
//                    }
//                    i++;
//                }
//                int num = calculate(s.substring(left, i));
//                res += add ? num : -num;
//                i--;
//            }
//        }
//        return res;
//    }

    /**
     * 226. 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }

    /**
     * 227. Basic Calculator II
     *
     * 1 <= s.length <= 3 * 105
     * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
     * s represents a valid expression.
     * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
     * The answer is guaranteed to fit in a 32-bit integer.
     *
     * 压缩为a +(-) b *(/) c
     *
     * @param s 一个有效的算术表达式字符串，包含数字、'+'、'-'、'*'、'/'和空格
     * @return  返回算术表达式s的计算结果
     */
    public int calculate(String s) {
        int a = 0, b = 0;
        boolean add = true;
        int high = 0;   //  0:无 1:* 2:/
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int left = i;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int num = Integer.valueOf(s.substring(left, i));
                if (high == 1) {
                    b *= num;
                    high = 0;
                }
                else if (high == 2) {
                    b /= num;
                    high = 0;
                }
                else {
                    b = num;
                }
                i--;
            }
            else if (c == '+') {
                a += add ? b : -b;
                add = true;
            }
            else if (c == '-') {
                a += add ? b : -b;
                add = false;
            }
            else if (c == '*') {
                high = 1;
            }
            else if (c == '/') {
                high = 2;
            }
        }

        return add ? a + b : a - b;
    }

    /**
     * 228. Summary Ranges
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int start = 0;
        while (start < nums.length) {
            int end = start + 1;
            while (end < nums.length) {
                if (nums[end] != nums[end-1] + 1) {
                    break;
                }
                end++;
            }
            if (nums[end-1] == nums[start]) {
                result.add("" + nums[start]);
            }
            else {
                result.add(nums[start] + "->" + nums[end-1]);
            }
            start = end;
        }

        return result;
    }
}
