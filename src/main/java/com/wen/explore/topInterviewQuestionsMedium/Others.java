package com.wen.explore.topInterviewQuestionsMedium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Others {

    /**
     * 两整数之和
     */
    public int getSum(int a, int b) {
        return 0;
    }

    /**
     * 逆波兰表达式求值
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token :
                tokens) {
            if (isOperator(token)) {
                int num2 = Integer.valueOf(stack.pop());
                int num1 = Integer.valueOf(stack.pop());
                if (token.equals("+")) {
                    stack.push(String.valueOf(num1 + num2));
                }
                else if (token.equals("-")) {
                    stack.push(String.valueOf(num1 - num2));
                }
                else if (token.equals("*")) {
                    stack.push(String.valueOf(num1 * num2));
                }
                else {
                    stack.push(String.valueOf(num1 / num2));
                }
            }
            else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }
    private boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 多数元素
     */
    public int majorityElement(int[] nums) {
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            }
            else {
                if (count == 1) {
                    num = nums[i];
                    continue;
                }
                count--;
            }
        }
        return num;
    }
}
