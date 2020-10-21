package com.wen.repository.solution0800To0899;

public class Solution0840To0849 {

    /**
     * 844. Backspace String Compare
     */
    public boolean backspaceCompare(String S, String T) {
        String compressedS = compressString(S);
        String compressedT = compressString(T);

        return compressedS.equals(compressedT);
    }
    private String compressString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);

        int i = 0;
        while (i < stringBuilder.length()) {
            if (stringBuilder.charAt(i) == '#') {
                if (i > 0) {
                    i--;
                    stringBuilder.deleteCharAt(i);
                }
                stringBuilder.deleteCharAt(i);
            }
            else {
                i++;
            }
        }

        return stringBuilder.toString();
    }
}
