package com.wen.common;

import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

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
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Stack<Integer> stack2 = new Stack<>();
        stack2.addAll(stack);
        Iterator<Integer> ite = stack2.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
}
