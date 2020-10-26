package com.wen.repository.solution1000To1099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1020To1029 {

    /**
     * 1024. Video Stitching
     */
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        List<int[]> list = new ArrayList<>();

        for (int[] clip :
                clips) {
            list.add(clip);
        }

        return videoStitching(list, T);
    }
    private int videoStitching(List<int[]> clips, int T) {
        if (T == 0) {
            return 0;
        }

        int min = T + 1;
        for (int i = clips.size() - 1; i >= 0 && clips.get(i)[1] >= T; i--) {
            min = Integer.min(min, clips.get(i)[0]);
            clips.remove(i);
        }

        if (min == T + 1) {
            return -1;
        }
        else {
            int sub = videoStitching(clips, min);
            return sub == -1 ? -1 : sub + 1;
        }
    }
}
