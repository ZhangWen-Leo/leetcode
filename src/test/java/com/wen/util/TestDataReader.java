package com.wen.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDataReader {

	private final static String intArrayPatternString = "\\s*\\[\\s*(\\d+\\s*(,\\s*\\d+\\s*)*)?]\\s*";
	private final static String int2DArrayPatternString = String.format("\\s*\\[\\s*(%s\\s*(,\\s*%s\\s*)*)?]\\s*", intArrayPatternString, intArrayPatternString);
	public static int[] getIntArrayFromString(String text) {
		Pattern pattern = Pattern.compile(String.format("^%s$", intArrayPatternString));
		Matcher matcher = pattern.matcher(text);
		if (!matcher.find()) {
			throw new Error("非法字符串");
		}
		String[] stringNumbers = Arrays.stream(
			text
				.replaceAll("^\\s*\\[", "")
				.replaceAll("]\\s*$", "")
				.split(",")
		).map(String::trim).toArray(String[]::new);
		return Arrays.stream(stringNumbers).mapToInt(Integer::parseInt).toArray();
	}
	public static int[][] getInt2DArrayFromString(String text) {
		Pattern pattern = Pattern.compile(String.format("^%s$", int2DArrayPatternString));
		Matcher matcher = pattern.matcher(text);
		if (!matcher.find()) {
			throw new Error("非法字符串");
		}
		String[] stringNumbers = Arrays.stream(
			text
				.replaceAll("^\\s*\\[", "")
				.replaceAll("]\\s*$", "")
				.replaceAll("]\\s*,", "]\0")
				.split("\0")
		).map(String::trim).toArray(String[]::new);
		return Arrays.stream(stringNumbers).map(TestDataReader::getIntArrayFromString).toArray(int[][]::new);
	}
}
