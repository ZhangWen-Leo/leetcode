package com.wen.repository.solution0900To0999;

public class Solution0920To0929 {

    /**
     * 925. Long Pressed Name
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) {
            return false;
        }

        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            char c = name.charAt(i);
            int count = 1;
            i++;
            while (i < name.length() && name.charAt(i) == c) {
                i++;
                count++;
            }

            while (count > 0) {
                if (j >= typed.length() || typed.charAt(j) != c) {
                    return false;
                }
                else {
                    count--;
                    j++;
                }
            }
            while (j < typed.length() && typed.charAt(j) == c) {
                j++;
            }
        }
        if (i < name.length() || j < typed.length()) {
            return false;
        }
        else {
            return true;
        }
    }
}
