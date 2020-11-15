package com.wen.repository.solution0300To0399;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution0350To0359 {

    /**
     * 354. Russian Doll Envelopes
     *
     * 本解答采用了数组envelopeResults存储：当第i个信封为最外层信封时，最大的信封层数
     * 存在更优解答
     */
    private int[] envelopeResults;
    private int[][] envelopeIntervals;
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        envelopeIntervals = envelopes;
        envelopeResults = new int[envelopes.length];

        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            max = Integer.max(max, getEnvelopeResult(i));
        }

        return max;
    }
    private int getEnvelopeResult(int i) {
        if (envelopeResults[i] > 0) {
            return envelopeResults[i];
        }

        int max = 1;
        for (int j = 0; j < envelopeIntervals.length; j++) {
            if (
                    envelopeIntervals[j][0] < envelopeIntervals[i][0]
                    && envelopeIntervals[j][1] < envelopeIntervals[i][1]
            ) {
                max = Integer.max(max, getEnvelopeResult(j) + 1);
            }
        }

        envelopeResults[i] = max;
        return max;
    }

    /**
     * 358. Rearrange String k Distance Apart
     *
     * All input strings are given in lowercase letters.
     */
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        int[] countList = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            countList[s.charAt(i)-'a']++;
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < countList.length; i++) {
            if (countList[i] > 0) {
                queue.offer(new int[]{i, countList[i]});
            }
        }

        Queue<int[]> waitQueue = new LinkedList<>();

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            result.append((char) (node[0]+'a'));
            node[1]--;
            waitQueue.offer(node);

            while (waitQueue.size() >= k) {
                int[] nodeP = waitQueue.poll();
                if (nodeP[1] > 0) {
                    queue.offer(nodeP);
                }
            }
        }
        while (!waitQueue.isEmpty()) {
            if (waitQueue.poll()[1] > 0) {
                return "";
            }
        }
        return result.toString();
    }
}
