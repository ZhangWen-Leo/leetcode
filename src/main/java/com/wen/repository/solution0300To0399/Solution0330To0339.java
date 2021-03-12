package com.wen.repository.solution0300To0399;

import java.util.List;

public class Solution0330To0339 {

    /**
     * 331. Verify Preorder Serialization of a Binary Tree
     *
     *
     * @param preorder  一个二叉树的前序遍历序列，#代表null    “1,#,2,#,#”
     * @return          返回preorder是否能有效构建一个二叉树
     */
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int len = nodes.length;
        int num = 1;

        for (int i = 0; i < len; i++) {
            if (nodes[i].equals("#")) {
                num--;
                if (num == 0) {
                    return i == len - 1;
                }
            }
            else {
                num++;
            }
        }

        return num == 0;
    }

    /**
     * 336. Palindrome Pairs
     *
     * 1 <= words.length <= 5000
     * 0 <= words[i] <= 300
     * words[i] consists of lower-case English letters.
     *
     * TODO
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        return null;
    }

    /**
     * 338. Counting Bits
     */
    public int[] countBits(int num) {
        int len = num + 1;
        int[] res = new int[len];
        if (len > 0) {
            res[0] = 0;
        }
        if (len > 1) {
            res[1] = 1;
        }

        int i = 2, j = 0, from = 2;
        while (i < len) {
            res[i++] = 1 + res[j++];
            if (j >= from) {
                j = 0;
                from = i;
            }
        }

        return res;
    }
}
