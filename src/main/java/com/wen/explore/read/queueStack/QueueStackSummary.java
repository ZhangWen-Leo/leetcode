package com.wen.explore.read.queueStack;

import java.util.List;

public class QueueStackSummary {

    /**
     * 字符串解码
     */
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        int num = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //数字
            if (isDigit(c)) {
                int j = i + 1;
                while (isDigit(s.charAt(j))) {
                    j++;
                }
                num = Integer.valueOf(s.substring(i, j));
                i = j - 1;
            }
            //括号
            else if (c == '[') {
                int start = ++i;
                int count = 1;
                while (count > 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    }
                    else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                String subString = decodeString(s.substring(start, --i));
                while (num-- > 0) {
                    stringBuilder.append(subString);
                }
            }
            else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
    private boolean isDigit(char c) {
        return c >= 48 && c < 58;
    }

    /**
     * 图像渲染
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return image;
        }

        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;

        if (sr > 0 && image[sr-1][sc] == oldColor) {
            floodFill(image, sr-1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc-1] == oldColor) {
            floodFill(image, sr, sc-1, newColor);
        }
        if (sr < image.length-1 && image[sr+1][sc] == oldColor) {
            floodFill(image, sr+1, sc, newColor);
        }
        if (sc < image[0].length-1 && image[sr][sc+1] == oldColor) {
            floodFill(image, sr, sc+1, newColor);
        }

        return image;
    }

    /**
     * 钥匙和房间
     */
    private boolean[] roomCheck;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        roomCheck = new boolean[rooms.size()];

        checkRoom(rooms, 0);

        for (boolean check :
                roomCheck) {
            if (!check) {
                return false;
            }
        }
        return true;
    }
    private void checkRoom(List<List<Integer>> rooms, int roomIndex) {
        roomCheck[roomIndex] = true;
        List<Integer> keys = rooms.get(roomIndex);

        for (int key :
                keys) {
            if (!roomCheck[key]) {
                checkRoom(rooms, key);
            }
        }
    }
}
