package com.wen.repository.solution0500To0599;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0500To0510 {

    /**
     * 501. 二叉搜索树中的众数
     */
    List<Integer> list = new ArrayList<>();
    int maxCount = Integer.MIN_VALUE;
    int lastNum = Integer.MIN_VALUE+1;
    int count = 0;
    public int[] findMode(TreeNode root) {
        list.clear();

        inOrderSearch(root);

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
    private void inOrderSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderSearch(root.left);
        if (root.val != lastNum) {
            count = 1;
            if (count > maxCount) {
                list.add(root.val);
                maxCount = count;
            }
            else if (count == maxCount) {
                list.add(root.val);
            }
        }
        else {
            if (++count > maxCount) {
                list.clear();
                list.add(root.val);
                maxCount = count;
            }
            else if (count == maxCount) {
                list.add(root.val);
            }
        }
        lastNum = root.val;
        inOrderSearch(root.right);
    }
}
