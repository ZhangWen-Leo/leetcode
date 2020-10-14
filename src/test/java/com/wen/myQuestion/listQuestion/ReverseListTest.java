package com.wen.myQuestion.listQuestion;

import com.wen.dataStructure.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseListTest {

    ReverseList solution = new ReverseList();

    @Test
    public void reverseByRecursion() {
        int[] list = {
                1,2,3,4,5,6
        };
        System.out.println(solution.reverseByRecursion(ListNode.createList(list)));
    }
}