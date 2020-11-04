package com.wen.repository.solution0300To0399;

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
}
