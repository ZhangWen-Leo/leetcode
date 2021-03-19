package com.wen.common;

import com.wen.dataStructure.ListNode;
import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import java.util.*;

public class CommonTest {

    @Test
    public void test1() {
        System.out.println((int) '0');
    }

    @Test
    public void test2() {
        System.out.println(50 + (50 >> 1));
    }

    @Test
    public void test3() {
        double a = 0.1;
        double b = 0.2;
        double c = 0.3;
        System.out.println(Math.abs(a + b - c) < 0.0000001);
    }

    @Test
    public void test4() {
        ListNode a = ListNode.createList(new int[]{-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5});
    }

    @Test
    public void test5() {
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test6() {
        TreeNode t = TreeNode.buildTree(new Integer[]{1,0,10,null,null,4});
        System.out.println(t);
    }

    @Test
    public void testForString() {
        String a = "helo";
        String b = a;
        b = "1" + b;
        System.out.println(a);
    }

    @Test
    public void testForArray() {
        int[] a = {1, 2};
        int[] b = {1, 2};
        System.out.println(a.equals(b));
    }

    @Test
    public void testForSet() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Set> sets = new HashSet<>();
        set1.add(1);
        set2.add(2);
        set3.add(3);
        sets.add(set1);
        sets.add(set2);
        sets.add(set3);
        sets.remove(set2);
        return;
    }

    @Test
    public void testForBinary() {
        int x = -2;
        System.out.println(x % 2);
    }
}
