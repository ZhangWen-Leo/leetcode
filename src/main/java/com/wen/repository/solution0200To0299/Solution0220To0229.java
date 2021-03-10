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
    public int calculate(String s) {
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
