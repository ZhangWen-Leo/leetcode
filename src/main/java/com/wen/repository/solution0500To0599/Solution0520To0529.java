package com.wen.repository.solution0500To0599;

public class Solution0520To0529 {
	/**
	 * 520. Detect Capital
	 *
	 * <p>1 <= word.length <= 100</p>
	 * <p>word consists of lowercase and uppercase English letters.</p>
	 */
	public boolean detectCapitalUse(String word) {
		if (isBiggerChar(word.charAt(0))) {
			if (word.length() > 1) {
				boolean secondIsBigger = isBiggerChar(word.charAt(1));
				for (int i = 2; i < word.length(); i++) {
					if (isBiggerChar((word.charAt(i))) != secondIsBigger) {
						return false;
					}
				}
			}
		} else {
			for (int i = 1; i < word.length(); i++) {
				if (isBiggerChar(word.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isBiggerChar(char c) {
		return c >= 'A' && c <= 'Z';
	}
}
