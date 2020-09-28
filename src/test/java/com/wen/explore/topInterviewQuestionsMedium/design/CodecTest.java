package com.wen.explore.topInterviewQuestionsMedium.design;

import com.wen.dataStructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CodecTest {

    private Codec codec = new Codec();

    @Test
    public void serialize() {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4, null, t5);
        TreeNode t3 = new TreeNode(3, null, t4);
        TreeNode t2 = new TreeNode(2, null, t3);
        TreeNode t1 = new TreeNode(1, null, t2);
        System.out.println(codec.serialize(t1));
    }

    @Test
    public void deserialize() {
        String s = "[1,2,3,null,null,4,5]";
        System.out.println(codec.deserialize(s));
    }

    @Test
    public void test() {
        int length = 100;
        System.out.println(length >> 1);
    }
}