package com.wen.repository.solution2400To2499;

import java.util.ArrayList;
import java.util.List;

public class Solution2470To2479 {

  /**
   * 2476. Closest Nodes Queries in a Binary Search Tree
   *
   * <p>The number of nodes in the tree is in the range [2, 10^5].</p>
   * <p>1 <= Node.val <= 10^6</p>
   * <p>n == queries.length</p>
   * <p>1 <= n <= 10^5</p>
   * <p>1 <= queries[i] <= 10^6</p>
   */
  public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
    ArrayList<Integer> list = new ArrayList<>();
    transformSearchTreeToList(root, list);
    List<List<Integer>> result = new ArrayList<>(queries.size());

    for (int query : queries) {
      ArrayList<Integer> res = new ArrayList<>(2);
      res.add(Integer.MIN_VALUE);
      res.add(Integer.MAX_VALUE);
      binarySearch(list, query, 0, list.size(), res);
      if (res.get(0) == Integer.MIN_VALUE) {
        res.set(0, -1);
      }
      if (res.get(1) == Integer.MAX_VALUE) {
        res.set(1, -1);
      }
      result.add(res);
    }

    return result;
  }

  private void transformSearchTreeToList(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    transformSearchTreeToList(root.left, list);
    list.add(root.val);
    transformSearchTreeToList(root.right, list);
  }

  private void binarySearch(ArrayList<Integer> list, int query, int left, int right, ArrayList<Integer> result) {
    if (left >= right) {
      return;
    }
    int middle = (left + right) / 2;
    int middleNum = list.get(middle);
    if (middleNum < query) {
      result.set(0, middleNum);
      binarySearch(list, query, middle + 1, right, result);
    } else if (middleNum > query) {
      result.set(1, middleNum);
      binarySearch(list, query, left, middle, result);
    } else {
      result.set(0, middleNum);
      result.set(1, middleNum);
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
