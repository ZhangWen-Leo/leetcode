package com.wen.explore.read.arrayAndString;

import java.util.Stack;

public class StringAlgorithm {
    /**
     * 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();

        if (strs.length != 0) {
            if (strs.length > 1) {
                String checkStr = strs[0];
                for (int i = 0; i < checkStr.length(); i++) {
                    boolean check = true;
                    char checkCh = checkStr.charAt(i);
                    for (String str :
                            strs) {
                        if (i >= str.length() || str.charAt(i) != checkCh) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        stringBuilder.append(checkCh);
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                stringBuilder.append(strs[0]);
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 最长回文子串
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i-1) == s.charAt(i)) {
                for (int j = 1; i - j >= 0 && i + j - 1 < s.length();) {
                    if (s.charAt(i-j) == s.charAt(i+j-1)) {
                        if (j * 2 > max) {
                            max = j * 2;
                            start = i - j;
                            end = i + j;
                        }
                        j++;
                    }
                    else {
                        break;
                    }
                }
            }
            for (int j = 0; i - j >= 0 && i + j < s.length();) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    if (2 * j + 1 > max) {
                        max = 2 * j + 1;
                        start = i - j;
                        end = i + j + 1;
                    }
                    j++;
                }
                else {
                    break;
                }
            }
        }

        return s.substring(start, end);
    }

    /**
     * 翻转字符串里的单词
     */
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }

            int start = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }

            if (start < i) {
                stack.push(s.substring(start, i));
            }
        }

        while (!stack.empty()) {
            result.append(stack.pop());
            result.append(' ');
        }
        if (result.length() > 0) {
            result.deleteCharAt(result.length()-1);
        }

        return result.toString();
    }
}
