package com.wen.repository.solution0300To0399;

public class Solution0340To0349 {

    /**
     * 344. Reverse String
     */
    public void reverseString(char[] s) {
        int start, end;
        char c;

        start = 0;
        end = s.length-1;

        while (start < end) {
            c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }

        return;
    }
}
