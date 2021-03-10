package com.wen.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WenList {

    public static List getListFromString(String str) {
        str = str.replaceAll(" ", "");
        if (str.length() < 2) {
            return null;
        }
        return (List) getObjectFromString(str);
    }
    public static int[] getArrayFromList(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private static List splitWithComma(String str) {
        List result = new ArrayList();
        Stack<Integer> stack = new Stack<>();

        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '[') {
                stack.push(i);
            }
            else if (c == ']') {
                stack.pop();
            }
            else if (c == ',' && stack.isEmpty()) {
                result.add(getObjectFromString(str.substring(start, i)));
                start = i+1;
            }
        }
        result.add(getObjectFromString(str.substring(start)));
        return result;
    }

    private static Object getObjectFromString(String str) {
        if (str.length() == 0) {
            return null;
        }
        else if (str.length() == 1 || str.charAt(0) != '[') {
            if (str.equals("null")) {
                return null;
            }
            else {
                return Integer.valueOf(str);
            }
        }
        else if (str.charAt(0) == '[' && str.charAt(str.length()-1) == ']') {
            return splitWithComma(str.substring(1, str.length()-1));
        }
        else {
            System.out.println("格式错误");
            return null;
        }
    }
}
