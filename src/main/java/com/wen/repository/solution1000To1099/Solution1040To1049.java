package com.wen.repository.solution1000To1099;

public class Solution1040To1049 {

    /**
     * 1047. Remove All Adjacent Duplicates In String
     */
    public String removeDuplicates(String S) {
        int len = S.length();
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; i++) {
            if (i < len - 1 && S.charAt(i) == S.charAt(i + 1)) {
                i++;
            }
            else {
                if (res.length() > 0 && S.charAt(i) == res.charAt(res.length() - 1)) {
                    res.deleteCharAt(res.length() - 1);
                }
                else {
                    res.append(S.charAt(i));
                }
            }
        }

        return res.toString();
    }
}
