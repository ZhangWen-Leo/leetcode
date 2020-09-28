package com.wen.explore.read.arrayAndString;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringAlgorithmTest {

    private StringAlgorithm stringAlgorithm = new StringAlgorithm();

    @Test
    public void longestCommonPrefix() {
        String[] strings = new String[]{
                "aaa",
                "aa"
        };
        System.out.println(stringAlgorithm.longestCommonPrefix(strings));
    }

    @Test
    public void longestPalindrome() {
        String s = "ccc";
        System.out.println(stringAlgorithm.longestPalindrome(s));
    }
}