package com.wen.repository.solution0200To0299;

public class Solution0210To0219 {

    /**
     * 214. Shortest Palindrome
     */
    public String shortestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        int palindromeLastIndex = findIndex(s);

        for (int i = s.length()-1; i > palindromeLastIndex; i--) {
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(s);

        return stringBuilder.toString();
    }
    private int findIndex(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(0)) {
                int a = 0, b = i;
                while (a < b && s.charAt(a) == s.charAt(b)) {
                    a++;
                    b--;
                }
                if (a >= b) {
                    return i;
                }
            }
        }
        return 0;
    }
}
