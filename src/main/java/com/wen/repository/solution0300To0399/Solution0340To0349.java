package com.wen.repository.solution0300To0399;

import java.util.*;

public class Solution0340To0349 {

    /**
     * 341. Flatten Nested List Iterator
     *
     * 见design/NestedIterator
     */

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

    /**
     * 349. Intersection of Two Arrays
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> list = new HashSet<>();

        for (int num :
                nums1) {
            set.add(num);
        }

        for (int num :
                nums2) {
            if (set.contains(num)) {
                list.add(num);
            }
        }

        int[] result = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i++] = iterator.next();
        }

        return result;
    }
}
