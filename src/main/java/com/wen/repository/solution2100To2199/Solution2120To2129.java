package com.wen.repository.solution2100To2199;

public class Solution2120To2129 {
	/**
	 * 2129. Capitalize the Title
	 *
	 * <p>1 <= title.length <= 100</p>
	 * <p>title consists of words separated by a single space without any leading or trailing spaces.</p>
	 * <p>Each word consists of uppercase and lowercase English letters and is <b>non-empty</b>.</p>
	 */
	public String capitalizeTitle(String title) {
		StringBuilder resultBuilder = new StringBuilder(title.length());
		String[] words = title.split(" ");
		for (String word : words) {
			if (word.length() <= 2) {
				resultBuilder.append(word.toLowerCase());
			} else {
				resultBuilder.append(toUpperCase(word.charAt(0)));
				resultBuilder.append(word.toLowerCase().substring(1));
			}
			resultBuilder.append(" ");
		}
		resultBuilder.deleteCharAt(resultBuilder.length() - 1);
		return resultBuilder.toString();
	}

	private char toUpperCase(char c) {
		if (c >= 'a' && c <= 'z') {
			return (char) (c - 'a' + 'A');
		}
		return c;
	}
}
