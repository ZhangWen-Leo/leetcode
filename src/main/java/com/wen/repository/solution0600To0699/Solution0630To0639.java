package com.wen.repository.solution0600To0699;

import com.wen.dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution0630To0639 {
    /**
     * 637. 二叉树的层平均值
     */
    List<double[]> averageList = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        averageOfList(root, 0);
        List<Double> list = new ArrayList<>();
        for (double[] averages :
                averageList) {
            list.add(averages[0]);
        }

        return list;
    }
    private void averageOfList(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        while (level >= averageList.size()) {
            double[] averages = new double[2];
            averageList.add(averages);
        }

        double count = averageList.get(level)[1];
        double sum = averageList.get(level)[0] * count;
        sum += root.val;
        averageList.get(level)[0] = sum / (++count);
        averageList.get(level)[1] = count;
        averageOfList(root.left, level+1);
        averageOfList(root.right, level+1);
    }
}
