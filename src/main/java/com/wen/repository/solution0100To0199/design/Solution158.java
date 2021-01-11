package com.wen.repository.solution0100To0199.design;

import com.wen.repository.solution0100To0199.design.tool.Reader4;

public class Solution158 extends Reader4 {
    private char[] buf4 = new char[4];
    private int length = 0;
    private int start = 0;
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        if (start < length) {
            while (start < length && n > 0) {
                buf[i++] = buf4[start++];
                n--;
            }
        }

        while (n > 0) {
            length = read4(buf4);
            start = 0;
            if (length == 0) {
                break;
            }
            while (start < length && n > 0) {
                buf[i++] = buf4[start++];
                n--;
            }
        }

        return i;
    }
}
