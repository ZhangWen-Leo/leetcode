package com.wen.explore.read.queueStack;

import java.util.*;

public class StackBasicAlgorithm {
    /**
     * 有效的括号
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
            }
            else if (ch == ']') {
                if (stack.empty() || stack.pop() != '[') {
                    return false;
                }
            }
            else if (ch == '}') {
                if (stack.empty() || stack.pop() != '{') {
                    return false;
                }
            }
            else {
                System.out.println("无效符号");
            }
        }

        if (stack.empty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 每日温度
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];

        if (T.length == 0) {
            return result;
        }

        stack.push(T.length-1);
        result[T.length-1] = 0;
        for (int i = T.length-2; i >= 0; i--) {
            if (T[i] >= T[stack.peek()]) {
                while (!stack.empty() && T[i] >= T[stack.peek()]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    result[i] = 0;
                }
                else {
                    result[i] = stack.peek() - i;
                }
            }
            else {
                result[i] = 1;
            }
            stack.push(i);
        }

        return result;
    }

    /**
     * 克隆图
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        int[] check = new int[100]; // 0表示节点未创建，1表示节点已创建，2表示节点已链接
        Node[] nodes = new Node[100];

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node currentNode = stack.peek();
            int index = currentNode.val - 1;

            if (check[index] == 0) {
                nodes[index] = new Node(currentNode.val);
                check[index] = 1;
            }
            if (check[index] == 1) {
                for (Node eachNode :
                        currentNode.neighbors) {
                    if (check[eachNode.val - 1] == 0) {
                        nodes[eachNode.val - 1] = new Node(eachNode.val);
                        check[eachNode.val - 1] = 1;
                    }
                    if (check[eachNode.val - 1] >= 1) {
                        nodes[index].neighbors.add(nodes[eachNode.val - 1]);
                    }
                }
                check[index] = 2;
            }
            if (check[index] == 2) {
                int i = 0;
                while (i < currentNode.neighbors.size()) {
                    if (check[currentNode.neighbors.get(i).val - 1] == 1) {
                        stack.push(currentNode.neighbors.get(i));
                        break;
                    }
                    i++;
                }
                if (i == currentNode.neighbors.size()) {
                    stack.pop();
                }
            }
        }

        return nodes[node.val - 1];
    }

    /**
     * 目标和
     */
    private int waysCount = 0;
    public int findTargetSumWays(int[] nums, int S) {
        waysCount = 0;
        myFindTargetSumWays(nums, S, 0);
        return waysCount;
    }
    private void myFindTargetSumWays(int[] nums, int S, int start) {
        if (start >= nums.length) {
            if (S == 0) {
                waysCount++;
            }
        }
        else {
            myFindTargetSumWays(nums, S - nums[start], start+1);
            myFindTargetSumWays(nums, S + nums[start], start+1);
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
