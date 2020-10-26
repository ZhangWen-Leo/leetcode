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

    /**
     * 845. Longest Mountain in Array
     */
    public int longestMountain(int[] A) {
        int max = 0;
        int start = 0;
        while (start < A.length - 2) {
            while (start < A.length - 2 && A[start] >= A[start + 1]) {
                start++;
            }

            int top = start + 1;
            while (top < A.length - 1 && A[top] < A[top+1]) {
                top++;
            }

            int end = top;
            while (end < A.length - 1 && A[end] > A[end+1]) {
                end++;
            }
            if (end != top) {
                max = Integer.max(max, end - start + 1);
            }
            start = end;
        }

        return max;
    }
}
