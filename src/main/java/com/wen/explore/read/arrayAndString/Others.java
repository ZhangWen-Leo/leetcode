package com.wen.explore.read.arrayAndString;

import java.util.ArrayList;
import java.util.List;

public class Others {
    /**
     * 杨辉三角
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i+1);
            for (int j = 0; j <= i; j++) {
                if (j <= i / 2) {
                    if (j == 0) {
                        list.add(1);
                    }
                    else {
                        List<Integer> last = lists.get(i-1);
                        list.add(last.get(j-1) + last.get(j));
                    }
                }
                else {
                    list.add(list.get(i-j));
                }
            }
            lists.add(list);
        }

        return lists;
    }
}
