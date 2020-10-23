package com.wen.repository.solution0001To0099;

import com.wen.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0060To0069 {

    /**
     * 60. Permutation Sequence
     */
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int x = 1;
        for (int i = n; i >= 1; i--) {
            x *= i;
        }

        StringBuilder result = new StringBuilder();
        k--;
        for (int i = n; i > 0; i--) {
            x /= i;
            result.append(list.get(k / x));
            list.remove(k / x);
            k %= x;
        }

        return result.toString();
    }

    /**
     * 61. Rotate List
     */
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        for (ListNode p = head; p != null; p = p.next) {
            length++;
        }
        if (length == 0) {
            return head;
        }
        if (k >= length) {
            k %= length;
        }
        if (k == 0) {
            return head;
        }

        ListNode nodeA, nodeB, nodeC;
        nodeA = head;
        nodeB = nodeA.next;
        nodeC = nodeA;
        while (k-- > 0) {
            nodeC = nodeC.next;
        }

        while (nodeC.next != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            nodeC = nodeC.next;
        }
        nodeA.next = null;
        nodeC.next = head;
        return nodeB;
    }

    /**
     * 62. Unique Paths
     */
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    nums[i][j] = 1;
                }
                else {
                    nums[i][j] = nums[i-1][j] + nums[i][j-1];
                }
            }
        }
        return nums[m-1][n-1];
    }

    /**
     * 63. Unique Paths II
     */
    private int[][] checkGrid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        checkGrid = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < checkGrid.length; i++) {
            for (int j = 0; j < checkGrid[i].length; j++) {
                checkGrid[i][j] = -1;
            }
        }

        return uniquePathsWithObstacles(obstacleGrid, 0, 0);
    }
    private int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y) {
        if (checkGrid[x][y] >= 0) {
            return checkGrid[x][y];
        }

        int result = 0;
        if (obstacleGrid[x][y] == 1) {
            checkGrid[x][y] = 0;
            return 0;
        }
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            checkGrid[x][y] = 1;
            return 1;
        }
        if (x + 1 < obstacleGrid.length) {
            result += uniquePathsWithObstacles(obstacleGrid, x + 1, y);
        }
        if (y + 1 < obstacleGrid[0].length) {
            result += uniquePathsWithObstacles(obstacleGrid, x, y + 1);
        }
        checkGrid[x][y] = result;
        return result;
    }

    /**
     * 64. Minimum Path Sum
     */
    private int[][] minimumGrid;
    private int[][] countForMinimum;
    public int minPathSum(int[][] grid) {
        minimumGrid = grid;
        int m = grid.length, n = grid[0].length;
        countForMinimum = new int[m][n];

        return minPathSum(0, 0);
    }
    private int minPathSum(int x, int y) {
        if (countForMinimum[x][y] > 0) {
            return countForMinimum[x][y];
        }

        int min = Integer.MAX_VALUE;
        int m = minimumGrid.length, n = minimumGrid[0].length;

        if (x == m - 1 && y == n - 1) {
            countForMinimum[x][y] = minimumGrid[x][y];
            return countForMinimum[x][y];
        }
        if (x + 1 < m) {
            min = Integer.min(minPathSum(x + 1, y), min);
        }
        if (y + 1 < n) {
            min = Integer.min(minPathSum(x, y + 1), min);
        }
        countForMinimum[x][y] = min + minimumGrid[x][y];

        return countForMinimum[x][y];
    }

    /**
     * 65. Valid Number
     */
    public boolean isNumber(String s) {
        final int status1 = 1; // 初始状态
        final int status2 = 2; // 正负号
        final int status3 = 3; // 整数部分
        final int status4 = 4; // 小数点
        final int status5 = 5; // 小数部分
        final int status6 = 6; // e
        final int status7 = 7; // 正负号
        final int status8 = 8; // 指数部分

        int status = status1;
        int i = 0;
        boolean foundWhite = false;
        boolean hasNum = false;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (status) {
                case status1: {
                    if (c == ' ') {
                        status = status1;
                    }
                    else if (c == '+' || c == '-') {
                        status = status2;
                    }
                    else if (Character.isDigit(c)) {
                        hasNum = true;
                        status = status3;
                    }
                    else if (c == '.') {
                        status = status4;
                    }
                    else {
                        return false;
                    }
                    break;
                }
                case status2: {
                    if (Character.isDigit(c)) {
                        hasNum = true;
                        status = status3;
                    }
                    else if (c == '.') {
                        status = status4;
                    }
                    else {
                        return false;
                    }
                    break;
                }
                case status3: {
                    hasNum = true;
                    if (Character.isDigit(c)) {
                        status = status3;
                    }
                    else if (c == '.') {
                        status = status4;
                    }
                    else if (c == 'e') {
                        status = status6;
                    }
                    else if (c == ' ') {
                        foundWhite = true;
                    }
                    else {
                        return false;
                    }
                    break;
                }
                case status4: case status5: {
                    if (Character.isDigit(c)) {
                        hasNum = true;
                        status = status5;
                    }
                    else if (c == 'e') {
                        status = status6;
                    }
                    else if (c == ' ') {
                        foundWhite = true;
                    }
                    else {
                        return false;
                    }
                    break;
                }
                case status6: {
                    if (c == '+' || c == '-') {
                        status = status7;
                    }
                    else if (Character.isDigit(c)) {
                        status = status8;
                    }
                    else {
                        return false;
                    }
                    break;
                }
                case status7: {
                    if (Character.isDigit(c)) {
                        status = status8;
                    }
                    else {
                        return false;
                    }
                    break;
                }
                case status8: {
                    if (Character.isDigit(c)) {
                        status = status8;
                    }
                    else if (c == ' ') {
                        foundWhite = true;
                    }
                    else {
                        return false;
                    }
                    break;
                }
            }
            if (foundWhite) {
                break;
            }
            i++;
        }
        if (foundWhite) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i < s.length()) {
                return false;
            }
        }
        return hasNum && (status == status3 || status == status4 || status == status5 || status == status8);
    }

    /**
     * 66. Plus One
     */
    public int[] plusOne(int[] digits) {
        boolean overflow = true;
        int temp;
        for (int i = digits.length-1; overflow && i >= 0; i--) {
            temp = digits[i] + 1;
            overflow = temp >= 10;
            digits[i] = temp % 10;
        }
        if (overflow) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        else {
            return digits;
        }
    }

    /**
     * 67. Add Binary
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean add = false;
        while (i >= 0 && j >= 0) {
            char charA = a.charAt(i), charB = b.charAt(j);
            if (charA == '1' && charB == '1') {
                result.insert(0, add ? '1' : '0');
                add = true;
            }
            else if (charA == '0' && charB == '0') {
                result.insert(0, add ? '1' : '0');
                add = false;
            }
            else {
                result.insert(0, add ? '0' : '1');
            }
            i--;
            j--;
        }
        if (i >= 0) {
            result.insert(0, addBinary(a.substring(0, i + 1), add));
        }
        else if (j >= 0) {
            result.insert(0, addBinary(b.substring(0, j + 1), add));
        }
        else {
            result.insert(0, add ? "1" : "");
        }

        return result.toString();
    }
    private String addBinary(String a, boolean b) {
        if (!b) {
            return a;
        }
        else {
            StringBuilder result = new StringBuilder(a);
            int i = a.length() - 1;
            while (i >= 0 && a.charAt(i) == '1') {
                result.setCharAt(i, '0');
                i--;
            }
            if (i >= 0) {
                result.setCharAt(i, '1');
            }
            else {
                result.insert(0, '1');
            }
            return result.toString();
        }
    }

    /**
     * 68. Text Justification
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> resultList = new ArrayList<>();

        int i = 0;
        while (i < words.length) {
            StringBuilder stringBuilder = new StringBuilder(maxWidth+1);
            List<Integer> spaceIndex = new ArrayList<>();
            int leftCount = maxWidth;
            while (i < words.length && leftCount > 0) {
                if (words[i].length() <= leftCount) {
                    stringBuilder.append(words[i]);
                    spaceIndex.add(stringBuilder.length());
                    stringBuilder.append(' ');
                    leftCount -= words[i].length() + 1;
                    i++;
                }
                else {
                    break;
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            if (spaceIndex.size() > 1) {
                spaceIndex.remove(spaceIndex.size() - 1);
            }
            leftCount++;
            if (i >= words.length) {
                while (leftCount-- > 0) {
                    stringBuilder.append(' ');
                }
            }
            else if (leftCount > 0) {
                allocateSpaces(stringBuilder, spaceIndex, leftCount);
            }
            resultList.add(stringBuilder.toString());
        }

        return resultList;
    }
    private void allocateSpaces(StringBuilder stringBuilder, List<Integer> spaceIndex, int leftCount) {
        int min = leftCount / spaceIndex.size();
        int left = leftCount % spaceIndex.size();
        String spaces = "";
        int k = min;
        while (k-- > 0) {
            spaces += " ";
        }

        for (int i = spaceIndex.size() - 1; i >= 0; i--) {
            stringBuilder.insert(spaceIndex.get(i), spaces);
            if (i < left) {
                stringBuilder.insert(spaceIndex.get(i), " ");
            }
        }
    }

    /**
     * 69. Sqrt(x)
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int start = 1, end = x < 46341 ? x : 46341, i;
        while (start < end-1) {
            i = (start + end) / 2;
            int y = i * i;
            if (y > x) {
                end = i;
            }
            else if (y < x) {
                start = i;
            }
            else {
                return i;
            }
        }
        return (start + end) / 2;
    }
}
