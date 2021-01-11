package com.wen.repository.solution0100To0199.design;

import com.wen.repository.solution0100To0199.design.tool.Reader4;

public class Solution157 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (n > 0) {
            char[] buf4 = new char[4];
            int readLength = read4(buf4);
            if (readLength == 0) {
                break;
            }
            for (int j = 0; j < readLength && n > 0; j++) {
                buf[i++] = buf4[j];
                n--;
            }
        }

        return i;
    }
}
