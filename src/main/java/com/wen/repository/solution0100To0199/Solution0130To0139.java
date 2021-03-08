package com.wen.repository.solution0100To0199;

import java.util.*;

public class Solution0130To0139 {

    /**
     * 130. Surrounded Regions
     */
    private boolean[][] checked;
    private char[][] board;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int x = board.length, y = board[0].length;
        checked = new boolean[x][y];
        this.board = board;

        for (int i = 0; i < x; i++) {
            if (board[i][0] == 'O' && !checked[i][0]) {
                check(i, 0);
            }
            if (board[i][y-1] == 'O' && !checked[i][y-1]) {
                check(i, y-1);
            }
        }
        for (int i = 0; i < y; i++) {
            if (board[0][i] == 'O' && !checked[0][i]) {
                check(0, i);
            }
            if (board[x-1][i] == 'O' && !checked[x-1][i]) {
                check(x-1, i);
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!checked[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void check(int i, int j) {
        int x = board.length, y = board[0].length;
        checked[i][j] = true;
        if (i > 0 && !checked[i-1][j] && board[i-1][j] == 'O') {
            check(i-1, j);
        }
        if (i < x-1 && !checked[i+1][j] && board[i+1][j] == 'O') {
            check(i+1, j);
        }
        if (j > 0 && !checked[i][j-1] && board[i][j-1] == 'O') {
            check(i, j-1);
        }
        if (j < y-1 && !checked[i][j+1] && board[i][j+1] == 'O') {
            check(i, j+1);
        }
    }

    /**
     * 131. Palindrome Partitioning
     *
     * 1 <= s.length <= 16
     * s contains only lowercase English letters.
     *
     * 13ms
     */
    private String s;
    private List<List<String>>[] partitionDp;
    public List<List<String>> partition(String s) {
        int len = s.length();
        this.s = s;
        partitionDp = new List[len + 1];
        partitionDp[len] = new ArrayList<>();
        partitionDp[len].add(new ArrayList<>());

        return partition(s, 0);
    }
    private List<List<String>> partition(String s, int start) {
        if (start >= s.length()) {
            return partitionDp[s.length()];
        }
        if (partitionDp[start] != null) {
            return partitionDp[start];
        }

        partitionDp[start] = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(start, i)) {
                List<List<String>> subRes = partition(s, i + 1);
                for (List<String> subList: subRes) {
                    List<String> list = new ArrayList<>();
                    list.add(s.substring(start, i + 1));
                    list.addAll(subList);
                    partitionDp[start].add(list);
                }
            }
        }
        return partitionDp[start];
    }
    private boolean isPalindrome(int x, int y) {
        if (x >= y) {
            return true;
        }
        else {
            return isPalindrome(x + 1, y - 1) && s.charAt(x) == s.charAt(y);
        }
    }

//    /**
//     * 解法一
//     *
//     * 36ms 5.5%
//     */
//    private String partitionS;
//    private ArrayList<LinkedList<String>>[] partitionDp;
//    public List<List<String>> partition(String s) {
//        partitionS = s;
//        partitionDp = new ArrayList[s.length()+1];
//        partitionDp[s.length()] = new ArrayList<>();
//        partitionDp[s.length()].add(new LinkedList<>());
//
//        List<List<String>> result = new ArrayList<>();
//        ArrayList<LinkedList<String>> lists = getPartition(0);
//        result.addAll(lists);
//        return result;
//    }
//    private ArrayList<LinkedList<String>> getPartition(int i) {
//        if (i >= partitionS.length()) {
//            return partitionDp[partitionS.length()];
//        }
//        if (partitionDp[i] != null) {
//            return partitionDp[i];
//        }
//
//        partitionDp[i] = new ArrayList<>();
//        for (int j = i; j < partitionS.length(); j++) {
//            if (isPalindrome(i, j)) {
//                ArrayList<LinkedList<String>> subResult = getPartition(j+1);
//                for (LinkedList<String> list :
//                        subResult) {
//                    LinkedList<String> newList = (LinkedList<String>) list.clone();
//                    newList.addFirst(partitionS.substring(i, j+1));
//                    partitionDp[i].add(newList);
//                }
//            }
//        }
//
//        return partitionDp[i];
//    }
//    private boolean isPalindrome(int start, int end) {
//        while (start < end) {
//            if (partitionS.charAt(start) != partitionS.charAt(end)) {
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
//    }

    /**
     * 132. Palindrome Partitioning II
     *
     * 1 <= s.length <= 2000
     * s consists of lower-case English letters only.
     *
     * 20ms
     */
    private int[] resDp;
    private int[][] isPalindromeDp; // 132
    public int minCut(String s) {
        int len = s.length();
        isPalindromeDp = new int[len][len];
        resDp = new int[len];
        Arrays.fill(resDp, -1);

        return minCut(s, 0);
    }
    private int minCut(String s, int start) {
        int len = s.length();
        if (start >= len) {
            return -1;
        }
        if (resDp[start] >= 0) {
            return resDp[start];
        }

        resDp[start] = Integer.MAX_VALUE;
        for (int i = start; i < len; i++) {
            if (getPalindrome(s, start, i)) {
                resDp[start] = Math.min(resDp[start], 1 + minCut(s, i + 1));
            }
        }

        return resDp[start];
    }
    private boolean getPalindrome(String s, int x, int y) {
        if (x >= y) {
            return true;
        }
        else if (isPalindromeDp[x][y] == 0) {
            isPalindromeDp[x][y] = getPalindrome(s, x + 1, y - 1) && s.charAt(x) == s.charAt(y) ? 1 : -1;
        }
        return isPalindromeDp[x][y] == 1;
    }

//    /**
//     * 785ms
//     */
//    private int[] minCutDp;
//    private String minCutS;
//    public int minCut(String s) {
//        minCutDp = new int[s.length()];
//        Arrays.fill(minCutDp, -1);
//        minCutS = s;
//
//        return getMinCut(0);
//    }
//    private int getMinCut(int i) {
//        if (minCutDp[i] >= 0) {
//            return minCutDp[i];
//        }
//
//        minCutDp[i] = Integer.MAX_VALUE;
//        for (int j = i; j < minCutS.length(); j++) {
//            if (isPalindrome(i, j)) {
//                if (j == minCutS.length() - 1) {
//                    minCutDp[i] = 0;
//                }
//                else {
//                    minCutDp[i] = Math.min(minCutDp[i], getMinCut(j+1) + 1);
//                }
//            }
//        }
//
//        return minCutDp[i];
//    }

    /**
     * 134. Gas Station
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        List<Integer> surplus = new ArrayList<>(length);

        for (int i = 0; i < length; i++) {
            surplus.add(gas[i] - cost[i]);
        }

        return calculateNeed(surplus);
    }
    private int calculateNeed(List<Integer> surplus) {
        if (surplus.size() == 1) {
            return surplus.get(0) >= 0 ? 0 : -1;
        }
        List<Integer> compress = new ArrayList<>();
        List<Integer> headIndex = new ArrayList<>();
        int length = surplus.size();

        int start = 0;
        while (start < length && surplus.get(start) <= 0) {
            start++;
        }
        if (start == length) {
            return -1;
        }
        headIndex.add(start);

        int i = start;
        while (i < length) {
            while (i < length && surplus.get(i) >= 0) {
                i++;
            }
            while (i < length && surplus.get(i) <= 0) {
                i++;
            }if (i < length) {
                headIndex.add(i);
            }
        }

        for (int j = 0; j < headIndex.size(); j++) {
            int current = 0;
            int k = headIndex.get(j);
            do {
                current += surplus.get(k);
                k = (k + 1) % length;
            } while (k != headIndex.get((j+1) % headIndex.size()));
            compress.add(current);
        }

        int result = calculateNeed(compress);
        if (result >= 0) {
            return headIndex.get(result);
        }
        else {
            return -1;
        }
    }

    /**
     * 135. Candy
     */
    private int[] ratings;
    private int[] candies;
    public int candy(int[] ratings) {
        this.ratings = ratings;
        candies = new int[ratings.length];

        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += candy(i);
        }

        return count;
    }
    private int candy(int index) {
        if (candies[index] > 0) {
            return candies[index];
        }

        boolean smallThanLeft = (index == 0 || ratings[index] <= ratings[index - 1]),
                smallThanRight = (index == ratings.length - 1 || ratings[index] <= ratings[index + 1]),
                biggerThanLeft = !smallThanLeft,
                biggerThanRight = !smallThanRight;
        if (smallThanLeft && smallThanRight) {
            candies[index] = 1;
        }
        else if (biggerThanLeft && biggerThanRight) {
            candies[index] = Integer.max(candy(index - 1), candy(index + 1)) + 1;
        }
        else if (biggerThanLeft) {
            candies[index] = candy(index - 1) + 1;
        }
        else {
            candies[index] = candy(index + 1) + 1;
        }

        return candies[index];
    }

    /**
     * 136. Single Number
     *
     * 1 <= nums.length <= 3 * 10^4
     * -3 * 10^4 <= nums[i] <= 3 * 10^4
     * Each element in the array appears twice except for one element which appears only once.
     */
    public int singleNumber136(int[] nums) {
        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }

        return num;
    }

    /**
     * 137. Single Number II
     *
     * 1 <= nums.length <= 3 * 10^4
     * -2^31 <= nums[i] <= 2^31 - 1
     * Each element in nums appears exactly three times except for one element which appears once.
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums) {
            if (!set1.contains(num)) {
                set1.add(num);
            } else {
                set2.add(num);
            }
        }

        for (Integer num :
                set1) {
            if (!set2.contains(num)) {
                return num;
            }
        }

        return 0;
    }

    /**
     * 138. Copy List with Random Pointer
     */
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    HashMap<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node current = head, result = getCopyNode(head);

        while (current != null) {
            Node currentCopy = getCopyNode(current);

            currentCopy.next = getCopyNode(current.next);
            currentCopy.random = getCopyNode(current.random);

            current = current.next;
        }

        return result;
    }
    private Node getCopyNode(Node target) {
        if (target == null) {
            return null;
        }
        if (!nodeMap.containsKey(target)) {
            nodeMap.put(target, new Node(target.val));
        }
        return nodeMap.get(target);
    }

    /**
     * 139. Word Break
     */
    private boolean[] wordBreakDp;
    public boolean wordBreak(String s, List<String> wordDict) {
        wordBreakDp = new boolean[s.length()];
        Arrays.fill(wordBreakDp, true);
        int maxLength = 0;
        for (String str :
                wordDict) {
            maxLength = Math.max(maxLength, str.length());
        }

        return wordBreak(s, 0, wordDict, maxLength);
    }
    private boolean wordBreak(String s, int start, List<String> wordDict, int maxLength) {
        if (start >= s.length()) {
            return true;
        }
        if (!wordBreakDp[start]) {
            return false;
        }

        boolean[] lossChance = new boolean[wordDict.size()];
        for (int i = 0; start + i < s.length() && i < maxLength; i++) {
            char c = s.charAt(start+i);
            for (int j = 0; j < wordDict.size(); j++) {
                if (!lossChance[j]) {
                    if (c == wordDict.get(j).charAt(i)) {
                        if (i == wordDict.get(j).length() - 1) {
                            if (wordBreak(s, start+i+1, wordDict, maxLength)) {
                                return true;
                            }
                            lossChance[j] = true;
                        }
                    }
                    else {
                        lossChance[j] = true;
                    }
                }
            }
        }

        wordBreakDp[start] = false;
        return false;
    }
}
