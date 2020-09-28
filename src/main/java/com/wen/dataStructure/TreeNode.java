package com.wen.dataStructure;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int x) { val = x; }
    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String result = String.valueOf(val);
        if (left != null || right != null) {
            result += ":: {";
            result += left == null ? "" : " left:[" + left + "]";
            result += right == null ? "" : " right:[" + right + "]";
            result += "}";
        }
        return result;
    }
}
