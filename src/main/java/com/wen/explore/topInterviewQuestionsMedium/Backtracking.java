package com.wen.explore.topInterviewQuestionsMedium;

import java.util.*;

public class Backtracking {
    /**
     * 电话号码的字母组合
     */
    String[][] map = {
            {},
            {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };
    String currentString = "";
    List<String> letterList = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return letterList;
        }
        myLetterCombinations(digits);
        return letterList;
    }
    private void myLetterCombinations(String digits) {
        if (digits.length() == 0) {
            letterList.add(currentString);
            return;
        }
        String[] stringList = map[Integer.parseInt(digits.substring(0, 1))];
        for (int i = 0; i < stringList.length; i++) {
            currentString += stringList[i];
            myLetterCombinations(digits.substring(1));
            currentString = currentString.substring(0, currentString.length()-1);
        }
    }

    /**
     * 括号生成
     */
    List<String> parenthesisList = new ArrayList<>();
    String currentParenthesis = "";
    public List<String> generateParenthesis(int n) {
        myGenerateParenthesis(n, n);
        return parenthesisList;
    }
    private void myGenerateParenthesis(int left, int right) {
        if (left > 0) {
            currentParenthesis += "(";
            myGenerateParenthesis(left-1, right);
            currentParenthesis = currentParenthesis.substring(0, currentParenthesis.length()-1);
        }
        if (right > left) {
            currentParenthesis += ")";
            myGenerateParenthesis(left, right-1);
            currentParenthesis = currentParenthesis.substring(0, currentParenthesis.length()-1);
        }
        if (left == 0 && right == 0) {
            parenthesisList.add(currentParenthesis);
        }
    }

    /**
     * 全排列
     * 见46
     */

    /**
     * 子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        return mySubsets(nums, 0);
    }
    private List<List<Integer>> mySubsets(int[] nums, int start) {
        List<List<Integer>> subsetsLists = new ArrayList<>();
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            subsetsLists.add(list);
            return subsetsLists;
        }

        int val = nums[start];

        List<List<Integer>> subLists = mySubsets(nums, start+1);
        subsetsLists.addAll(subLists);
        for (List<Integer> subList :
                subLists) {
            List<Integer> newList = new ArrayList<>(subList);
            newList.add(val);
            subsetsLists.add(newList);
        }

        return subsetsLists;
    }

    /**
     * 单词搜索
     * 见79
     */
}
