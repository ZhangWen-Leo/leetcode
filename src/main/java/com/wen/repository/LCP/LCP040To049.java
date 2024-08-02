package com.wen.repository.LCP;

import java.util.Arrays;

public class LCP040To049 {
	/**
	 * LCP 40. 心算挑战
	 *
	 * <p>1 <= cnt <= cards.length <= 10^<sup>5</sup></p>
	 * <p>1 <= cards[i] <= 1000</p>
	 */
	public int maxmiumScore(int[] cards, int cnt) {
		Arrays.sort(cards);

		int minEven = Integer.MAX_VALUE;
		int minOdd = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < cnt; i++) {
			int index = cards.length - 1 - i;
			sum += cards[index];
			if (cards[index] % 2 == 0) {
				minEven = cards[index];
			} else {
				minOdd = cards[index];
			}
		}

		if (sum % 2 == 0) {
			return sum;
		} else {
			int maxEven = 0, maxOdd = 0;
			for (int i = cards.length - cnt - 1; i >= 0; i--) {
				if (cards[i] % 2 == 0) {
					if (maxEven == 0) {
						maxEven = cards[i];
					}
				} else {
					if (maxOdd == 0) {
						maxOdd = cards[i];
					}
				}
				if (maxEven != 0 && maxOdd != 0) {
					break;
				}
			}
			int a = maxEven == 0 ? 0 : sum + maxEven - minOdd;
			int b = maxOdd == 0 ? 0 : sum + maxOdd - minEven;

			return Math.max(a, b);
		}
	}
}
